package gameWindow;

import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.arizona.ece373.InterplanetaryPioneers.Model.EventPool;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;
import gameExecution.GameData;

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
	private int skillType;
	private int Cost;
	private double Chance;
	private boolean event;
	private boolean Outcome;
	protected EventPool eventPool;
	
	private final static int Low = 1;
	private final static int Moderate = 2;
	private final static int High = 3;
	private final static int Critical = 4;
	
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
	
	private boolean confirm = false;
	
	/**
	 * Create the panel.
	 */
	public EventPanel() {
		setLayout(null);
		
		
		lblTitle = new JLabel("Event Ecounter");
		lblTitle.setForeground(new Color(0, 255, 255));
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTitle.setBounds(530, 11, 236, 38);
		add(lblTitle);
		
		lblEventImage = new JLabel("");
		lblEventImage.setIcon(new ImageIcon(EventPanel.class.getResource("/images/powerLoss.png")));
		lblEventImage.setBounds(511, 86, 300, 300);
		add(lblEventImage);
		
		rdbtnOption1 = new JRadioButton("Resolve Attempt");
		rdbtnOption1.setOpaque(false);
		rdbtnOption1.setForeground(new Color(0, 255, 255));
		rdbtnOption1.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOption1.setSelected(true);
		btnGroupChoice.add(rdbtnOption1);
		rdbtnOption1.setBounds(151, 484, 1039, 27);
		add(rdbtnOption1);
		
		rdbtnOption2 = new JRadioButton("[Crew]");
		rdbtnOption2.setOpaque(false);
		rdbtnOption2.setForeground(new Color(0, 255, 127));
		rdbtnOption2.setFont(new Font("Slider", Font.PLAIN, 16));
		btnGroupChoice.add(rdbtnOption2);
		rdbtnOption2.setBounds(151, 514, 1039, 27);
		add(rdbtnOption2);
		
		rdbtnOption3 = new JRadioButton("[VIP]");
		rdbtnOption3.setOpaque(false);
		rdbtnOption3.setForeground(new Color(147, 112, 219));
		rdbtnOption3.setFont(new Font("Slider", Font.PLAIN, 16));
		btnGroupChoice.add(rdbtnOption3);
		rdbtnOption3.setBounds(151, 544, 1039, 27);
		add(rdbtnOption3);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirm = !confirm;
				determineOutcome();
				setVisible(false);
			}
		});
		
		rdbtnOption4 = new JRadioButton("[Ignore]");
		btnGroupChoice.add(rdbtnOption4);
		rdbtnOption4.setOpaque(false);
		rdbtnOption4.setForeground(Color.WHITE);
		rdbtnOption4.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOption4.setBounds(151, 574, 950, 27);
		add(rdbtnOption4);
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 18));
		btnConfirm.setBackground(new Color(0, 255, 255));
		btnConfirm.setBounds(554, 629, 185, 46);
		add(btnConfirm);
		
		eventInfo = new JTextArea("Event info goes here. ");
		eventInfo.setEditable(false);
		eventInfo.setLineWrap(true);
		eventInfo.setFont(new Font("Slider", Font.PLAIN, 18));
		eventInfo.setOpaque(false);
		eventInfo.setBackground(new Color(0, 255, 255));
		eventInfo.setForeground(new Color(0, 255, 255));
		eventInfo.setBounds(151, 397, 1000, 80);
		add(eventInfo);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(EventPanel.class.getResource("/images/hud_bg_full.jpg")));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		setVisible(false);
		initEventData();
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
		setSkillType(Person.none);
		eventPool = new EventPool();
		eventPool.initEventPool();
	}
	
	public void setEventData(int severity, boolean penalty, int type, int cost, double chance, int skillType){
		Severity = severity;		
		setResolution(1); 	    // Option A default
		setPenalty(penalty);    
		setPenaltyType(type);    
		setCost(cost);         
		setChance(chance);      
		setOutcome(true);      // default outcome 
		setSkillType(skillType);
	}
	
	public void setEventPanel(int select, GameData gameData){
		switch (select) {
			case 0:
				//Set color based off severity
				lblTitle.setForeground(new Color(0, 255, 255));
				//Event data configuration
				setEventData(Low, true, GameData.parts, 25, 0.50, Person.engineer);
				//Check Resources
				eventResourceCheck(gameData);
				//Set Event info
				eventInfo.setText("The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue\n "
						+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
				//Set option text
				rdbtnOption1.setText("[Success chance "+ Chance*100 +"%] Attempt to resolve power outtage youself.");
				rdbtnOption2.setText("["+ String.valueOf(Cost - 15) + " "+ getTypeString(penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
				rdbtnOption3.setText("[5 - 25 "+ getTypeString(penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
				rdbtnOption4.setText("The severity of the malfunction is low. You decide to ignore the problem for now.");
				
				lblEventImage.setIcon(new ImageIcon(EventPanel.class.getResource("/images/powerLoss.png")));
				lblEventImage.setBounds(466, 95, 300, 300);
				
				super.repaint();
				break;
			case 1:
				//Set color based off severity
				lblTitle.setForeground(Color.YELLOW);
				//Event data set
				setEventData(Moderate, true, GameData.water, 15, 0.35, Person.scientist);
				//Check Resources
				eventResourceCheck(gameData);
				//Set Event info
				eventInfo.setText("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
						+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
				//Set option text
				rdbtnOption1.setText("[Success chance "+ Chance*100 +"%] Attempt to resolve fire youself.");
				rdbtnOption2.setText("["+ String.valueOf(Cost - 15) + " "+ getTypeString(penaltyType) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.");
				rdbtnOption3.setText("[0 - 15 "+ getTypeString(penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
				rdbtnOption4.setText("You hope nothing will go wrong and ignore the fire.");
				
				lblEventImage.setIcon(new ImageIcon(EventPanel.class.getResource("/images/fire.png")));
				lblEventImage.setBounds(440, 75, 453, 350);
				break;
			default:
				//Set color based off severity
				lblTitle.setForeground(new Color(0, 255, 255));
				//Event data configuration
				setEventData(Low, true, GameData.parts, 25, 0.50, Person.engineer);
				//Check Resources
				eventResourceCheck(gameData);
				//Set option text
				rdbtnOption1.setText("[Success chance "+ Chance*100 +"%] Attempt to resolve power outtage youself.");
				rdbtnOption2.setText("["+ String.valueOf(Cost - 15) + " "+ getTypeString(penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
				rdbtnOption3.setText("[5 - 25 "+ getTypeString(penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
				rdbtnOption4.setText("The severity of the malfunction is low. You decide to ignore the problem for now.");
				break;	
		
		}
	}
	
	//Displays the specified Event panel encounter
	public void displayEventEncounter(GameData gameData){
		
		EventActive = true;
		setEventPanel(randomEvent(2), gameData);
		super.setVisible(true);
		
	}
	//Returns a random event id (int) between 0 and numEvents
	public int randomEvent(int numEvents){
		Double temp;
		
		temp = new Double((Math.random() * (numEvents)));
		
		return temp.intValue();
	}
	
	public void eventResourceCheck(GameData gameData){
		//Assume sufficient resources display all options
		rdbtnOption2.setEnabled(true);
		rdbtnOption3.setEnabled(true);
		//Check for sufficient resources
		if(gameData.getResource(penaltyType) < (Cost - 15)) rdbtnOption2.setEnabled(false);
		if(gameData.getResource(penaltyType) < (Cost)) 		rdbtnOption3.setEnabled(false);
	}
	//Resolves the event window and updates all relevant data of encounter
	private void determineOutcome(){
		
		Resolution = getResolution();
		
		switch (Severity){
			case Low:
				if(Penalty){
					if(Resolution == 1){
						Cost = 0;
						event = (Math.random() < Chance);
						Outcome = event;
					}else if(Resolution == 2){
						Cost = Cost - 15;
						Outcome = true;
					}else if(Resolution == 3){
						Cost = randomCost(Cost, 0.50);
						Outcome = true;
					}else{
						event = (Math.random() < (Chance - 10));
						Outcome = event;
					}
				}else{
					Cost = 0;
					Outcome = true;
				}
				EventActive = false;
				break;
			case Moderate:
				if(Penalty){
					if(Resolution == 1){
						Cost = 0;
						event = (Math.random() < Chance);
						Outcome = event;
					}else if(Resolution == 2){
						Cost = Cost - 15;
						Outcome = true;
					}else if(Resolution == 3){
						Cost = randomCost(Cost, 0.50);
						Outcome = true;
					}else{
						event = (Math.random() < (Chance - 15));
						Outcome = event;
					}
				}else{
					Cost = 0;
					Outcome = true;
				}
				EventActive = false;
				break;
			case High:
				if(Penalty){
					if(Resolution == 1){
						Cost = 0;
						event = (Math.random() < Chance);
						Outcome = event;
					}else if(Resolution == 2){
						Cost = Cost - 15;
						Outcome = true;
					}else if(Resolution == 3){
						Cost = randomCost(Cost, 0.50);
						Outcome = true;
					}else{
						event = (Math.random() < (Chance - 20));
						Outcome = event;
					}
				}else{
					Cost = 0;
					Outcome = true;
				}
				EventActive = false;
				break;
			case Critical:
				if(Penalty){
					if(Resolution == 1){
						Cost = 0;
						event = (Math.random() < Chance);
						Outcome = event;
					}else if(Resolution == 2){
						Cost = Cost - 15;
						Outcome = true;
					}else if(Resolution == 3){
						Cost = randomCost(Cost, 0.50);
						Outcome = true;
					}else{
						//Ignoring critical event is an automatic failure condition
						Outcome = false;
					}
				}else{
					Cost = 0;
					Outcome = true;
				}
				EventActive = false;
				break;
		}
		System.out.println("EventActive: " +EventActive+ "\nSeverity: " + Severity +"\nResolution Selected: "+ Resolution+"\nOutcome: " +Outcome + "\nCost:" + Cost);
		
	}

	
	public int randomCost(int cost, double chance){
		
		Double temp;
		//Chance of cost being between 5 and Cost
		if(Math.random() < chance){
			
			temp = new Double((Math.random() * Cost) - 5);
			cost = (temp.intValue()%5)*5 + 5;
			
		}//Chance of cost being between 15 and Cost
		else{
			
			temp = new Double(Math.random() * Cost - 15);
			cost = (temp.intValue()%5)*5 + 15;
		}
		
		return cost;
	}
	/**
	 * Getters and Setters
	 */
	
	public String getTypeString(int type){
		
		if(type == GameData.fuel) return "fuel";
		else if(type == GameData.food) return "food";
		else if(type == GameData.water) return "water";
		else if(type == GameData.parts) return "Spare parts";
		
		return null;
	}
	
	public String getTypeString(boolean override){
		
		if(override){
			if(penaltyType == GameData.fuel) return "Fuel";
			else if(penaltyType == GameData.food) return "Food";
			else if(penaltyType == GameData.water) return "Water";
			else if(penaltyType == GameData.parts) return "Spare parts";
		}
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

	public int getSkillType() {
		return skillType;
	}

	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}
}
