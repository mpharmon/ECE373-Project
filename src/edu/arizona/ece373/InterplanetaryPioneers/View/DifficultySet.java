package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class DifficultySet extends JFrame {

	private int difficulty;
	private JPanel contentPane;
	private final ButtonGroup Difficulty_buttonGroup = new ButtonGroup();

	private int windowId;
	public static int Easy = 1;
	public static int Normal = 2;
	public static int Hard = 3;
	public static String SPACE_CRUISE = "Space Cruise";
	public static String SPACE_PIONEER = "Space Pioneer";
	public static String SUICIDE_MISSION = "Suicide Mission";
	
	JToggleButton tglbtnSuicideMission;
	JToggleButton tglbtnSpacePioneer;
	JToggleButton tglbtnSpaceCruise;

	/**
	 * Create the frame.
	 */
	public DifficultySet() {

		difficulty = 0;
		setWindowId(1);

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
		tglbtnSuicideMission = new JToggleButton("Suicide Mission");
		tglbtnSuicideMission.setBackground(new Color(0, 255, 255));
		tglbtnSuicideMission.setToolTipText(
				"Limited supplies, more critical event encounters, and a longer realistic trip length.");
		Difficulty_buttonGroup.add(tglbtnSuicideMission);
		tglbtnSuicideMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = Hard;
				System.out.println("Suicide Mission");
			}
		});
		tglbtnSuicideMission.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSuicideMission.setBounds(954, 581, 181, 54);
		contentPane.add(tglbtnSuicideMission);

		tglbtnSpacePioneer = new JToggleButton("Space Pioneer");
		tglbtnSpacePioneer.setBackground(new Color(0, 255, 255));
		tglbtnSpacePioneer.setToolTipText("Standard amount of supplies, more event encounters, and a normal trip length.");
		Difficulty_buttonGroup.add(tglbtnSpacePioneer);
		tglbtnSpacePioneer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				difficulty = Normal;
				System.out.println("Space Pioneer");
			}
		});
		tglbtnSpacePioneer.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSpacePioneer.setBounds(533, 581, 181, 54);
		contentPane.add(tglbtnSpacePioneer);

		tglbtnSpaceCruise = new JToggleButton("Space Cruise");
		tglbtnSpaceCruise.setBackground(new Color(0, 255, 255));
		tglbtnSpaceCruise.setToolTipText("Extra supplies, fewer event encounters, and a shorter trip.");
		Difficulty_buttonGroup.add(tglbtnSpaceCruise);
		tglbtnSpaceCruise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				difficulty = Easy;
				System.out.println("Space Cruise");
			}
		});
		tglbtnSpaceCruise.setFont(new Font("Slider", Font.PLAIN, 18));
		tglbtnSpaceCruise.setBounds(136, 581, 181, 54);
		contentPane.add(tglbtnSpaceCruise);

		JLabel lblGameInfo = new JLabel("Game Info");
		lblGameInfo.setForeground(new Color(0, 255, 255));
		lblGameInfo.setFont(new Font("Slider", Font.PLAIN, 32));
		lblGameInfo.setBounds(538, 11, 176, 41);
		contentPane.add(lblGameInfo);

		JTextPane txtpnYourAmongThe = new JTextPane();
		txtpnYourAmongThe.setForeground(new Color(255, 255, 255));
		txtpnYourAmongThe.setOpaque(false);
		txtpnYourAmongThe.setBackground(Color.LIGHT_GRAY);
		txtpnYourAmongThe.setFont(new Font("Slider", Font.PLAIN, 18));
		txtpnYourAmongThe.setText(
				"Your among the first to boldly go where no has gone before. As founder of the space exploration agency you will decide what other world humanity will colonize first. Its up to you to plan accordingly for your voyage. Space is a hostile place and there is no way to get help from earth. Once you select your destination you will select what space craft, crew, and supplies will be neccessary to ensure mission success. As captain you will have to manage the ship, crew, and resources during the voyage.  Humanity hopes you succeed and that you will lead us into the future where we have colonized our solar system.");
		txtpnYourAmongThe.setBounds(74, 76, 1075, 162);
		contentPane.add(txtpnYourAmongThe);

		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(Color.WHITE);
		lblDifficulty.setFont(new Font("Slider", Font.PLAIN, 36));
		lblDifficulty.setBounds(538, 249, 176, 54);
		contentPane.add(lblDifficulty);

		JLabel lblHardimage = new JLabel("");
		lblHardimage.setIcon(new ImageIcon("lib/images/deadAstronaut.jpg"));
		lblHardimage.setBounds(836, 302, 387, 260);
		contentPane.add(lblHardimage);

		JLabel lblEasyImage = new JLabel("");
		lblEasyImage.setIcon(new ImageIcon("lib/images/SpaceMonkey.jpg"));
		lblEasyImage.setBounds(51, 302, 361, 270);
		contentPane.add(lblEasyImage);

		JLabel lblNormalimage = new JLabel("");
		lblNormalimage.setIcon(new ImageIcon("lib/images/SpacePioneer.jpg"));
		lblNormalimage.setBounds(452, 302, 321, 262);
		contentPane.add(lblNormalimage);

		JLabel labelBackground = new JLabel("");
		labelBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		labelBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(labelBackground);
	}

	public int checkButtons() {
		if (difficulty != 0)
			return 1;
		else
			return 0;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int setting) {
		if ((difficulty >= 0) && (difficulty < 4))
			difficulty = setting;
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
	
	public static String getDiffString(int diff){
		
		if(diff == Easy)
			return SPACE_CRUISE;
		else if(diff == Normal)
			return SPACE_PIONEER;
		else
			return SUICIDE_MISSION;

	}
}
