package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.HighScore;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class StartMenu extends JFrame {

	private int windowId;
	
	private StartPanel startPanel;
	private HighScorePanel highScorePanel;

	public StartMenu() {
		windowId = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(0,0,1280,720);
		
		initStartPanel();
		initHighScorePanel();
		setVisible(true);
	}
	
	public void initStartPanel(){
		startPanel = new StartPanel();
		startPanel.setBounds(0, 0, 1280, 720);
		add(startPanel);
	}


	public void initHighScorePanel(){
		highScorePanel = new HighScorePanel();
		highScorePanel.setBounds(0, 0, 1280, 720);
		add(highScorePanel);
	}
	

	// Checks whether any of the three buttons were clicked
	public int checkButtons() {
		if(!highScorePanel.isStartMenu()){
			if (startPanel.isStartBtn() && !startPanel.isHighScoreBtn() && !startPanel.isExitBtn()){
				return 1;
			}else if (!startPanel.isStartBtn() && startPanel.isHighScoreBtn() && !startPanel.isExitBtn()){
				startPanel.setVisible(false);
				if(!highScorePanel.isUpdated()) highScorePanel.displayHighScores();
				return 2;
			}else if (startPanel.isExitBtn()){
				return 3;
			}else{
				startPanel.setVisible(true);
				highScorePanel.setVisible(false);
				return 0;
			}
		}else if(highScorePanel.isStartMenu()){
				startPanel.buttonReset();
				startPanel.setVisible(true);
				highScorePanel.setStartMenu(false);
				highScorePanel.setUpdated(false);
				highScorePanel.setVisible(false);
		}
		return 0;
	}
	//Saves score data and returns user back to start menu w/gameData reset
	public void restart(){
		GameData.UserScore.setScore(FinalScorePanel.result);
		GameData.UserScore.setShipID(GameData.spacecraft.getId());
		System.out.println(GameData.UserScore.toString());
		highScorePanel.getHighScore().addScore(GameData.UserScore);
		highScorePanel.getHighScore().printData();
		HighScore.saveData(highScorePanel.getHighScore());
		highScorePanel.getHighScore().printData();
		startPanel.buttonReset();
		GameData.initialize(); 
		setVisible(true);
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}


	public StartPanel getStartPanel() {
		return startPanel;
	}

	public void setStartPanel(StartPanel startPanel) {
		this.startPanel = startPanel;
	}
	
	public HighScorePanel getHighScorePanel() {
		return highScorePanel;
	}

}
