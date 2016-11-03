package gameWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartMenu extends JFrame {

	private JPanel contentPane;
	
	private boolean StartBtn;
	private boolean HighScoreBtn;
	private boolean ExitBtn;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StartMenu frame = new StartMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public StartMenu() {
		
		//Initialize button tracking variables
		StartBtn = false;
		HighScoreBtn = false;
		ExitBtn = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(9, 10, 0, 0);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("   INTERPLANETARY PIONEERS");
		label.setBounds(287, 25, 682, 51);
		label.setFont(new Font("Slider", Font.PLAIN, 44));
		contentPane.add(label);
		
		//START Button
		JButton btnStartButton = new JButton("Start");
		btnStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Start");
				StartBtn = true;
			}
		});
		btnStartButton.setBounds(1053, 356, 97, 37);
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStartButton.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnStartButton);
		
		//Main Menu Image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(9, 123, 960, 540);
		lblNewLabel.setIcon(new ImageIcon(StartMenu.class.getResource("/images/superNova_1C.jpg")));
		contentPane.add(lblNewLabel);
		
		//High Score Button
		JButton btnHighScores = new JButton("High Scores\r\n");
		btnHighScores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("High Scores");
				HighScoreBtn = true;
			}
		});
		btnHighScores.setBounds(1054, 460, 171, 37);
		btnHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHighScores.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnHighScores);
		
		//Exit Button
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Exit");
				ExitBtn = true;
			}
		});
		btnExit.setBounds(1053, 566, 77, 37);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("Slider", Font.PLAIN, 24));
		contentPane.add(btnExit);
	}
	
	//Checks whether any of the three buttons were clicked
	public int checkButtons(){
		
		if(StartBtn && !HighScoreBtn && !ExitBtn) return 1;
		else if(!StartBtn && HighScoreBtn && !ExitBtn) return 2;
		else if(ExitBtn) return 3;
		else return 0;
	}

}
