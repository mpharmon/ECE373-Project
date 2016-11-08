package gameWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectCrew extends JFrame {

	private JPanel contentPane;
	private JTextField crewMemberName1;
	private JTextField crewMemberName2;
	private JTextField crewMemberName3;
	private JTextField crewMemberName4;
	private JTextField crewMemberName5;
	private JTextField CaptainName;
	private final ButtonGroup buttonVIP_Group = new ButtonGroup();
	private boolean confirm;
	private int windowId;

	/**
	 * Create the frame.
	 */
	public SelectCrew() {

		confirm = false;
		windowId = 3;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnDonaldTrump = new JRadioButton("Donald Trump");
		rdbtnDonaldTrump.setBackground(new Color(211, 211, 211));
		buttonVIP_Group.add(rdbtnDonaldTrump);
		rdbtnDonaldTrump.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnDonaldTrump.setBounds(367, 393, 147, 25);
		contentPane.add(rdbtnDonaldTrump);

		JRadioButton radioElonMusk = new JRadioButton("Elon Musk");
		radioElonMusk.setSelected(true);
		buttonVIP_Group.add(radioElonMusk);
		radioElonMusk.setFont(new Font("Slider", Font.PLAIN, 16));
		radioElonMusk.setBounds(579, 393, 149, 25);
		contentPane.add(radioElonMusk);

		JRadioButton rdbtnOprah = new JRadioButton("Oprah Winfrey");
		buttonVIP_Group.add(rdbtnOprah);
		rdbtnOprah.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOprah.setBounds(777, 393, 147, 25);
		contentPane.add(rdbtnOprah);

		JLabel lblDoanldImage = new JLabel("New label");
		lblDoanldImage.setIcon(new ImageIcon(SelectCrew.class.getResource("/images/Donald_Small2.jpg")));
		lblDoanldImage.setBounds(340, 140, 211, 237);
		contentPane.add(lblDoanldImage);

		JLabel lblElonimage = new JLabel("ElonImage");
		lblElonimage.setIcon(new ImageIcon(SelectCrew.class.getResource("/images/Elon_Small.jpg")));
		lblElonimage.setBounds(565, 140, 176, 237);
		contentPane.add(lblElonimage);

		JLabel lblOprahImage = new JLabel("New label");
		lblOprahImage.setIcon(new ImageIcon(SelectCrew.class.getResource("/images/Oprah.jpg")));
		lblOprahImage.setBounds(767, 140, 187, 237);
		contentPane.add(lblOprahImage);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				confirm = true;
			}
		});
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 18));
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.setBounds(565, 612, 154, 41);
		contentPane.add(btnConfirm);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(983, 196, 116, 25);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_1.setSelectedIndex(1);
		comboBox_1.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_1.setBounds(983, 244, 116, 25);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_2.setSelectedIndex(2);
		comboBox_2.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_2.setBounds(983, 296, 116, 25);
		contentPane.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_3.setSelectedIndex(3);
		comboBox_3.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_3.setBounds(983, 351, 116, 25);
		contentPane.add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_4.setSelectedIndex(4);
		comboBox_4.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_4.setBounds(983, 406, 116, 25);
		contentPane.add(comboBox_4);

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
		labelCaptainName.setForeground(new Color(255, 255, 255));
		labelCaptainName.setFont(new Font("Slider", Font.PLAIN, 20));
		labelCaptainName.setBounds(1046, 45, 147, 23);
		contentPane.add(labelCaptainName);

		CaptainName = new JTextField();
		CaptainName.setText("Mark Watney");
		CaptainName.setFont(new Font("Slider", Font.PLAIN, 16));
		CaptainName.setBounds(1016, 79, 200, 31);
		contentPane.add(CaptainName);
		CaptainName.setColumns(10);

		JLabel lblSelectCrew = new JLabel("Select Crew");
		lblSelectCrew.setFont(new Font("Slider", Font.PLAIN, 32));
		lblSelectCrew.setForeground(new Color(255, 255, 255));
		lblSelectCrew.setBounds(541, 27, 284, 51);
		contentPane.add(lblSelectCrew);

		JLabel lblCrewSkillset = new JLabel("Crew Skillset:");
		lblCrewSkillset.setForeground(new Color(255, 255, 255));
		lblCrewSkillset.setFont(new Font("Slider", Font.PLAIN, 20));
		lblCrewSkillset.setBounds(981, 147, 136, 38);
		contentPane.add(lblCrewSkillset);

		JLabel labelCrewMemberName = new JLabel("Name:");
		labelCrewMemberName.setForeground(Color.WHITE);
		labelCrewMemberName.setFont(new Font("Slider", Font.PLAIN, 20));
		labelCrewMemberName.setBounds(1149, 147, 67, 38);
		contentPane.add(labelCrewMemberName);

		JLabel lblSelectVip = new JLabel("Select VIP:");
		lblSelectVip.setFont(new Font("Slider", Font.PLAIN, 20));
		lblSelectVip.setForeground(new Color(255, 255, 255));
		lblSelectVip.setBounds(575, 103, 107, 25);
		contentPane.add(lblSelectVip);

		JTextArea txtrSelectingTheRight = new JTextArea();
		txtrSelectingTheRight.setBackground(new Color(211, 211, 211));
		txtrSelectingTheRight.setFont(new Font("Slider", Font.PLAIN, 16));
		txtrSelectingTheRight.setText(
				"Selecting the right crew for your \r\nmission is critical. You have to \r\nselect a VIP since they are sponsoring \r\nthe mission. Below is info regarding \r\nall crew member types:\r\n\r\nVIP\r\nIs a rich passenger who finances \r\nthe journey but provides no other\r\nresources.\r\n\r\nPILOT\r\nA pilot can perform course corrections \r\nif necessary.\r\n\r\nENGINEER\r\nAn engineer can repair and repurpose \r\nany spacecraft systems.\r\n\r\nSCIENTIST\r\nA scientist provides a bonus to positive \r\noutcomes from encountering \r\nastronomical anomalies.\r\n\r\nBOTANIST\r\nA botanist can produce some food and \r\nprovides a bonus to survivability if you \r\nreach your destination.\r\n\r\nDOCTOR\r\nA doctor can heal other crew members \r\nand restore their health.");
		txtrSelectingTheRight.setBounds(24, 46, 306, 626);
		contentPane.add(txtrSelectingTheRight);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(255, 255, 255));
		lblBackground.setIcon(new ImageIcon(SelectCrew.class.getResource("/images/Space.jpg")));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
	
	public int checkButtons(){
		if(confirm) return 1;
		else return 0;
	}
}
