package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.*;
import edu.arizona.ece373.InterplanetaryPioneers.Model.*;
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

import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingConstants;

public class EventPanel extends JPanel {
	
	private final ButtonGroup btnGroupChoice = new ButtonGroup();
	
	private boolean EventActive;
	//private int Severity;
	private int Resolution;
	//private boolean Penalty;
	//private int penaltyType;
	//private int skillType;
	private int Cost;
	private double Chance;
	private boolean event;
	private boolean Outcome;
	private static int queueSize = 8;
	private ArrayList<Event> eventQueue;
	private boolean wormhole = false;
	//protected EventPool eventPool;
	private Event currentEvent, prev1_Event, prev2_Event, prev3_Event;
	private static Random random;
	
	private final static int LOW = 1;
	private final static int MEDIUM = 2;
	private final static int CRITICAL = 3;
	
	private JButton btnConfirm; 
	Timer resultTimer;
	
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
		
		
		lblTitle = new JLabel("Event Encounter");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBackground(new Color(192, 192, 192));
		lblTitle.setForeground(new Color(0, 255, 255));
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTitle.setBounds(406, 11, 524, 38);
		add(lblTitle);
		
		lblEventImage = new JLabel("");
		lblEventImage.setIcon(new ImageIcon("lib/images/powerLoss.png"));
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
				if(btnConfirm.isEnabled()){
					confirm = true;
					resultTimer.stop();
					determineOutcome();
					setVisible(false);
				}
			}
		});
		
		rdbtnOption4 = new JRadioButton("[Ignore]");
		btnGroupChoice.add(rdbtnOption4);
		rdbtnOption4.setOpaque(false);
		rdbtnOption4.setForeground(Color.WHITE);
		rdbtnOption4.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOption4.setBounds(151, 574, 950, 27);
		add(rdbtnOption4);
		btnConfirm.setFont(new Font("Slider", Font.BOLD, 18));
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
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		
		setVisible(false);
		initEventData();
	}
	
	public void initEventData(){
		random = new Random();
		eventQueue  = new ArrayList<Event>(queueSize); 
		//Severity =   Low;		// Lowest Risk
		setResolution(1); 	    // Option A
		//setPenalty(false);     //  No penalty
		//setPenaltyType(0);     //  No penalty type
		setCost(0);         // 0 resource cost of penalty/resolution
		setChance(0.50);      //  standard 50% success
		setOutcome(true);       //  Encounter Resolved 
		EventActive = false;
		//setSkillType(Person.none);
		EventPool.initEventPool();
		currentEvent = EventPool.getEvent(0);
		prev1_Event = currentEvent;
		prev2_Event = currentEvent;
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	if((getResolution() == 2) && !rdbtnOption2.isEnabled()){
		    		btnConfirm.setEnabled(false);
		    	}else if((getResolution() == 3) && !rdbtnOption3.isEnabled()){
		    		btnConfirm.setEnabled(false);
		    	}else{
		    		btnConfirm.setEnabled(true);
		    	}
		    }
		};
		resultTimer = new Timer(50 , taskPerformer);
		resultTimer.stop();
	}
	
	public void setEventPanel(){
		//Prevent duplicates more event variety
		int i = 0;
		currentEvent = EventPool.getRandomEvent();
		if(eventQueue.size() == 0){
			eventQueue.add(currentEvent);
		}else{	
			while(eventQueue.contains(currentEvent) || (currentEvent.isWormHole() && wormhole)){
				currentEvent = EventPool.getRandomEvent();
				i++;
			}
			if(eventQueue.size() < queueSize){
				eventQueue.add(0, currentEvent);
			}else{
				eventQueue.remove(queueSize - 1);
				eventQueue.add(0, currentEvent);
			}
		}
		if(currentEvent.isWormHole()) wormhole = true;
		System.out.println("Event Generations: "+ i + " Event Queue Size: " + eventQueue.size());
		//currentEvent = EventPool.getEvent(7);			//For debugging specific event
		//Set color based off severity
		lblTitle.setText(currentEvent.getTitle());
		lblTitle.setForeground(currentEvent.getTitleColor());
		//Check Resources
		eventResourceCheck();
		//Set Event info
		eventInfo.setText(currentEvent.getDescription());
		//Set option text
		rdbtnOption1.setText(currentEvent.getOption1());
		rdbtnOption2.setText(currentEvent.getOption2());
		rdbtnOption3.setText(currentEvent.getOption3());
		rdbtnOption4.setText(currentEvent.getOption4());
		
		lblEventImage.setIcon(new ImageIcon(currentEvent.getIconLocation()));
		lblEventImage.setBounds(currentEvent.getIconBounds());
		super.repaint();	
		
	}
	
	//Displays the specified Event panel encounter
	public void displayEventEncounter(){
		rdbtnOption1.setSelected(true);
		resultTimer.start();
		EventActive = true;
		confirm = false;
		setEventPanel();
		GameData.totalEvents += 1;
		super.setVisible(true);
		
	}
	
	public void eventResourceCheck(){
		//Assume sufficient resources display all options
		rdbtnOption2.setEnabled(true);
		rdbtnOption3.setEnabled(true);
		//Check for insufficient resources or required skill not available
		if((GameData.getResource(currentEvent.getPenaltyType()) < (currentEvent.getCost() - 15)) || 
			!GameData.checkCrewForSkill(currentEvent.getSkillType())) 
			rdbtnOption2.setEnabled(false);
		//Check for insufficient resources
		if(GameData.getResource(currentEvent.getPenaltyType()) < (currentEvent.getCost())) 		
			rdbtnOption3.setEnabled(false);
	}
	//Resolves the event window and updates all relevant data of encounter
	private void determineOutcome(){
		
		Resolution = getResolution();
		event = false;

		if(currentEvent.isPenalty()){
			if(Resolution == 1){
				Cost = 0;
				event = (Math.random() < Chance);
				Outcome = event;
			}else if(Resolution == 2){
				Cost = currentEvent.getCost() - 15;
				Outcome = true;
			}else if(Resolution == 3){
				Cost = randomCost(currentEvent.getCost());
				Outcome = true;
			}else{
				Outcome = false;
			}
		}else{
			Cost = 0;
			Outcome = true;
			if(Resolution == 1){
				Cost = 0;
				event = (Math.random() < Chance);
				if(event){
					Cost = currentEvent.getCost();
				}
			}else if(Resolution == 2){
				Cost = currentEvent.getCost() - 5;
			}else if(Resolution == 3){
				Cost = randomCost(currentEvent.getCost());
			}else{
				Cost = 0;
			}
			currentEvent.setReward(Cost);
			Outcome = true;
		}
		currentEvent.setOutcome(Outcome);
		EventActive = false;
	
		System.out.println("EventActive: " +EventActive+ "\nSeverity: " + currentEvent.getSeverity()+"\nResolution Selected: "+ Resolution+"\nOutcome: " +Outcome + "\nCost:" + Cost);
		
	}

	public int randomCost(int cost){
	
		return (random.nextInt(cost)/5)*5;
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
	
//	public String getTypeString(boolean override){
//		
//		if(override){
//			if(penaltyType == GameData.fuel) return "Fuel";
//			else if(penaltyType == GameData.food) return "Food";
//			else if(penaltyType == GameData.water) return "Water";
//			else if(penaltyType == GameData.parts) return "Spare parts";
//		}
//		return null;
//	}
//	
//	public int getSeverity(){
//		return Severity;
//	}

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

//	public boolean isPenalty() {
//		return Penalty;
//	}
//
//	public void setPenalty(boolean penalty) {
//		Penalty = penalty;
//	}

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

//	public int getPenaltyType() {
//		return penaltyType;
//	}
//
//	public void setPenaltyType(int penaltyType) {
//		this.penaltyType = penaltyType;
//	}

	public boolean isEventActive() {
		return EventActive;
	}

	public void setEventActive(boolean eventActive) {
		EventActive = eventActive;
	}

//	public int getSkillType() {
//		return skillType;
//	}
//
//	public void setSkillType(int skillType) {
//		this.skillType = skillType;
//	}
	
	public Event getCurrentEvent(){
		return currentEvent;
	}
}
