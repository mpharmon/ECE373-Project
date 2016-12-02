package edu.arizona.ece373.InterplanetaryPioneers.View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectCrew extends JFrame {
	private JPanel contentPane;
	private JTextField crewMemberName1;
	private JTextField crewMemberName2;
	private JTextField crewMemberName3;
	private JTextField crewMemberName4;
	private JTextField crewMemberName5;
	private JTextField CaptainName;
	
	private ArrayList<Person> Crew;
	private int crewCapacity = 5;
	
	private final ButtonGroup buttonVIP_Group = new ButtonGroup();
	private boolean confirm;
	private int windowId;
	
	private JRadioButton rdbtnTrump;
	private JRadioButton rdbtnElonMusk;
	private JRadioButton rdbtnOprah;
	
	private JComboBox comboBox_1;
	private JComboBox comboBox_2; 
	private JComboBox comboBox_3; 
	private JComboBox comboBox_4; 
	private JComboBox comboBox_5; 
	

	/**
	 * Create the frame.
	 */
	public SelectCrew() {
		
		setCrew(new ArrayList<Person>());

		confirm = false;
		windowId = 3;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rdbtnTrump = new JRadioButton("Donald Trump");
		rdbtnTrump.setForeground(new Color(255, 255, 255));
		rdbtnTrump.setOpaque(false);
		rdbtnTrump.setBackground(new Color(211, 211, 211));
		buttonVIP_Group.add(rdbtnTrump);
		rdbtnTrump.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnTrump.setBounds(360, 364, 147, 25);
		contentPane.add(rdbtnTrump);

		rdbtnElonMusk = new JRadioButton("Elon Musk");
		rdbtnElonMusk.setOpaque(false);
		rdbtnElonMusk.setForeground(new Color(255, 255, 255));
		rdbtnElonMusk.setSelected(true);
		buttonVIP_Group.add(rdbtnElonMusk);
		rdbtnElonMusk.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnElonMusk.setBounds(571, 364, 149, 25);
		contentPane.add(rdbtnElonMusk);

		rdbtnOprah = new JRadioButton("Oprah Winfrey");
		rdbtnOprah.setForeground(new Color(255, 255, 255));
		rdbtnOprah.setOpaque(false);
		buttonVIP_Group.add(rdbtnOprah);
		rdbtnOprah.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOprah.setBounds(777, 364, 147, 25);
		contentPane.add(rdbtnOprah);
		
		JLabel lblDoanldImage = new JLabel("New label");
		lblDoanldImage.setIcon(new ImageIcon("lib/images/Donald_Small2.jpg"));
		lblDoanldImage.setBounds(340, 140, 211, 237);
		contentPane.add(lblDoanldImage);
		
		JTextArea txtrBonus = new JTextArea();
		txtrBonus.setFont(new Font("Slider", Font.PLAIN, 15));
		txtrBonus.setText("> 5% Bonus to resources");
		txtrBonus.setForeground(Color.WHITE);
		txtrBonus.setOpaque(false);
		txtrBonus.setBounds(331, 396, 200, 22);
		contentPane.add(txtrBonus);

		JLabel lblElonimage = new JLabel("ElonImage");
		lblElonimage.setIcon(new ImageIcon("lib/images/Elon_Small.jpg"));
		lblElonimage.setBounds(571, 154, 149, 208);
		contentPane.add(lblElonimage);
		
		JTextArea txtrBonus_1 = new JTextArea();
		txtrBonus_1.setText("> 5% Bonus to ship speed");
		txtrBonus_1.setOpaque(false);
		txtrBonus_1.setForeground(Color.WHITE);
		txtrBonus_1.setFont(new Font("Slider", Font.PLAIN, 15));
		txtrBonus_1.setBounds(546, 396, 200, 35);
		contentPane.add(txtrBonus_1);

		JLabel lblOprahImage = new JLabel("New label");
		lblOprahImage.setIcon(new ImageIcon("lib/images/Oprah.jpg"));
		lblOprahImage.setBounds(777, 154, 147, 208);
		contentPane.add(lblOprahImage);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(0, 255, 255));
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(buildCrew()) System.out.println("Crew Built: "+ crewMemberName1.getText() +" "+ crewMemberName2.getText() +" "+crewMemberName3.getText() 
																+" "+crewMemberName4.getText() +" "+crewMemberName5.getText());
				GameData.UserScore.setCaptName(CaptainName.getText());
				confirm = true;
			}
		});
		
		JTextArea txtrBonus_2 = new JTextArea();
		txtrBonus_2.setText("> 5% Bonus to event \r\n   outcomes");
		txtrBonus_2.setOpaque(false);
		txtrBonus_2.setForeground(Color.WHITE);
		txtrBonus_2.setFont(new Font("Slider", Font.PLAIN, 15));
		txtrBonus_2.setBounds(756, 396, 200, 51);
		contentPane.add(txtrBonus_2);
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 18));
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.setBounds(565, 602, 181, 51);
		contentPane.add(btnConfirm);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(983, 196, 116, 25);
		contentPane.add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_2.setSelectedIndex(1);
		comboBox_2.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_2.setBounds(983, 244, 116, 25);
		contentPane.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_3.setSelectedIndex(2);
		comboBox_3.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_3.setBounds(983, 296, 116, 25);
		contentPane.add(comboBox_3);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_4.setSelectedIndex(3);
		comboBox_4.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_4.setBounds(983, 351, 116, 25);
		contentPane.add(comboBox_4);

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "Pilot", "Engineer", "Scientist", "Botanist", "Doctor" }));
		comboBox_5.setSelectedIndex(4);
		comboBox_5.setFont(new Font("Slider", Font.PLAIN, 16));
		comboBox_5.setBounds(983, 406, 116, 25);
		contentPane.add(comboBox_5);

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
		lblSelectCrew.setForeground(new Color(0, 255, 255));
		lblSelectCrew.setBounds(541, 27, 188, 51);
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
		txtrSelectingTheRight.setOpaque(false);
		txtrSelectingTheRight.setForeground(new Color(255, 255, 255));
		txtrSelectingTheRight.setEditable(false);
		txtrSelectingTheRight.setBackground(new Color(211, 211, 211));
		txtrSelectingTheRight.setFont(new Font("Slider", Font.PLAIN, 16));
		txtrSelectingTheRight.setText(
				"Selecting the right crew for your \r\nmission is critical. You have to \r\nselect a VIP since they are sponsoring \r\nthe mission. Below is info regarding \r\nall crew member types:\r\n\r\nVIP\r\nIs a rich passenger who finances \r\nthe journey but provides no other\r\nresources.\r\n\r\nPILOT\r\nA pilot can perform course corrections \r\nif necessary.\r\n\r\nENGINEER\r\nAn engineer can repair and repurpose \r\nany spacecraft systems.\r\n\r\nSCIENTIST\r\nA scientist provides a bonus to positive \r\noutcomes from encountering \r\nastronomical anomalies.\r\n\r\nBOTANIST\r\nA botanist can produce some food and \r\nprovides a bonus to survivability if you \r\nreach your destination.\r\n\r\nDOCTOR\r\nA doctor can heal other crew members \r\nand restore their health.");
		txtrSelectingTheRight.setBounds(24, 46, 306, 626);
		contentPane.add(txtrSelectingTheRight);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(255, 255, 255));
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
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
	
	public int getSelectedVIP(){
		if(rdbtnTrump.isSelected()) return 1;
		else if(rdbtnElonMusk.isSelected()) return 2;
		else if(rdbtnOprah.isSelected()) return 3;
		else return 0;
	}
	

	public String getCrewMemberSkill(int crewSlot){
		
		if(crewSlot == 1){
			return (String) comboBox_1.getSelectedItem();
		}else if(crewSlot == 2){
			return (String) comboBox_2.getSelectedItem();
		}else if(crewSlot == 3){
			return (String) comboBox_3.getSelectedItem();
		}else if(crewSlot == 4){
			return (String) comboBox_4.getSelectedItem();
		}else if(crewSlot == 5){
			return (String) comboBox_5.getSelectedItem();
		}else{
			return null;
		}
	}
	
	//Build Person objects and build crew person array
	private boolean buildCrew(){
		
		Person crewMember1 = null;
		Person crewMember2 = null;
		Person crewMember3 = null;
		Person crewMember4 = null;
		Person crewMember5 = null;
		
		crewMember1 = new Person(crewMemberName1.getText(), comboBox_1.getSelectedIndex()+1, Person.nominal);
		crewMember2 = new Person(crewMemberName2.getText(), comboBox_2.getSelectedIndex()+1, Person.nominal);
		crewMember3 = new Person(crewMemberName3.getText(), comboBox_3.getSelectedIndex()+1, Person.nominal);
		crewMember4 = new Person(crewMemberName4.getText(), comboBox_4.getSelectedIndex()+1, Person.nominal);
		if(crewCapacity > 4) crewMember5 = new Person(crewMemberName5.getText(), comboBox_5.getSelectedIndex()+1, Person.nominal);
		
		getCrew().add(crewMember1);
		getCrew().add(crewMember2);
		getCrew().add(crewMember3);
		getCrew().add(crewMember4);
		if(crewCapacity > 4) getCrew().add(crewMember5);
		
		if(getCrew().size() >= 4) return true;
		return false;
	}

	public ArrayList<Person> getCrew() {
		return Crew;
	}

	public void setCrew(ArrayList<Person> crew) {
		Crew = crew;
	}
	
	public void checkGameData(){
		crewCapacity = GameData.spacecraft.getCrewCapacity();
		if(crewCapacity < 5){
			crewMemberName5.setEnabled(false);
			comboBox_5.setEnabled(false);
		}else{
			crewMemberName5.setEnabled(true);
			comboBox_5.setEnabled(true);
		}
	}
}
