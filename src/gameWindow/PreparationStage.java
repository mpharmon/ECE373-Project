package gameWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PreparationStage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup Planet_buttonGroup = new ButtonGroup();
	private JTextField crewMemberName1;
	private JTextField crewMemberName2;
	private JTextField crewMemberName3;
	private JTextField crewMemberName4;
	private JTextField crewMemberName5;
	private JTextField txtMarkWatney;
	/**
	 * Create the frame.
	 */
	public PreparationStage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Preparation Stage");
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 34));
		lblTitle.setBounds(513, 11, 364, 42);
		contentPane.add(lblTitle);
		
		JLabel lblMarsimage = new JLabel("");
		lblMarsimage.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/mars.jpg")));
		lblMarsimage.setBounds(25, 101, 225, 230);
		contentPane.add(lblMarsimage);
		
		JLabel lblEuropaimage = new JLabel("");
		lblEuropaimage.setToolTipText("\r\n");
		lblEuropaimage.setLabelFor(lblEuropaimage);
		lblEuropaimage.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/Europa_2.jpg")));
		lblEuropaimage.setBounds(25, 368, 225, 216);
		contentPane.add(lblEuropaimage);
		
		JRadioButton rdbtnMars = new JRadioButton("Mars");
		Planet_buttonGroup.add(rdbtnMars);
		rdbtnMars.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnMars.setBounds(89, 338, 109, 23);
		contentPane.add(rdbtnMars);
		
		JRadioButton rdbtnEuropa = new JRadioButton("Europa");
		Planet_buttonGroup.add(rdbtnEuropa);
		rdbtnEuropa.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnEuropa.setBounds(89, 591, 109, 23);
		contentPane.add(rdbtnEuropa);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(424, 630, 501, 23);
		contentPane.add(progressBar);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.setFont(new Font("Slider", Font.PLAIN, 18));
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLaunch.setBounds(593, 581, 156, 42);
		contentPane.add(btnLaunch);
		
		JLabel lblLaunchOfSpacecraft = new JLabel("Launch of spacecraft available once status bar is full. ");
		lblLaunchOfSpacecraft.setFont(new Font("Slider", Font.BOLD, 12));
		lblLaunchOfSpacecraft.setBounds(499, 657, 378, 14);
		contentPane.add(lblLaunchOfSpacecraft);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pilot", "Engineer", "Scientist", "Botanist", "Doctor"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(983, 196, 116, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pilot", "Engineer", "Scientist", "Botanist", "Doctor"}));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_1.setBounds(983, 244, 116, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Pilot", "Engineer", "Scientist", "Botanist", "Doctor"}));
		comboBox_2.setSelectedIndex(2);
		comboBox_2.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_2.setBounds(983, 296, 116, 25);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Pilot", "Engineer", "Scientist", "Botanist", "Doctor"}));
		comboBox_3.setSelectedIndex(3);
		comboBox_3.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_3.setBounds(983, 351, 116, 25);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Pilot", "Engineer", "Scientist", "Botanist", "Doctor"}));
		comboBox_4.setSelectedIndex(4);
		comboBox_4.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_4.setBounds(983, 406, 116, 25);
		contentPane.add(comboBox_4);
		
		JLabel lblSelectCrew = new JLabel("Select Crew:");
		lblSelectCrew.setFont(new Font("Slider", Font.PLAIN, 20));
		lblSelectCrew.setBounds(1046, 148, 147, 23);
		contentPane.add(lblSelectCrew);
		
		crewMemberName1 = new JTextField();
		crewMemberName1.setFont(new Font("Slider", Font.PLAIN, 16));
		crewMemberName1.setText("Jane");
		crewMemberName1.setBounds(1118, 200, 136, 20);
		contentPane.add(crewMemberName1);
		crewMemberName1.setColumns(10);
		
		crewMemberName2 = new JTextField();
		crewMemberName2.setText("John");
		crewMemberName2.setFont(new Font("Slider", Font.PLAIN, 16));
		crewMemberName2.setColumns(10);
		crewMemberName2.setBounds(1118, 248, 136, 20);
		contentPane.add(crewMemberName2);
		
		crewMemberName3 = new JTextField();
		crewMemberName3.setText("Tony Starks");
		crewMemberName3.setFont(new Font("Slider", Font.PLAIN, 16));
		crewMemberName3.setColumns(10);
		crewMemberName3.setBounds(1118, 300, 136, 20);
		contentPane.add(crewMemberName3);
		
		crewMemberName4 = new JTextField();
		crewMemberName4.setText("Picard");
		crewMemberName4.setFont(new Font("Slider", Font.PLAIN, 16));
		crewMemberName4.setColumns(10);
		crewMemberName4.setBounds(1118, 355, 136, 20);
		contentPane.add(crewMemberName4);
		
		crewMemberName5 = new JTextField();
		crewMemberName5.setText("Riker");
		crewMemberName5.setFont(new Font("Slider", Font.PLAIN, 16));
		crewMemberName5.setColumns(10);
		crewMemberName5.setBounds(1118, 410, 136, 20);
		contentPane.add(crewMemberName5);
		
		JLabel labelCaptainName = new JLabel("Captain Name:");
		labelCaptainName.setFont(new Font("Slider", Font.PLAIN, 20));
		labelCaptainName.setBounds(1046, 45, 147, 23);
		contentPane.add(labelCaptainName);
		
		txtMarkWatney = new JTextField();
		txtMarkWatney.setText("Mark Watney");
		txtMarkWatney.setFont(new Font("Slider", Font.PLAIN, 16));
		txtMarkWatney.setBounds(1016, 79, 200, 31);
		contentPane.add(txtMarkWatney);
		txtMarkWatney.setColumns(10);
		
		JLabel lblSelectDestination = new JLabel("Select Destination:");
		lblSelectDestination.setFont(new Font("Slider", Font.PLAIN, 20));
		lblSelectDestination.setBounds(45, 52, 189, 38);
		contentPane.add(lblSelectDestination);
		
		JTextArea txtrEuropaInfo = new JTextArea();
		txtrEuropaInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		txtrEuropaInfo.setText("Name: Europa\r\nClass: Moon\r\nType: Barren Ice world\r\nWater: Subterranean\r\nDistance from Sun: 483.8 M mi\r\n");
		txtrEuropaInfo.setBounds(260, 432, 217, 88);
		contentPane.add(txtrEuropaInfo);
		
		JTextArea textMarsInfo = new JTextArea();
		textMarsInfo.setText("Name: Mars\r\nClass: Planet\r\nType: Arid world\r\nWater: Northern Ice Caps\r\nDistance from Sun: 141.6 M mi\r\n");
		textMarsInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		textMarsInfo.setBounds(260, 166, 217, 88);
		contentPane.add(textMarsInfo);
	}
}
