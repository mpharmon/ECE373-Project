package edu.arizona.ece373.InterplanetaryPioneers.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class StartPanel extends JPanel {
	
	private boolean StartBtn;
	private boolean HighScoreBtn;
	private boolean ExitBtn;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		setLayout(null);
		
		// Initialize button tracking variables
		setStartBtn(false);
		setHighScoreBtn(false);
		setExitBtn(false);

		setBounds(100, 100, 1280, 720);

		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EmptyBorder(5, 5, 5, 5));

	
		JLabel label = new JLabel("   INTERPLANETARY PIONEERS");
		label.setForeground(new Color(0, 255, 255));
		label.setBounds(135, 81, 1007, 73);
		label.setFont(new Font("Slider", Font.PLAIN, 60));
		add(label);

		// START Button
		JButton btnStartButton = new JButton("Start");
		btnStartButton.setBackground(new Color(0, 255, 255));
		btnStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Start");
				setStartBtn(true); setExitBtn(false); setHighScoreBtn(false);
			}
		});
		btnStartButton.setBounds(518, 320, 219, 60);
		btnStartButton.setFont(new Font("Slider", Font.PLAIN, 24));
		add(btnStartButton);

		// High Score Button
		JButton btnHighScores = new JButton("High Scores\r\n");
		btnHighScores.setBackground(new Color(0, 255, 255));
		btnHighScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("High Scores");
				setStartBtn(false); setHighScoreBtn(true); setExitBtn(false); 
			}
		});
		btnHighScores.setBounds(518, 425, 219, 60);
		btnHighScores.setFont(new Font("Slider", Font.PLAIN, 24));
		add(btnHighScores);

		// Exit Button
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(0, 255, 255));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Exit");
				setExitBtn(true);
				System.exit(0);
			}
		});
		btnExit.setBounds(518, 537, 219, 60);
		btnExit.setFont(new Font("Slider", Font.PLAIN, 24));
		add(btnExit);

		// Main Menu Image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1264, 682);
		lblNewLabel.setIcon(new ImageIcon("lib/images/Deep-Space-Cloud3_0.jpg"));
		add(lblNewLabel);
		
	}

	public boolean isStartBtn() {
		return StartBtn;
	}

	public void setStartBtn(boolean startBtn) {
		StartBtn = startBtn;
	}

	public boolean isHighScoreBtn() {
		return HighScoreBtn;
	}

	public void setHighScoreBtn(boolean highScoreBtn) {
		HighScoreBtn = highScoreBtn;
	}

	public boolean isExitBtn() {
		return ExitBtn;
	}

	public void setExitBtn(boolean exitBtn) {
		ExitBtn = exitBtn;
	}
	
	public void buttonReset(){
		StartBtn = false;
		HighScoreBtn = false;
		ExitBtn = false;
	}

}
