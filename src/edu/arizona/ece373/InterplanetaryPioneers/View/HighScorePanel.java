package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Model.HighScore;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class HighScorePanel extends JPanel {
	
	
	private boolean StartMenu;
	private boolean updated;
	
	private HighScore highScore;
	
	private ArrayList <JTextField> txtName;
	private ArrayList <JTextField> txtDest;
	private ArrayList <JTextField> txtDifficulty;
	private ArrayList <JTextField> txtScore;
	private JTextField txtName1;
	private JTextField txtName2;
	private JTextField txtName3;
	private JTextField txtName4;
	private JTextField txtName5;
	private JTextField txtName6;
	private JTextField txtName7;
	private JTextField txtName8;
	private JTextField txtDest1;
	private JTextField txtDest2;
	private JTextField txtDest3;
	private JTextField txtDest4;
	private JTextField txtDest5;
	private JTextField txtDest6;
	private JTextField txtDest7;
	private JTextField txtDest8;
	private JTextField txtDifficulty1;
	private JTextField txtDifficulty2;
	private JTextField txtDifficulty3;
	private JTextField txtDifficulty4;
	private JTextField txtDifficulty5;
	private JTextField txtDifficulty6;
	private JTextField txtDifficulty7;
	private JTextField txtDifficulty8;
	private JTextField txtScore1;
	private JTextField txtScore2;
	private JTextField txtScore3;
	private JTextField txtScore4;
	private JTextField txtScore5;
	private JTextField txtScore6;
	private JTextField txtScore7;
	private JTextField txtScore8;

	/**
	 * Create the panel.
	 */
	public HighScorePanel() {
		setLayout(null);
		
		highScore = new HighScore();
		
		JLabel lbTitle = new JLabel("High Scores");
		lbTitle.setForeground(Color.CYAN);
		lbTitle.setFont(new Font("Slider", Font.PLAIN, 36));
		lbTitle.setBounds(545, 11, 214, 59);
		add(lbTitle);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setForeground(Color.CYAN);
		lblRank.setFont(new Font("Slider", Font.PLAIN, 24));
		lblRank.setBounds(108, 117, 157, 28);
		add(lblRank);
		
		JLabel lblCaptain = new JLabel("Captain Name");
		lblCaptain.setForeground(Color.CYAN);
		lblCaptain.setFont(new Font("Slider", Font.PLAIN, 24));
		lblCaptain.setBounds(275, 117, 222, 28);
		add(lblCaptain);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.CYAN);
		lblDestination.setFont(new Font("Slider", Font.PLAIN, 24));
		lblDestination.setBounds(566, 117, 172, 28);
		add(lblDestination);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(Color.CYAN);
		lblDifficulty.setFont(new Font("Slider", Font.PLAIN, 24));
		lblDifficulty.setBounds(798, 117, 172, 28);
		add(lblDifficulty);
		
		JLabel lblFinalScore = new JLabel("Final Score");
		lblFinalScore.setForeground(Color.CYAN);
		lblFinalScore.setFont(new Font("Slider", Font.PLAIN, 24));
		lblFinalScore.setBounds(1000, 117, 172, 28);
		add(lblFinalScore);
		
		JLabel lblScore1 = new JLabel("1");
		lblScore1.setForeground(Color.CYAN);
		lblScore1.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore1.setBounds(108, 167, 157, 30);
		add(lblScore1);
		
		JLabel lblScore2 = new JLabel("2");
		lblScore2.setForeground(Color.CYAN);
		lblScore2.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore2.setBounds(108, 206, 157, 30);
		add(lblScore2);
		
		JLabel lblScore3 = new JLabel("3");
		lblScore3.setForeground(Color.CYAN);
		lblScore3.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore3.setBounds(108, 245, 157, 30);
		add(lblScore3);
		
		JLabel lblScore4 = new JLabel("4");
		lblScore4.setForeground(Color.CYAN);
		lblScore4.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore4.setBounds(108, 284, 157, 30);
		add(lblScore4);
		
		JLabel lblScore5 = new JLabel("5");
		lblScore5.setForeground(Color.CYAN);
		lblScore5.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore5.setBounds(108, 323, 157, 30);
		add(lblScore5);
		
		JLabel lblScore6 = new JLabel("6");
		lblScore6.setForeground(Color.CYAN);
		lblScore6.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore6.setBounds(108, 362, 157, 30);
		add(lblScore6);
		
		JLabel lblScore7 = new JLabel("7");
		lblScore7.setForeground(Color.CYAN);
		lblScore7.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore7.setBounds(108, 401, 157, 30);
		add(lblScore7);
		
		JLabel lblScore8 = new JLabel("8");
		lblScore8.setForeground(Color.CYAN);
		lblScore8.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore8.setBounds(108, 440, 157, 30);
		add(lblScore8);
		
		txtName.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(0).setText("Andres Rebeil");
		txtName.get(0).setOpaque(false);
		txtName.get(0).setForeground(Color.WHITE);
		txtName.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(0).setEditable(false);
		txtName.get(0).setBounds(275, 156, 222, 30);
		add(txtName.get(0));
		txtName.get(0).setColumns(10);
		
		txtName2 = new JTextField();
		txtName2.setText("--");
		txtName2.setOpaque(false);
		txtName2.setHorizontalAlignment(SwingConstants.CENTER);
		txtName2.setForeground(Color.WHITE);
		txtName2.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName2.setEditable(false);
		txtName2.setColumns(10);
		txtName2.setBounds(275, 197, 222, 30);
		add(txtName2);
		
		txtName3 = new JTextField();
		txtName3.setText("--");
		txtName3.setOpaque(false);
		txtName3.setHorizontalAlignment(SwingConstants.CENTER);
		txtName3.setForeground(new Color(255, 255, 255));
		txtName3.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName3.setEditable(false);
		txtName3.setColumns(10);
		txtName3.setBounds(275, 238, 222, 30);
		add(txtName3);
		
		txtName4 = new JTextField();
		txtName4.setText("--");
		txtName4.setOpaque(false);
		txtName4.setHorizontalAlignment(SwingConstants.CENTER);
		txtName4.setForeground(new Color(255, 255, 255));
		txtName4.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName4.setEditable(false);
		txtName4.setColumns(10);
		txtName4.setBounds(275, 279, 222, 30);
		add(txtName4);
		
		txtName5 = new JTextField();
		txtName5.setText("--");
		txtName5.setOpaque(false);
		txtName5.setHorizontalAlignment(SwingConstants.CENTER);
		txtName5.setForeground(new Color(255, 255, 255));
		txtName5.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName5.setEditable(false);
		txtName5.setColumns(10);
		txtName5.setBounds(275, 321, 222, 30);
		add(txtName5);
		
		txtName6 = new JTextField();
		txtName6.setText("--");
		txtName6.setOpaque(false);
		txtName6.setHorizontalAlignment(SwingConstants.CENTER);
		txtName6.setForeground(new Color(255, 255, 255));
		txtName6.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName6.setEditable(false);
		txtName6.setColumns(10);
		txtName6.setBounds(275, 362, 222, 30);
		add(txtName6);
		
		txtName7 = new JTextField();
		txtName7.setText("--");
		txtName7.setOpaque(false);
		txtName7.setHorizontalAlignment(SwingConstants.CENTER);
		txtName7.setForeground(new Color(255, 255, 255));
		txtName7.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName7.setEditable(false);
		txtName7.setColumns(10);
		txtName7.setBounds(275, 401, 222, 30);
		add(txtName7);
		
		txtName8 = new JTextField();
		txtName8.setText("--");
		txtName8.setOpaque(false);
		txtName8.setHorizontalAlignment(SwingConstants.CENTER);
		txtName8.setForeground(new Color(255, 255, 255));
		txtName8.setFont(new Font("Slider", Font.PLAIN, 22));
		txtName8.setEditable(false);
		txtName8.setColumns(10);
		txtName8.setBounds(275, 440, 222, 30);
		add(txtName8);
		
		txtDest1 = new JTextField();
		txtDest1.setText("Mars");
		txtDest1.setOpaque(false);
		txtDest1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest1.setForeground(Color.WHITE);
		txtDest1.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest1.setEditable(false);
		txtDest1.setColumns(10);
		txtDest1.setBounds(566, 156, 172, 30);
		add(txtDest1);
		
		txtDest2 = new JTextField();
		txtDest2.setText("--");
		txtDest2.setOpaque(false);
		txtDest2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest2.setForeground(Color.WHITE);
		txtDest2.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest2.setEditable(false);
		txtDest2.setColumns(10);
		txtDest2.setBounds(566, 197, 172, 30);
		add(txtDest2);
		
		txtDest3 = new JTextField();
		txtDest3.setText("--");
		txtDest3.setOpaque(false);
		txtDest3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest3.setForeground(new Color(255, 255, 255));
		txtDest3.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest3.setEditable(false);
		txtDest3.setColumns(10);
		txtDest3.setBounds(566, 238, 172, 30);
		add(txtDest3);
		
		txtDest4 = new JTextField();
		txtDest4.setText("--");
		txtDest4.setOpaque(false);
		txtDest4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest4.setForeground(new Color(255, 255, 255));
		txtDest4.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest4.setEditable(false);
		txtDest4.setColumns(10);
		txtDest4.setBounds(566, 279, 172, 30);
		add(txtDest4);
		
		txtDest5 = new JTextField();
		txtDest5.setText("--");
		txtDest5.setOpaque(false);
		txtDest5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest5.setForeground(new Color(255, 255, 255));
		txtDest5.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest5.setEditable(false);
		txtDest5.setColumns(10);
		txtDest5.setBounds(566, 323, 172, 30);
		add(txtDest5);
		
		txtDest6 = new JTextField();
		txtDest6.setText("--");
		txtDest6.setOpaque(false);
		txtDest6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest6.setForeground(new Color(255, 255, 255));
		txtDest6.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest6.setEditable(false);
		txtDest6.setColumns(10);
		txtDest6.setBounds(566, 362, 172, 30);
		add(txtDest6);
		
		txtDest7 = new JTextField();
		txtDest7.setText("--");
		txtDest7.setOpaque(false);
		txtDest7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest7.setForeground(new Color(255, 255, 255));
		txtDest7.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest7.setEditable(false);
		txtDest7.setColumns(10);
		txtDest7.setBounds(566, 401, 172, 30);
		add(txtDest7);
		
		txtDest8 = new JTextField();
		txtDest8.setText("--");
		txtDest8.setOpaque(false);
		txtDest8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDest8.setForeground(new Color(255, 255, 255));
		txtDest8.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest8.setEditable(false);
		txtDest8.setColumns(10);
		txtDest8.setBounds(566, 440, 172, 30);
		add(txtDest8);
		
		txtDifficulty1 = new JTextField();
		txtDifficulty1.setText("Suicide Mission");
		txtDifficulty1.setOpaque(false);
		txtDifficulty1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty1.setForeground(new Color(255, 255, 255));
		txtDifficulty1.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty1.setEditable(false);
		txtDifficulty1.setColumns(10);
		txtDifficulty1.setBounds(798, 156, 172, 30);
		add(txtDifficulty1);
		
		txtDifficulty2 = new JTextField();
		txtDifficulty2.setText("--");
		txtDifficulty2.setOpaque(false);
		txtDifficulty2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty2.setForeground(Color.WHITE);
		txtDifficulty2.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty2.setEditable(false);
		txtDifficulty2.setColumns(10);
		txtDifficulty2.setBounds(798, 197, 172, 30);
		add(txtDifficulty2);
		
		txtDifficulty3 = new JTextField();
		txtDifficulty3.setText("--");
		txtDifficulty3.setOpaque(false);
		txtDifficulty3.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty3.setForeground(new Color(255, 255, 255));
		txtDifficulty3.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty3.setEditable(false);
		txtDifficulty3.setColumns(10);
		txtDifficulty3.setBounds(798, 238, 172, 30);
		add(txtDifficulty3);
		
		txtDifficulty4 = new JTextField();
		txtDifficulty4.setText("--");
		txtDifficulty4.setOpaque(false);
		txtDifficulty4.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty4.setForeground(new Color(255, 255, 255));
		txtDifficulty4.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty4.setEditable(false);
		txtDifficulty4.setColumns(10);
		txtDifficulty4.setBounds(798, 279, 172, 30);
		add(txtDifficulty4);
		
		txtDifficulty5 = new JTextField();
		txtDifficulty5.setText("--");
		txtDifficulty5.setOpaque(false);
		txtDifficulty5.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty5.setForeground(new Color(255, 255, 255));
		txtDifficulty5.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty5.setEditable(false);
		txtDifficulty5.setColumns(10);
		txtDifficulty5.setBounds(798, 323, 172, 30);
		add(txtDifficulty5);
		
		txtDifficulty6 = new JTextField();
		txtDifficulty6.setText("--");
		txtDifficulty6.setOpaque(false);
		txtDifficulty6.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty6.setForeground(new Color(255, 255, 255));
		txtDifficulty6.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty6.setEditable(false);
		txtDifficulty6.setColumns(10);
		txtDifficulty6.setBounds(798, 362, 172, 30);
		add(txtDifficulty6);
		
		txtDifficulty7 = new JTextField();
		txtDifficulty7.setText("--");
		txtDifficulty7.setOpaque(false);
		txtDifficulty7.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty7.setForeground(new Color(255, 255, 255));
		txtDifficulty7.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty7.setEditable(false);
		txtDifficulty7.setColumns(10);
		txtDifficulty7.setBounds(798, 401, 172, 30);
		add(txtDifficulty7);
		
		txtDifficulty8 = new JTextField();
		txtDifficulty8.setText("--");
		txtDifficulty8.setOpaque(false);
		txtDifficulty8.setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty8.setForeground(new Color(255, 255, 255));
		txtDifficulty8.setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty8.setEditable(false);
		txtDifficulty8.setColumns(10);
		txtDifficulty8.setBounds(798, 440, 172, 30);
		add(txtDifficulty8);
		
		txtScore1 = new JTextField();
		txtScore1.setText("6,000,000");
		txtScore1.setOpaque(false);
		txtScore1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore1.setForeground(Color.WHITE);
		txtScore1.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore1.setEditable(false);
		txtScore1.setColumns(10);
		txtScore1.setBounds(1000, 156, 250, 30);
		add(txtScore1);
		
		txtScore2 = new JTextField();
		txtScore2.setText("--");
		txtScore2.setOpaque(false);
		txtScore2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore2.setForeground(Color.WHITE);
		txtScore2.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore2.setEditable(false);
		txtScore2.setColumns(10);
		txtScore2.setBounds(1000, 197, 250, 30);
		add(txtScore2);
		
		txtScore3 = new JTextField();
		txtScore3.setText("--");
		txtScore3.setOpaque(false);
		txtScore3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore3.setForeground(Color.WHITE);
		txtScore3.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore3.setEditable(false);
		txtScore3.setColumns(10);
		txtScore3.setBounds(1000, 238, 250, 30);
		add(txtScore3);
		
		txtScore4 = new JTextField();
		txtScore4.setText("--");
		txtScore4.setOpaque(false);
		txtScore4.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore4.setForeground(Color.WHITE);
		txtScore4.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore4.setEditable(false);
		txtScore4.setColumns(10);
		txtScore4.setBounds(1000, 279, 250, 30);
		add(txtScore4);
		
		txtScore5 = new JTextField();
		txtScore5.setText("--");
		txtScore5.setOpaque(false);
		txtScore5.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore5.setForeground(Color.WHITE);
		txtScore5.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore5.setEditable(false);
		txtScore5.setColumns(10);
		txtScore5.setBounds(1000, 323, 250, 30);
		add(txtScore5);
		
		txtScore6 = new JTextField();
		txtScore6.setText("--");
		txtScore6.setOpaque(false);
		txtScore6.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore6.setForeground(Color.WHITE);
		txtScore6.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore6.setEditable(false);
		txtScore6.setColumns(10);
		txtScore6.setBounds(1000, 362, 250, 30);
		add(txtScore6);
		
		txtScore7 = new JTextField();
		txtScore7.setText("--");
		txtScore7.setOpaque(false);
		txtScore7.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore7.setForeground(Color.WHITE);
		txtScore7.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore7.setEditable(false);
		txtScore7.setColumns(10);
		txtScore7.setBounds(1000, 401, 250, 30);
		add(txtScore7);
		
		txtScore8 = new JTextField();
		txtScore8.setText("--");
		txtScore8.setOpaque(false);
		txtScore8.setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore8.setForeground(Color.WHITE);
		txtScore8.setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore8.setEditable(false);
		txtScore8.setColumns(10);
		txtScore8.setBounds(1000, 440, 250, 30);
		add(txtScore8);
		
		JButton btnNewButton = new JButton("Start Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StartMenu = true;
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Slider", Font.BOLD, 21));
		btnNewButton.setBounds(545, 582, 214, 53);
		add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		StartMenu = false;
		setVisible(false);
	}
	
	public void initPanelFields(){
		txtName = new ArrayList <JTextField>(8);
		txtDest = new ArrayList <JTextField>(8);;
		txtDifficulty = new ArrayList <JTextField>(8);;
		txtScore = new ArrayList <JTextField>(8);;
	}
	
	public void autoLoad(){
		highScore = HighScore.loadData();
	}
	
	public void displayHighScores(){
		setVisible(true);
		StartMenu = false;
		highScore = HighScore.loadData();
		highScore.printData();
		highScore.sort();
		updated = true;
		
		if(highScore.getScores().size() != 0){
			System.out.println("Updating High Scores.");
			for(int i = 0; i < highScore.getScores().size(); i++) {
				switch(i) {
					case 0:
						txtName1.setText(highScore.scores.get(i).getCaptName()); 
						txtDest1.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty1.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore1.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 1:
						txtName2.setText(highScore.scores.get(i).getCaptName()); 
						txtDest2.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty2.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore2.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 2:
						txtName3.setText(highScore.scores.get(i).getCaptName()); 
						txtDest3.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty3.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore3.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 3:
						txtName4.setText(highScore.scores.get(i).getCaptName()); 
						txtDest4.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty4.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore4.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 4:
						txtName5.setText(highScore.scores.get(i).getCaptName()); 
						txtDest5.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty5.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore5.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 5:
						txtName6.setText(highScore.scores.get(i).getCaptName()); 
						txtDest6.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty6.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore6.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 6:
						txtName7.setText(highScore.scores.get(i).getCaptName()); 
						txtDest7.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty7.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore7.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 7:
						txtName8.setText(highScore.scores.get(i).getCaptName()); 
						txtDest8.setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty8.setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore8.setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
				}
			}	
		}
		
	}

	public boolean isStartMenu() {
		return StartMenu;
	}

	public void setStartMenu(boolean startMenu) {
		StartMenu = startMenu;
	}
	
	public HighScore getHighScore(){
		return highScore;
	}
	
	public void setHighScore(HighScore hs){
		highScore = hs;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
}
