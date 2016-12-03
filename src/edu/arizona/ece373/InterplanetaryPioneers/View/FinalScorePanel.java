package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.CustomPlayer;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.SongPath;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalScorePanel extends JPanel {
	private boolean scoreActive = false;
	private boolean proceed = false;
	private int SF_CNT = 0;
	private Timer scoreTimer;
	private boolean update = false;
	private Integer base = 0;
	
	public static int result = 0;
	
	private JTextField textFinalScore;
	private JTextField txtDestination;
	private JTextField txtShip;
	private JTextField txtCrewAlive;
	private JTextField txtEvents;
	private JTextField txtFood;
	private JTextField txtWater;
	private JTextField txtParts;
	private JTextField txtBotanists;
	private JTextField txtDifficulty;
	private JLabel lblDifficultyIcon;
	private CustomPlayer player;
	private JButton btnContinue; 
	
	/**
	 * Create the panel.
	 */
	public FinalScorePanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Colony Score");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Slider", Font.PLAIN, 36));
		lblNewLabel.setBounds(550, 11, 242, 38);
		add(lblNewLabel);
		
		JLabel lblBase = new JLabel("Spacecraft:");
		lblBase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBase.setForeground(Color.CYAN);
		lblBase.setFont(new Font("Slider", Font.PLAIN, 22));
		lblBase.setBounds(246, 125, 186, 22);
		add(lblBase);
		
		txtShip = new JTextField();
		txtShip.setEnabled(false);
		txtShip.setText("0");
		txtShip.setOpaque(false);
		txtShip.setHorizontalAlignment(SwingConstants.RIGHT);
		txtShip.setForeground(Color.CYAN);
		txtShip.setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.setEditable(false);
		txtShip.setColumns(10);
		txtShip.setBorder(null);
		txtShip.setBounds(457, 125, 400, 28);
		add(txtShip);
		
		JLabel lblDest = new JLabel("Destination:");
		lblDest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDest.setForeground(Color.CYAN);
		lblDest.setFont(new Font("Slider", Font.PLAIN, 22));
		lblDest.setBounds(246, 158, 186, 22);
		add(lblDest);
		
		txtDestination = new JTextField();
		txtDestination.setEnabled(false);
		txtDestination.setBorder(null);
		txtDestination.setText("0");
		txtDestination.setOpaque(false);
		txtDestination.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDestination.setForeground(Color.CYAN);
		txtDestination.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDestination.setEditable(false);
		txtDestination.setColumns(10);
		txtDestination.setBounds(467, 155, 390, 28);
		add(txtDestination);
		
		JLabel lblBotanist = new JLabel("Botanists:");
		lblBotanist.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBotanist.setForeground(Color.CYAN);
		lblBotanist.setFont(new Font("Slider", Font.PLAIN, 22));
		lblBotanist.setBounds(246, 188, 186, 22);
		add(lblBotanist);
		
		txtBotanists = new JTextField();
		txtBotanists.setEnabled(false);
		txtBotanists.setText("0");
		txtBotanists.setOpaque(false);
		txtBotanists.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBotanists.setForeground(Color.CYAN);
		txtBotanists.setFont(new Font("Slider", Font.PLAIN, 22));
		txtBotanists.setEditable(false);
		txtBotanists.setColumns(10);
		txtBotanists.setBorder(null);
		txtBotanists.setBounds(467, 185, 390, 28);
		add(txtBotanists);
		
		JLabel lblCrewAlive = new JLabel("Crew Alive:");
		lblCrewAlive.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewAlive.setForeground(Color.CYAN);
		lblCrewAlive.setFont(new Font("Slider", Font.PLAIN, 22));
		lblCrewAlive.setBounds(246, 216, 186, 22);
		add(lblCrewAlive);
		
		txtCrewAlive = new JTextField();
		txtCrewAlive.setEnabled(false);
		txtCrewAlive.setText("0");
		txtCrewAlive.setOpaque(false);
		txtCrewAlive.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCrewAlive.setForeground(Color.CYAN);
		txtCrewAlive.setFont(new Font("Slider", Font.PLAIN, 22));
		txtCrewAlive.setEditable(false);
		txtCrewAlive.setColumns(10);
		txtCrewAlive.setBorder(null);
		txtCrewAlive.setBounds(467, 213, 390, 28);
		add(txtCrewAlive);
		
		JLabel lblEvents = new JLabel("Events Encountered:");
		lblEvents.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvents.setForeground(Color.CYAN);
		lblEvents.setFont(new Font("Slider", Font.PLAIN, 22));
		lblEvents.setBounds(192, 246, 240, 22);
		add(lblEvents);
		
		txtEvents = new JTextField();
		txtEvents.setEnabled(false);
		txtEvents.setText("0");
		txtEvents.setOpaque(false);
		txtEvents.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEvents.setForeground(Color.CYAN);
		txtEvents.setFont(new Font("Slider", Font.PLAIN, 22));
		txtEvents.setEditable(false);
		txtEvents.setColumns(10);
		txtEvents.setBorder(null);
		txtEvents.setBounds(467, 243, 390, 28);
		add(txtEvents);
		
		JLabel lblFinalScore = new JLabel("Final Score:");
		lblFinalScore.setFont(new Font("Slider", Font.PLAIN, 32));
		lblFinalScore.setForeground(Color.CYAN);
		lblFinalScore.setBounds(246, 567, 186, 22);
		add(lblFinalScore);
		
		JLabel lblFoodReserves = new JLabel("Food Reserves:");
		lblFoodReserves.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFoodReserves.setForeground(Color.CYAN);
		lblFoodReserves.setFont(new Font("Slider", Font.PLAIN, 22));
		lblFoodReserves.setBounds(246, 279, 186, 22);
		add(lblFoodReserves);
		
		JLabel lblWater = new JLabel("Water Reserves");
		lblWater.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWater.setForeground(Color.CYAN);
		lblWater.setFont(new Font("Slider", Font.PLAIN, 22));
		lblWater.setBounds(246, 312, 186, 22);
		add(lblWater);
		
		JLabel lblParts = new JLabel("Parts Reserves:");
		lblParts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParts.setForeground(Color.CYAN);
		lblParts.setFont(new Font("Slider", Font.PLAIN, 22));
		lblParts.setBounds(246, 345, 186, 22);
		add(lblParts);
		
		txtFood = new JTextField();
		txtFood.setEnabled(false);
		txtFood.setText("0");
		txtFood.setOpaque(false);
		txtFood.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFood.setForeground(Color.CYAN);
		txtFood.setFont(new Font("Slider", Font.PLAIN, 22));
		txtFood.setEditable(false);
		txtFood.setColumns(10);
		txtFood.setBorder(null);
		txtFood.setBounds(467, 276, 390, 28);
		add(txtFood);
		
		txtWater = new JTextField();
		txtWater.setEnabled(false);
		txtWater.setText("0");
		txtWater.setOpaque(false);
		txtWater.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWater.setForeground(Color.CYAN);
		txtWater.setFont(new Font("Slider", Font.PLAIN, 22));
		txtWater.setEditable(false);
		txtWater.setColumns(10);
		txtWater.setBorder(null);
		txtWater.setBounds(467, 311, 390, 28);
		add(txtWater);
		
		txtParts = new JTextField();
		txtParts.setEnabled(false);
		txtParts.setText("0");
		txtParts.setOpaque(false);
		txtParts.setHorizontalAlignment(SwingConstants.RIGHT);
		txtParts.setForeground(Color.CYAN);
		txtParts.setFont(new Font("Slider", Font.PLAIN, 22));
		txtParts.setEditable(false);
		txtParts.setColumns(10);
		txtParts.setBorder(null);
		txtParts.setBounds(467, 342, 390, 28);
		add(txtParts);
		
		textFinalScore = new JTextField();
		textFinalScore.setEnabled(false);
		textFinalScore.setEditable(false);
		textFinalScore.setOpaque(false);
		textFinalScore.setHorizontalAlignment(SwingConstants.RIGHT);
		textFinalScore.setText("0");
		textFinalScore.setForeground(Color.CYAN);
		textFinalScore.setFont(new Font("Slider", Font.PLAIN, 32));
		textFinalScore.setBounds(484, 567, 390, 28);
		add(textFinalScore);
		textFinalScore.setColumns(10);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDifficulty.setForeground(Color.CYAN);
		lblDifficulty.setFont(new Font("Slider", Font.PLAIN, 22));
		lblDifficulty.setBounds(246, 378, 186, 22);
		add(lblDifficulty);
		
		txtDifficulty = new JTextField();
		txtDifficulty.setEnabled(false);
		txtDifficulty.setText("0");
		txtDifficulty.setOpaque(false);
		txtDifficulty.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDifficulty.setForeground(Color.CYAN);
		txtDifficulty.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.setEditable(false);
		txtDifficulty.setColumns(10);
		txtDifficulty.setBorder(null);
		txtDifficulty.setBounds(467, 375, 390, 28);
		add(txtDifficulty);
		
		lblDifficultyIcon = new JLabel("");
		lblDifficultyIcon.setIcon(new ImageIcon("lib/images/SpacePioneer.jpg"));
		lblDifficultyIcon.setBounds(895, 279, 363, 325);
		add(lblDifficultyIcon);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setText("Your colony will thrive and prosper. A new age for humanity has begun \r\nthanks to you and your brave astronauts.");
		txtDescription.setForeground(Color.CYAN);
		txtDescription.setFont(new Font("Slider", Font.PLAIN, 18));
		txtDescription.setOpaque(false);
		txtDescription.setEditable(false);
		txtDescription.setBounds(246, 616, 628, 51);
		add(txtDescription);
		
		btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
				if(btnContinue.isEnabled())
					proceed = true;
			}
		});
		btnContinue.setBackground(Color.CYAN);
		btnContinue.setFont(new Font("Slider", Font.PLAIN, 22));
		btnContinue.setBounds(905, 620, 222, 47);
		add(btnContinue);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	if((SF_CNT < 9) && !update){
		    		SF_CNT++; update = true;
			    	if(SF_CNT < 9){ 
			    		player.setPath(SongPath.getPath(25));
			    		player.play(-1);
			    	}else {
			    		player.setPath(SongPath.getPath(26));
			    		player.play(-1);
			    	}
		    	}
		    }
		};
		scoreTimer = new Timer(1000 , taskPerformer);
		scoreTimer.stop();
		player = new CustomPlayer();
	}
	
	public void displayScoreScreen(){
		if(SF_CNT > 9) {
			scoreTimer.stop();
		}
		if(!scoreActive){
			btnContinue.setEnabled(false);
			SF_CNT = 0;
			update = true;
			scoreTimer.start();	
		}
		
		if((SF_CNT < 10) && update){
			update = false;
			proceed = false;
			scoreActive = true;
			setVisible(true);
			
			if(SF_CNT == 0){
				if(GameData.difficulty ==  DifficultySet.Easy)
					lblDifficultyIcon.setIcon(new ImageIcon("lib/images/SpaceMonkey.jpg"));
				else if(GameData.difficulty ==  DifficultySet.Normal)
					lblDifficultyIcon.setIcon(new ImageIcon("lib/images/SpacePioneer.jpg"));
				else
					lblDifficultyIcon.setIcon(new ImageIcon("lib/images/deadAstronaut.jpg"));
			}
			else if(SF_CNT <= 1){
				if(GameData.spacecraft.getId() == Spaceship.ORION_CAPSULE) result = 200000;
				else result = 0;
				txtShip.setText(GameData.spacecraft.getName() + " " + result);
				txtShip.setEnabled(true);
			}
			else if(SF_CNT <= 2){
				result = result + 10000*Destination.getId();
				txtDestination.setText(Destination.getName() + " 10000 x " + Destination.getId());
				txtDestination.setEnabled(true);
			}
			else if(SF_CNT <= 3){
				if(GameData.crewSkillCount(Person.botanist)>0)
					result = result + 10000 * GameData.crewSkillCount(Person.botanist);
				txtBotanists.setText("10000 x " + GameData.crewSkillCount(Person.botanist));
				txtBotanists.setEnabled(true);
			}
			else if(SF_CNT <= 4){
				if(GameData.liveCrew() > 0)
					result = result + 10000 * GameData.liveCrew();
				txtCrewAlive.setText("10000 x "+ GameData.liveCrew());
				txtCrewAlive.setEnabled(true);
			}
			else if(SF_CNT <= 5){
				if(GameData.totalEvents > 0)
					result = result + 2500 * GameData.totalEvents;
				txtEvents.setText("2500 x " + GameData.totalEvents);
				txtEvents.setEnabled(true);
			}
			else if(SF_CNT <= 6){
				if(GameData.food > 0)
					result += (int) 10000 * GameData.food;
				txtFood.setText("10000 x " + GameData.food.intValue());
				txtFood.setEnabled(true);
			}
			else if(SF_CNT <= 7){
				if(GameData.water > 0)
					result += (int) 10000 * GameData.water;
				txtWater.setText("10000 x " + GameData.water.intValue());
				txtWater.setEnabled(true);
			}
			else if(SF_CNT <= 8){
				if(GameData.parts > 0)
					result += 2500 * GameData.parts.intValue();
				txtParts.setText("2500 x " + GameData.parts);
				txtParts.setEnabled(true);
			}
			else if(SF_CNT <= 9){
				result = result * GameData.difficulty;
				txtDifficulty.setText("Score x " + GameData.difficulty);
				txtDifficulty.setEnabled(true);
			}
			if(SF_CNT <= 10 ){
				btnContinue.setEnabled(true);
				textFinalScore.setEnabled(true);
				textFinalScore.setText(EndGameStage.scoreFormat.format(result));
			}
			System.out.println("Display Score: " + SF_CNT);
		}
	}
	

	public boolean isContinue() {
		return proceed;
	}

	public void setContinue(boolean p) {
		proceed = p;
	}

	public boolean isScoreActive() {
		return scoreActive;
	}

	public void setScoreActive(boolean scoreActive) {
		this.scoreActive = scoreActive;
	}
}
