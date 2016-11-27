package gameWindow;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import gameExecution.GameData;
import gameModel.Destination;
import gameModel.Person;
import gameSound.CustomPlayer;
import sounds.SongPath;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalScorePanel extends JPanel {
	
	
	private boolean scoreActive = false;
	private boolean Continue = false;
	private int SF_CNT = 0;
	private Timer scoreTimer;
	private boolean update = false;
	private Integer base = 0;
	private int result = 0;
	
	private JTextField textFinalScore;
	private JTextField txtDestination;
	private JTextField txtBase;
	private JTextField txtCrewAlive;
	private JTextField txtEvents;
	private JTextField txtFood;
	private JTextField txtWater;
	private JTextField txtParts;
	private JTextField txtBotanists;
	private JTextField txtDifficulty;
	private JLabel lblDifficultyIcon;
	private CustomPlayer player;
	
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
		
		JLabel lblBase = new JLabel("Base Score:");
		lblBase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBase.setForeground(Color.CYAN);
		lblBase.setFont(new Font("Slider", Font.PLAIN, 22));
		lblBase.setBounds(246, 125, 186, 22);
		add(lblBase);
		
		txtBase = new JTextField();
		txtBase.setEnabled(false);
		txtBase.setText("10");
		txtBase.setOpaque(false);
		txtBase.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBase.setForeground(Color.CYAN);
		txtBase.setFont(new Font("Slider", Font.PLAIN, 22));
		txtBase.setEditable(false);
		txtBase.setColumns(10);
		txtBase.setBorder(null);
		txtBase.setBounds(457, 125, 400, 28);
		add(txtBase);
		
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
		lblDifficultyIcon.setIcon(new ImageIcon(FinalScorePanel.class.getResource("/images/SpacePioneer.jpg")));
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
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
				Continue = true;
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Slider", Font.PLAIN, 22));
		btnNewButton.setBounds(905, 620, 222, 47);
		add(btnNewButton);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(FinalScorePanel.class.getResource("/images/hud_bg_full.jpg")));
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
	
	public void displayScoreScreen(GameData gameData){
		if(SF_CNT > 9) {
			scoreTimer.stop();
		}
		if(!scoreActive){
			SF_CNT = 0;
			update = true;
			scoreTimer.start();	
		}
		
		if((SF_CNT < 10) && update){
			update = false;
			Continue = false;
			scoreActive = true;
			setVisible(true);
			
			if(SF_CNT < 1){
				result = base;
				txtBase.setText(base.toString());
				txtBase.setEnabled(true);
				if(gameData.getDifficulty() ==  DifficultySet.Easy)
					lblDifficultyIcon.setIcon(new ImageIcon(FinalScorePanel.class.getResource("/images/SpaceMonkey.jpg")));
				else if(gameData.getDifficulty() ==  DifficultySet.Normal)
					lblDifficultyIcon.setIcon(new ImageIcon(FinalScorePanel.class.getResource("/images/SpacePioneer.jpg")));
				else
					lblDifficultyIcon.setIcon(new ImageIcon(FinalScorePanel.class.getResource("/images/deadAstronaut.jpg")));
			}
			else if(SF_CNT < 2){
				result = result + 10000*Destination.getId();
				txtDestination.setText(Destination.getName() + " 10000 x " + Destination.getId());
				txtDestination.setEnabled(true);
			}
			else if(SF_CNT < 3){
				if(gameData.crewSkillCount(Person.botanist)>0)
					result = result + 10000*gameData.crewSkillCount(Person.botanist);
				txtBotanists.setText("10000 x "+gameData.crewSkillCount(Person.botanist));
				txtBotanists.setEnabled(true);
			}
			else if(SF_CNT < 4){
				if(gameData.liveCrew() > 0)
					result = result + 10000*gameData.liveCrew();
				txtCrewAlive.setText("10000 x "+ gameData.liveCrew());
				txtCrewAlive.setEnabled(true);
			}
			else if(SF_CNT < 5){
				if(gameData.getTotalEvents() > 0)
					result = result + 1500*gameData.getTotalEvents();
				txtEvents.setText("1500 x "+ gameData.getTotalEvents());
				txtEvents.setEnabled(true);
			}
			else if(SF_CNT < 6){
				if(gameData.getFood() > 0)
					result = result + 10000*gameData.getFood();
				txtFood.setText("10000 x " + gameData.getFood());
				txtFood.setEnabled(true);
			}
			else if(SF_CNT < 7){
				if(gameData.getWater() > 0)
					result = result + 10000*gameData.getWater();
				txtWater.setText("10000 x " + gameData.getWater());
				txtWater.setEnabled(true);
			}
			else if(SF_CNT < 8){
				if(gameData.getParts() > 0)
					result = result + 2500*gameData.getParts();
				txtParts.setText("2500 x " + gameData.getParts());
				txtParts.setEnabled(true);
			}
			else if(SF_CNT < 9){
				result = result*gameData.getDifficulty();
				txtDifficulty.setText("Score x " + gameData.getDifficulty());
				txtDifficulty.setEnabled(true);
			}
			//result = base*Destination.getId()*(gameData.crewSkillCount(Person.botanist))*gameData.liveCrew()*gameData.getTotalEvents()*gameData.getFood()*gameData.getWater()*gameData.getParts();
			if(SF_CNT < 10 ){
				textFinalScore.setEnabled(true);
				textFinalScore.setText(EndGameStage.scoreFormat.format(result));
			}
			System.out.println("Display Score: "+SF_CNT);
		}
	}
	

	public boolean isContinue() {
		return Continue;
	}

	public void setContinue(boolean continue1) {
		Continue = continue1;
	}

	public boolean isScoreActive() {
		return scoreActive;
	}

	public void setScoreActive(boolean scoreActive) {
		this.scoreActive = scoreActive;
	}
}
