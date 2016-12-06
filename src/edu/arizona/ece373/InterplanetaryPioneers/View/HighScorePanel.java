package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Model.HighScore;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;

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
	private ArrayList <JTextField> txtShip;

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
		lblRank.setBounds(108, 117, 77, 28);
		add(lblRank);
		
		JLabel lblCaptain = new JLabel("Captain Name");
		lblCaptain.setForeground(Color.CYAN);
		lblCaptain.setFont(new Font("Slider", Font.PLAIN, 24));
		lblCaptain.setBounds(195, 117, 246, 28);
		add(lblCaptain);
		
		JLabel lblSpacecraft = new JLabel("Spacecraft");
		lblSpacecraft.setForeground(Color.CYAN);
		lblSpacecraft.setFont(new Font("Slider", Font.PLAIN, 24));
		lblSpacecraft.setBounds(460, 117, 164, 28);
		add(lblSpacecraft);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.CYAN);
		lblDestination.setFont(new Font("Slider", Font.PLAIN, 24));
		lblDestination.setBounds(648, 117, 183, 28);
		add(lblDestination);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(Color.CYAN);
		lblDifficulty.setFont(new Font("Slider", Font.PLAIN, 24));
		lblDifficulty.setBounds(861, 117, 189, 28);
		add(lblDifficulty);
		
		JLabel lblFinalScore = new JLabel("Final Score");
		lblFinalScore.setForeground(Color.CYAN);
		lblFinalScore.setFont(new Font("Slider", Font.PLAIN, 24));
		lblFinalScore.setBounds(1074, 117, 176, 28);
		add(lblFinalScore);
		
		JLabel lblScore1 = new JLabel("1");
		lblScore1.setForeground(Color.CYAN);
		lblScore1.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore1.setBounds(108, 156, 77, 30);
		add(lblScore1);
		
		JLabel lblScore2 = new JLabel("2");
		lblScore2.setForeground(Color.CYAN);
		lblScore2.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore2.setBounds(108, 197, 77, 30);
		add(lblScore2);
		
		JLabel lblScore3 = new JLabel("3");
		lblScore3.setForeground(Color.CYAN);
		lblScore3.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore3.setBounds(108, 238, 77, 30);
		add(lblScore3);
		
		JLabel lblScore4 = new JLabel("4");
		lblScore4.setForeground(Color.CYAN);
		lblScore4.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore4.setBounds(108, 279, 77, 30);
		add(lblScore4);
		
		JLabel lblScore5 = new JLabel("5");
		lblScore5.setForeground(Color.CYAN);
		lblScore5.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore5.setBounds(108, 320, 77, 30);
		add(lblScore5);
		
		JLabel lblScore6 = new JLabel("6");
		lblScore6.setForeground(Color.CYAN);
		lblScore6.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore6.setBounds(108, 362, 77, 30);
		add(lblScore6);
		
		JLabel lblScore7 = new JLabel("7");
		lblScore7.setForeground(Color.CYAN);
		lblScore7.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore7.setBounds(108, 401, 77, 30);
		add(lblScore7);
		
		JLabel lblScore8 = new JLabel("8");
		lblScore8.setForeground(Color.CYAN);
		lblScore8.setFont(new Font("Slider", Font.PLAIN, 24));
		lblScore8.setBounds(108, 442, 77, 30);
		add(lblScore8);
		
		txtName = 		new ArrayList <JTextField>(8); 
		txtDest = 		new ArrayList <JTextField> (8);
		txtDifficulty = new ArrayList <JTextField>(8);
		txtScore = 		new ArrayList <JTextField> (8);
		txtShip = 		new ArrayList <JTextField>(8);
		
		JTextField temp;
		for(int i = 0; i < 8; i++){
			temp = new JTextField();
			txtName.add(temp);
		}
		txtName.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(0).setText("--");
		txtName.get(0).setOpaque(false);
		txtName.get(0).setForeground(Color.WHITE);
		txtName.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(0).setEditable(false);
		txtName.get(0).setBounds(195, 156, 246, 30);
		add(txtName.get(0));
		txtName.get(0).setColumns(10);
		
		txtName.get(1).setText("--");
		txtName.get(1).setOpaque(false);
		txtName.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(1).setForeground(Color.WHITE);
		txtName.get(1).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(1).setEditable(false);
		txtName.get(1).setColumns(10);
		txtName.get(1).setBounds(195, 197, 246, 30);
		add(txtName.get(1));
		
		txtName.get(2).setText("--");
		txtName.get(2).setOpaque(false);
		txtName.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(2).setForeground(new Color(255, 255, 255));
		txtName.get(2).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(2).setEditable(false);
		txtName.get(2).setColumns(10);
		txtName.get(2).setBounds(195, 238, 246, 30);
		add(txtName.get(2));
		
		txtName.get(3).setText("--");
		txtName.get(3).setOpaque(false);
		txtName.get(3).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(3).setForeground(new Color(255, 255, 255));
		txtName.get(3).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(3).setEditable(false);
		txtName.get(3).setColumns(10);
		txtName.get(3).setBounds(195, 279, 246, 30);
		add(txtName.get(3));
		
		txtName.get(4).setText("--");
		txtName.get(4).setOpaque(false);
		txtName.get(4).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(4).setForeground(new Color(255, 255, 255));
		txtName.get(4).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(4).setEditable(false);
		txtName.get(4).setColumns(10);
		txtName.get(4).setBounds(195, 320, 246, 30);
		add(txtName.get(4));
		
		txtName.get(5).setText("--");
		txtName.get(5).setOpaque(false);
		txtName.get(5).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(5).setForeground(new Color(255, 255, 255));
		txtName.get(5).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(5).setEditable(false);
		txtName.get(5).setColumns(10);
		txtName.get(5).setBounds(195, 361, 246, 30);
		add(txtName.get(5));
		
		txtName.get(6).setText("--");
		txtName.get(6).setOpaque(false);
		txtName.get(6).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(6).setForeground(new Color(255, 255, 255));
		txtName.get(6).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(6).setEditable(false);
		txtName.get(6).setColumns(10);
		txtName.get(6).setBounds(195, 401, 246, 30);
		add(txtName.get(6));
		
		txtName.get(7).setText("--");
		txtName.get(7).setOpaque(false);
		txtName.get(7).setHorizontalAlignment(SwingConstants.CENTER);
		txtName.get(7).setForeground(new Color(255, 255, 255));
		txtName.get(7).setFont(new Font("Slider", Font.PLAIN, 22));
		txtName.get(7).setEditable(false);
		txtName.get(7).setColumns(10);
		txtName.get(7).setBounds(195, 442, 246, 30);
		add(txtName.get(7));
		
		for(int i = 0; i < 8; i++){
			temp = new JTextField();
			txtDest.add(temp);
		}
		txtDest.get(0).setText("--");
		txtDest.get(0).setOpaque(false);
		txtDest.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(0).setForeground(Color.WHITE);
		txtDest.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(0).setEditable(false);
		txtDest.get(0).setColumns(10);
		txtDest.get(0).setBounds(648, 156, 189, 30);
		add(txtDest.get(0));
		
		txtDest.get(1).setText("--");
		txtDest.get(1).setOpaque(false);
		txtDest.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(1).setForeground(Color.WHITE);
		txtDest.get(1).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(1).setEditable(false);
		txtDest.get(1).setColumns(10);
		txtDest.get(1).setBounds(648, 197, 189, 30);
		add(txtDest.get(1));
		
		txtDest.get(2).setText("--");
		txtDest.get(2).setOpaque(false);
		txtDest.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(2).setForeground(new Color(255, 255, 255));
		txtDest.get(2).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(2).setEditable(false);
		txtDest.get(2).setColumns(10);
		txtDest.get(2).setBounds(648, 238, 189, 30);
		add(txtDest.get(2));
		
		txtDest.get(3).setText("--");
		txtDest.get(3).setOpaque(false);
		txtDest.get(3).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(3).setForeground(new Color(255, 255, 255));
		txtDest.get(3).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(3).setEditable(false);
		txtDest.get(3).setColumns(10);
		txtDest.get(3).setBounds(648, 279, 189, 30);
		add(txtDest.get(3));
		
		txtDest.get(4).setText("--");
		txtDest.get(4).setOpaque(false);
		txtDest.get(4).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(4).setForeground(new Color(255, 255, 255));
		txtDest.get(4).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(4).setEditable(false);
		txtDest.get(4).setColumns(10);
		txtDest.get(4).setBounds(648, 320, 189, 30);
		add(txtDest.get(4));
		
		txtDest.get(5).setText("--");
		txtDest.get(5).setOpaque(false);
		txtDest.get(5).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(5).setForeground(new Color(255, 255, 255));
		txtDest.get(5).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(5).setEditable(false);
		txtDest.get(5).setColumns(10);
		txtDest.get(5).setBounds(648, 362, 189, 30);
		add(txtDest.get(5));
		
		txtDest.get(6).setText("--");
		txtDest.get(6).setOpaque(false);
		txtDest.get(6).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(6).setForeground(new Color(255, 255, 255));
		txtDest.get(6).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(6).setEditable(false);
		txtDest.get(6).setColumns(10);
		txtDest.get(6).setBounds(648, 401, 189, 30);
		add(txtDest.get(6));
		
		txtDest.get(7).setText("--");
		txtDest.get(7).setOpaque(false);
		txtDest.get(7).setHorizontalAlignment(SwingConstants.CENTER);
		txtDest.get(7).setForeground(new Color(255, 255, 255));
		txtDest.get(7).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDest.get(7).setEditable(false);
		txtDest.get(7).setColumns(10);
		txtDest.get(7).setBounds(648, 442, 189, 30);
		add(txtDest.get(7));
		
		for(int i = 0; i < 8; i++){
			temp = new JTextField();
			txtDifficulty.add(temp);
		}
		txtDifficulty.get(0).setText("--");
		txtDifficulty.get(0).setOpaque(false);
		txtDifficulty.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(0).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(0).setEditable(false);
		txtDifficulty.get(0).setColumns(10);
		txtDifficulty.get(0).setBounds(861, 156, 189, 30);
		add(txtDifficulty.get(0));
		
		txtDifficulty.get(1).setText("--");
		txtDifficulty.get(1).setOpaque(false);
		txtDifficulty.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(1).setForeground(Color.WHITE);
		txtDifficulty.get(1).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(1).setEditable(false);
		txtDifficulty.get(1).setColumns(10);
		txtDifficulty.get(1).setBounds(861, 197, 189, 30);
		add(txtDifficulty.get(1));
		
		txtDifficulty.get(2).setText("--");
		txtDifficulty.get(2).setOpaque(false);
		txtDifficulty.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(2).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(2).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(2).setEditable(false);
		txtDifficulty.get(2).setColumns(10);
		txtDifficulty.get(2).setBounds(861, 238, 189, 30);
		add(txtDifficulty.get(2));
		
		txtDifficulty.get(3).setText("--");
		txtDifficulty.get(3).setOpaque(false);
		txtDifficulty.get(3).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(3).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(3).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(3).setEditable(false);
		txtDifficulty.get(3).setColumns(10);
		txtDifficulty.get(3).setBounds(861, 279, 189, 30);
		add(txtDifficulty.get(3));
		
		txtDifficulty.get(4).setText("--");
		txtDifficulty.get(4).setOpaque(false);
		txtDifficulty.get(4).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(4).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(4).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(4).setEditable(false);
		txtDifficulty.get(4).setColumns(10);
		txtDifficulty.get(4).setBounds(861, 323, 189, 30);
		add(txtDifficulty.get(4));
		
		txtDifficulty.get(5).setText("--");
		txtDifficulty.get(5).setOpaque(false);
		txtDifficulty.get(5).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(5).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(5).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(5).setEditable(false);
		txtDifficulty.get(5).setColumns(10);
		txtDifficulty.get(5).setBounds(861, 362, 189, 30);
		add(txtDifficulty.get(5));
		
		txtDifficulty.get(6).setText("--");
		txtDifficulty.get(6).setOpaque(false);
		txtDifficulty.get(6).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(6).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(6).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(6).setEditable(false);
		txtDifficulty.get(6).setColumns(10);
		txtDifficulty.get(6).setBounds(861, 401, 189, 30);
		add(txtDifficulty.get(6));
		
		txtDifficulty.get(7).setText("--");
		txtDifficulty.get(7).setOpaque(false);
		txtDifficulty.get(7).setHorizontalAlignment(SwingConstants.CENTER);
		txtDifficulty.get(7).setForeground(new Color(255, 255, 255));
		txtDifficulty.get(7).setFont(new Font("Slider", Font.PLAIN, 22));
		txtDifficulty.get(7).setEditable(false);
		txtDifficulty.get(7).setColumns(10);
		txtDifficulty.get(7).setBounds(861, 440, 189, 30);
		add(txtDifficulty.get(7));
		
		for(int i = 0; i < 8; i++){
			temp = new JTextField();
			txtScore.add(temp);
		}
		txtScore.get(0).setText("--");
		txtScore.get(0).setOpaque(false);
		txtScore.get(0).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(0).setForeground(Color.WHITE);
		txtScore.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(0).setEditable(false);
		txtScore.get(0).setColumns(10);
		txtScore.get(0).setBounds(1074, 156, 176, 30);
		add(txtScore.get(0));
		
		txtScore.get(1).setText("--");
		txtScore.get(1).setOpaque(false);
		txtScore.get(1).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(1).setForeground(Color.WHITE);
		txtScore.get(1).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(1).setEditable(false);
		txtScore.get(1).setColumns(10);
		txtScore.get(1).setBounds(1074, 197, 176, 30);
		add(txtScore.get(1));
		
		txtScore.get(2).setText("--");
		txtScore.get(2).setOpaque(false);
		txtScore.get(2).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(2).setForeground(Color.WHITE);
		txtScore.get(2).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(2).setEditable(false);
		txtScore.get(2).setColumns(10);
		txtScore.get(2).setBounds(1074, 238, 176, 30);
		add(txtScore.get(2));
		
		txtScore.get(3).setText("--");
		txtScore.get(3).setOpaque(false);
		txtScore.get(3).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(3).setForeground(Color.WHITE);
		txtScore.get(3).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(3).setEditable(false);
		txtScore.get(3).setColumns(10);
		txtScore.get(3).setBounds(1074, 279, 176, 30);
		add(txtScore.get(3));
		
		txtScore.get(4).setText("--");
		txtScore.get(4).setOpaque(false);
		txtScore.get(4).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(4).setForeground(Color.WHITE);
		txtScore.get(4).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(4).setEditable(false);
		txtScore.get(4).setColumns(10);
		txtScore.get(4).setBounds(1074, 323, 176, 30);
		add(txtScore.get(4));
		
		txtScore.get(5).setText("--");
		txtScore.get(5).setOpaque(false);
		txtScore.get(5).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(5).setForeground(Color.WHITE);
		txtScore.get(5).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(5).setEditable(false);
		txtScore.get(5).setColumns(10);
		txtScore.get(5).setBounds(1074, 362, 176, 30);
		add(txtScore.get(5));
		
		txtScore.get(6).setText("--");
		txtScore.get(6).setOpaque(false);
		txtScore.get(6).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(6).setForeground(Color.WHITE);
		txtScore.get(6).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(6).setEditable(false);
		txtScore.get(6).setColumns(10);
		txtScore.get(6).setBounds(1074, 401, 176, 30);
		add(txtScore.get(6));
		
		txtScore.get(7).setText("--");
		txtScore.get(7).setOpaque(false);
		txtScore.get(7).setHorizontalAlignment(SwingConstants.RIGHT);
		txtScore.get(7).setForeground(Color.WHITE);
		txtScore.get(7).setFont(new Font("Slider", Font.PLAIN, 22));
		txtScore.get(7).setEditable(false);
		txtScore.get(7).setColumns(10);
		txtScore.get(7).setBounds(1074, 440, 176, 30);
		add(txtScore.get(7));
		
		JButton btnNewButton = new JButton("Start Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StartMenu = true;
				setVisible(false);
			}
		});
		
		for(int i = 0; i < 8; i++){
			temp = new JTextField();
			txtShip.add(temp);
		}
		txtShip.get(0).setText("--");
		txtShip.get(0).setOpaque(false);
		txtShip.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(0).setForeground(Color.WHITE);
		txtShip.get(0).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(0).setEditable(false);
		txtShip.get(0).setColumns(10);
		txtShip.get(0).setBounds(458, 156, 164, 30);
		add(txtShip.get(0));
		
		txtShip.get(1).setText("--");
		txtShip.get(1).setOpaque(false);
		txtShip.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(1).setForeground(Color.WHITE);
		txtShip.get(1).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(1).setEditable(false);
		txtShip.get(1).setColumns(10);
		txtShip.get(1).setBounds(458, 197, 164, 30);
		add(txtShip.get(1));
		
		txtShip.get(2).setText("--");
		txtShip.get(2).setOpaque(false);
		txtShip.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(2).setForeground(Color.WHITE);
		txtShip.get(2).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(2).setEditable(false);
		txtShip.get(2).setColumns(10);
		txtShip.get(2).setBounds(458, 238, 164, 30);
		add(txtShip.get(2));
		
		txtShip.get(3).setText("--");
		txtShip.get(3).setOpaque(false);
		txtShip.get(3).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(3).setForeground(Color.WHITE);
		txtShip.get(3).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(3).setEditable(false);
		txtShip.get(3).setColumns(10);
		txtShip.get(3).setBounds(458, 279, 164, 30);
		add(txtShip.get(3));
		
		txtShip.get(4).setText("--");
		txtShip.get(4).setOpaque(false);
		txtShip.get(4).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(4).setForeground(Color.WHITE);
		txtShip.get(4).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(4).setEditable(false);
		txtShip.get(4).setColumns(10);
		txtShip.get(4).setBounds(458, 320, 164, 30);
		add(txtShip.get(4));
		
		txtShip.get(5).setText("--");
		txtShip.get(5).setOpaque(false);
		txtShip.get(5).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(5).setForeground(Color.WHITE);
		txtShip.get(5).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(5).setEditable(false);
		txtShip.get(5).setColumns(10);
		txtShip.get(5).setBounds(458, 362, 164, 30);
		add(txtShip.get(5));
		
		txtShip.get(6).setText("--");
		txtShip.get(6).setOpaque(false);
		txtShip.get(6).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(6).setForeground(Color.WHITE);
		txtShip.get(6).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(6).setEditable(false);
		txtShip.get(6).setColumns(10);
		txtShip.get(6).setBounds(458, 401, 164, 30);
		add(txtShip.get(6));
		
		txtShip.get(7).setText("--");
		txtShip.get(7).setOpaque(false);
		txtShip.get(7).setHorizontalAlignment(SwingConstants.CENTER);
		txtShip.get(7).setForeground(Color.WHITE);
		txtShip.get(7).setFont(new Font("Slider", Font.PLAIN, 22));
		txtShip.get(7).setEditable(false);
		txtShip.get(7).setColumns(10);
		txtShip.get(7).setBounds(460, 442, 164, 30);
		add(txtShip.get(7));
		
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Slider", Font.BOLD, 21));
		btnNewButton.setBounds(545, 582, 214, 53);
		add(btnNewButton);
		
		JLabel lblBackground = new JLabel("--");
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		StartMenu = false;
		setVisible(false);
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
						txtName.get(0).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(0).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(0).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(0).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(0).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 1:
						txtName.get(1).setText(highScore.scores.get(i).getCaptName());
						txtShip.get(1).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(1).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(1).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(1).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 2:
						txtName.get(2).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(2).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(2).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(2).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(2).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 3:
						txtName.get(3).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(3).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(3).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(3).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(3).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 4:
						txtName.get(4).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(4).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(4).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(4).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(4).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 5:
						txtName.get(5).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(5).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(5).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(5).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(5).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 6:
						txtName.get(6).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(6).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(6).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(6).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(6).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
						break;
					case 7:
						txtName.get(7).setText(highScore.scores.get(i).getCaptName()); 
						txtShip.get(7).setText(Spaceship.getShipName(highScore.scores.get(i).getShipID()));
						txtDest.get(7).setText(Destination.getName(highScore.scores.get(i).getDestID())); 
						txtDifficulty.get(7).setText(DifficultySet.getDiffString(highScore.scores.get(i).getDifficulty())); 
						txtScore.get(7).setText(EndGameStage.scoreFormat.format(highScore.scores.get(i).getScore()));
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
