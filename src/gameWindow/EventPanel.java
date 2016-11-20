package gameWindow;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class EventPanel extends JPanel {
	
	private final ButtonGroup btnGroupChoice = new ButtonGroup();
	
	private boolean EventActive;
	private int Severity;
	private int Resolution;
	private boolean Penalty;
	private int penaltyType;
	private int Cost;
	private double Chance;
	private boolean event;
	private boolean Outcome;
	
	private final static int Low = 0;
	private final static int Moderate = 1;
	private final static int High = 2;
	private final static int Critical = 3;
	
	private final static int fuel = 0;
	private final static int food = 1;
	private final static int water = 2;
	private final static int parts = 3;
	
	private JButton btnConfirm; 
	
	/**
	 * Modular Event Panel Parameters
	 */
	
	private JLabel lblTitle;
	private JLabel lblEventImage;
	private JTextArea eventInfo;
	private JRadioButton rdbtnOption1;
	private JRadioButton rdbtnOption2;
	private JRadioButton rdbtnOption3;
	private JRadioButton rdbtnOption4;
	private JLabel lblBackground;
	
	/**
	 * Create the panel.
	 */
	public EventPanel(int select) {
		setLayout(null);
		
		lblTitle = new JLabel("Event Ecounter");
		lblTitle.setForeground(new Color(0, 255, 255));
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTitle.setBounds(530, 11, 236, 38);
		add(lblTitle);
		
		lblEventImage = new JLabel("");
		lblEventImage.setIcon(new ImageIcon(EventPanel.class.getResource("/images/powerLoss.png")));
		lblEventImage.setBounds(492, 90, 300, 300);
		add(lblEventImage);
		
		rdbtnOption1 = new JRadioButton("Resolve Attempt");
		rdbtnOption1.setOpaque(false);
		rdbtnOption1.setForeground(new Color(0, 255, 255));
		rdbtnOption1.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOption1.setSelected(true);
		btnGroupChoice.add(rdbtnOption1);
		rdbtnOption1.setBounds(180, 521, 1000, 23);
		add(rdbtnOption1);
		
		rdbtnOption2 = new JRadioButton("Ignore");
		rdbtnOption2.setOpaque(false);
		rdbtnOption2.setForeground(new Color(255, 255, 255));
		rdbtnOption2.setFont(new Font("Slider", Font.PLAIN, 16));
		btnGroupChoice.add(rdbtnOption2);
		rdbtnOption2.setBounds(180, 547, 1000, 23);
		add(rdbtnOption2);
		
		rdbtnOption3 = new JRadioButton("[Crew]");
		rdbtnOption3.setOpaque(false);
		rdbtnOption3.setForeground(new Color(0, 255, 127));
		rdbtnOption3.setFont(new Font("Slider", Font.PLAIN, 16));
		btnGroupChoice.add(rdbtnOption3);
		rdbtnOption3.setBounds(180, 573, 1000, 23);
		add(rdbtnOption3);
		
		rdbtnOption4 = new JRadioButton("[VIP]");
		rdbtnOption4.setOpaque(false);
		rdbtnOption4.setForeground(new Color(147, 112, 219));
		rdbtnOption4.setFont(new Font("Slider", Font.PLAIN, 16));
		btnGroupChoice.add(rdbtnOption4);
		rdbtnOption4.setBounds(180, 599, 1000, 23);
		add(rdbtnOption4);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				determineOutcome();
			}
		});
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 18));
		btnConfirm.setBackground(new Color(0, 255, 255));
		btnConfirm.setBounds(554, 629, 185, 46);
		add(btnConfirm);
		
		eventInfo = new JTextArea("Event info goes here. ");
		eventInfo.setLineWrap(true);
		eventInfo.setFont(new Font("Slider", Font.PLAIN, 18));
		eventInfo.setOpaque(false);
		eventInfo.setBackground(new Color(0, 255, 255));
		eventInfo.setForeground(new Color(0, 255, 255));
		eventInfo.setBounds(180, 397, 911, 105);
		add(eventInfo);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(EventPanel.class.getResource("/images/hud_bg_full.jpg")));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		setEventPanel(0);
		setVisible(false);
	}
	
	public void initEventData(){
		Severity =   Low;		// Lowest Risk
		setResolution(1); 	    // Option A
		setPenalty(false);     //  No penalty
		setPenaltyType(0);     //  No penalty type
		setCost(0);         // 0 resource cost of penalty/resolution
		setChance(0.50);      //  standard 50% success
		setOutcome(true);       //  Encounter Resolved 
		EventActive = false;
	}
	
	public void setEventData(int severity, boolean penalty, int type, int cost, double chance){
		Severity = severity;		
		setResolution(1); 	    // Option A default
		setPenalty(penalty);    
		setPenaltyType(type);    
		setCost(cost);         
		setChance(chance);      
		setOutcome(true);      // default outcome 
	}
	
	public void setEventPanel(int select){
		switch (select) {
		case 0:
			//Set color based off severity
			lblTitle.setForeground(new Color(0, 255, 255));
			//Event data set
			setEventData(Low, true, parts, 25, 0.50);
			//Set Event info
			eventInfo.setText("The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue "
					+ "now or ignore it. Ignoring a minor problem now can result in complications later on. The decision is yours \ncaptain.");
			//Set option text
			rdbtnOption1.setText("[Success chance "+ Chance*100 +"%] Attempt to resolve power outtage youself.");
			rdbtnOption2.setText("Ignore issue for now.");
			rdbtnOption3.setText("[10 "+ getTypeString(penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
			rdbtnOption4.setText("10 - 25 "+ getTypeString(penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
			
			lblEventImage.setIcon(new ImageIcon(EventPanel.class.getResource("/images/powerLoss.png")));
			lblEventImage.setBounds(466, 95, 300, 300);
			
			super.repaint();
			break;
		case 1:
			
			break;
		case 2:
			
			break;	
		
		}
	}
	
	//Displays the specified Event panel encounter
	public void displayEventEncounter(int select){
		
		EventActive = true;
		setEventPanel(select);
		super.setVisible(true);
		
	}
	//Resolves the event window and updates all relevant data of encounter
	private void determineOutcome(){
		
		switch (Severity){
			case Low:
				Resolution = getResolution();
				if(Penalty){
					if(Resolution == 1) event = (Math.random() < Chance);
				}else{
					Cost = 0;
					Outcome = true;
				}
				EventActive = false;
				break;
			case Moderate:
				
				Resolution = getResolution();
				EventActive = false;
				break;
			case High:
				
				Resolution = getResolution();
				EventActive = false;
				break;
			case Critical:
				
				Resolution = getResolution();
				EventActive = false;
				break;
		}
		
	}
	/**
	 * Getters and Setters
	 */
	
	public String getTypeString(int type){
		
		if(type == fuel) return "fuel";
		else if(type == food) return "food";
		else if(type == water) return "water";
		else if(type == parts) return "Spare parts";
		
		return null;
	}
	
	public int getSeverity(){
		return Severity;
	}

	public int getResolution() {
		if(rdbtnOption1.isSelected()) return 1;
		else if(rdbtnOption2.isSelected()) return 2;
		else if(rdbtnOption3.isSelected()) return 3;
		else if(rdbtnOption4.isSelected()) return 4;
	
		return 0;
	}

	public void setResolution(int resolution) {
		Resolution = resolution;
	}

	public boolean isPenalty() {
		return Penalty;
	}

	public void setPenalty(boolean penalty) {
		Penalty = penalty;
	}

	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		this.Cost = cost;
	}

	public double getChance() {
		return Chance;
	}

	public void setChance(double chance) {
		Chance = chance;
	}

	public boolean isOutcome() {
		return Outcome;
	}

	public void setOutcome(boolean outcome) {
		Outcome = outcome;
	}

	public int getPenaltyType() {
		return penaltyType;
	}

	public void setPenaltyType(int penaltyType) {
		this.penaltyType = penaltyType;
	}

	public boolean isEventActive() {
		return EventActive;
	}

	public void setEventActive(boolean eventActive) {
		EventActive = eventActive;
	}
}
