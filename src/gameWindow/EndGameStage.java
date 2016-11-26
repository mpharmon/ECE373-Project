package gameWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameExecution.GameData;

public class EndGameStage extends JFrame {
	
	private int windowId;

	private JPanel contentPane;
	
	private DestinationPanel destPanel;
	private FinalScorePanel scorePanel;
	public static DecimalFormat scoreFormat = new DecimalFormat("###,###,###,###");

	/**
	 * Create the frame.
	 */
	public EndGameStage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		windowId = 6;
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setVisible(false);
		initDestinationPanel(false);
		initScorePanel(false);
	}
	
	public void initDestinationPanel(boolean show){
		contentPane.setLayout(null);
		destPanel = new DestinationPanel();
		destPanel.setBounds(0, 0, 1280, 720);
		destPanel.setVisible(show);
		getContentPane().add(destPanel);
	}
	
	public void initScorePanel(boolean show){
		
		scorePanel = new FinalScorePanel();
		scorePanel.setBounds(0, 0, 1280, 720);
		scorePanel.setVisible(show);
		getContentPane().add(scorePanel);
	}
	
	public boolean updateEndGame(GameData gameData){
		
		if(!destPanel.isDestinationActive()) destPanel.displayDestination(gameData);
		
		if(destPanel.isScore() && !scorePanel.isScoreActive()){
			destPanel.setVisible(false);
			scorePanel.displayScoreScreen(gameData);
		}
		
		if(scorePanel.isContinue()) return true;
		
		return false;
	}
	
	public void displayDestination(GameData gameData){
		destPanel.displayDestination(gameData);
	}
	 

	public DestinationPanel getDestPanel(){
		return destPanel;
	}
	public FinalScorePanel getScorePanel(){
		return scorePanel;
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

}
