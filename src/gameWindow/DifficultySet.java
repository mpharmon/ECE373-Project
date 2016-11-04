package gameWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class DifficultySet extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DifficultySet frame = new DifficultySet();
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
	public DifficultySet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		* Create buttons for difficulty settings
		*/
		JToggleButton tglbtnSuicideMission = new JToggleButton("Suicide Mission");
		buttonGroup.add(tglbtnSuicideMission);
		tglbtnSuicideMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Suicide Mission");
			}
		});
		tglbtnSuicideMission.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSuicideMission.setBounds(895, 442, 181, 54);
		contentPane.add(tglbtnSuicideMission);
		
		JToggleButton tglbtnSpacePioneer = new JToggleButton("Space Pioneer");
		buttonGroup.add(tglbtnSpacePioneer);
		tglbtnSpacePioneer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Space Pioneer");
			}
		});
		tglbtnSpacePioneer.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSpacePioneer.setBounds(513, 442, 181, 54);
		contentPane.add(tglbtnSpacePioneer);
		
		JToggleButton tglbtnSpaceCruise = new JToggleButton("Space Cruise");
		buttonGroup.add(tglbtnSpaceCruise);
		tglbtnSpaceCruise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Space Cruise");
			}
		});
		tglbtnSpaceCruise.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSpaceCruise.setBounds(122, 442, 181, 54);
		contentPane.add(tglbtnSpaceCruise);
		
		JLabel lblGameInfo = new JLabel("Game Info");
		lblGameInfo.setForeground(Color.WHITE);
		lblGameInfo.setFont(new Font("Slider", Font.PLAIN, 32));
		lblGameInfo.setBounds(538, 11, 176, 41);
		contentPane.add(lblGameInfo);
		
		JTextPane txtpnYourAmongThe = new JTextPane();
		txtpnYourAmongThe.setBackground(Color.LIGHT_GRAY);
		txtpnYourAmongThe.setFont(new Font("Slider", Font.PLAIN, 18));
		txtpnYourAmongThe.setText("Your among the first to boldly go where no has gone before. As founder of the space exploration agency you will decide what other world humanity will colonize first. Its up to you to plan accordingly for your voyage. Space is a hostile place and there is no way to get help from earth. Once you select your destination you will select what space craft, crew, and supplies will be neccessary to ensure mission success. As captain you will have to manage the ship, crew, and resources during the voyage.  Humanity hopes you succeed and that you will lead us into the future where we have colonized our solar system.");
		txtpnYourAmongThe.setBounds(74, 76, 1075, 162);
		contentPane.add(txtpnYourAmongThe);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(Color.WHITE);
		lblDifficulty.setFont(new Font("Slider", Font.PLAIN, 36));
		lblDifficulty.setBounds(538, 281, 176, 54);
		contentPane.add(lblDifficulty);
		
		JLabel lblHardimage = new JLabel("");
		lblHardimage.setIcon(new ImageIcon(DifficultySet.class.getResource("/images/deadAstronaut.jpg")));
		lblHardimage.setBounds(843, 364, 387, 260);
		contentPane.add(lblHardimage);
		
		JLabel lblEasyImage = new JLabel("");
		lblEasyImage.setIcon(new ImageIcon(DifficultySet.class.getResource("/images/SpaceMonkey.jpg")));
		lblEasyImage.setBounds(51, 364, 361, 270);
		contentPane.add(lblEasyImage);
		
		JLabel lblNormalimage = new JLabel("");
		lblNormalimage.setIcon(new ImageIcon(DifficultySet.class.getResource("/images/SpacePioneer.jpg")));
		lblNormalimage.setBounds(453, 362, 321, 262);
		contentPane.add(lblNormalimage);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon(DifficultySet.class.getResource("/images/Space.jpg")));
		labelBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(labelBackground);
	}
}
