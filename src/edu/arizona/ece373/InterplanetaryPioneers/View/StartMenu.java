package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class StartMenu extends JFrame {

	private JPanel contentPane;

	private boolean StartBtn;
	private boolean HighScoreBtn;
	private boolean ExitBtn;
	private int windowId;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// StartMenu frame = new StartMenu();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public StartMenu() {

		windowId = 0;

		// Initialize button tracking variables
		StartBtn = false;
		HighScoreBtn = false;
		ExitBtn = false;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(9, 10, 0, 0);
		contentPane.add(label_1);

		JLabel label = new JLabel("   INTERPLANETARY PIONEERS");
		label.setForeground(new Color(0, 255, 255));
		label.setBounds(135, 81, 1007, 73);
		label.setFont(new Font("Slider", Font.PLAIN, 60));
		contentPane.add(label);

		// START Button
		JButton btnStartButton = new JButton("Start");
		btnStartButton.setBackground(new Color(0, 255, 255));
		btnStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Start");
				StartBtn = true;
			}
		});
		btnStartButton.setBounds(518, 320, 219, 60);
		btnStartButton.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnStartButton);

		// High Score Button
		JButton btnHighScores = new JButton("High Scores\r\n");
		btnHighScores.setBackground(new Color(0, 255, 255));
		btnHighScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("High Scores");
				HighScoreBtn = true;
			}
		});
		btnHighScores.setBounds(518, 425, 219, 60);
		btnHighScores.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnHighScores);

		// Exit Button
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(0, 255, 255));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Exit");
				ExitBtn = true;
				System.exit(0);
			}
		});
		btnExit.setBounds(518, 537, 219, 60);
		btnExit.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnExit);

		// Main Menu Image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1264, 682);
		lblNewLabel.setIcon(new ImageIcon("lib/images/Deep-Space-Cloud3_0.jpg"));
		contentPane.add(lblNewLabel);
	}

	// Checks whether any of the three buttons were clicked
	public int checkButtons() {

		if (StartBtn && !HighScoreBtn && !ExitBtn)
			return 1;
		else if (!StartBtn && HighScoreBtn && !ExitBtn)
			return 2;
		else if (ExitBtn)
			return 3;
		else
			return 0;
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

}
