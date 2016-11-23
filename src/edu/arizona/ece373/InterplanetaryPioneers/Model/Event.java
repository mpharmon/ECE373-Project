package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameExecution.GameData;

public class Event {
	private String  	title;
	private int 	  	severity;
	private boolean 	Penalty;
	private int 	  	penaltyType;
	private int	  		cost;
	private double  	chance;
	private int 	  	skillType;
	private String  	description;
	private String  	option1;
	private String  	option2;
	private String  	option3;
	private String  	option4;
	private String  	gameOver;
	private String  	iconLocation;
	private Color	  	titleColor;
	private String  	eventText;
	private Rectangle iconBounds;
	private boolean Injury;		 //Crew Injury flag
	private boolean Damage;        //Ship Damage flag
	private boolean OverCondition; //Game over flag

	//Event severity definitions
	public final static int Low = 1;
	public final static int Moderate = 2;
	//public final static int High = 3;
	public final static int Critical = 3;

	// Constructor(s)
	public Event() {
		title = "Event Ecounter";
		setSeverity(Low);
		setPenalty(false);
		setPenaltyType(GameData.parts);
		cost = 0;
		setChance(0.50);
		setSkillType(Person.none);
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		setGameOver("All critical events must have a game over description");
		this.titleColor = new Color(0,255,255);
	}
	//Custom Constructor
	public Event(int severity, boolean penalty, int penaltyType, int cost, double chance, int skillType, boolean injury, boolean damage) {
		title = "Event Ecounter";
		this.setSeverity(severity);
		this.setPenalty(penalty);
		this.setPenaltyType(penaltyType);
		this.cost = cost;
		this.setChance(chance);
		this.setInjury(injury);
		this.setSkillType(skillType);
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		setGameOver("All critical events must have a game over description");
		if(severity == Critical) setOverCondition(true);
		else  setOverCondition(false);
	}

	// Get'ers and Set'ers
	public String getTitle() {
		return this.title;
	}

	public ImageIcon getIcon(){
	//"/images/powerLoss.png"
		return new ImageIcon(this.iconLocation);
	}
	public void 	setDescription(String d){this.description = d;}
	public String 	getDescription(){return this.description;}

	public void		setTitle(String t){this.title = t;}
	
	public void		setTitleColor(Color c){this.titleColor = c;}
	public Color 	getTitleColor(){return this.titleColor;}
	
	public void 	setIconLocation(String loc){this.iconLocation = loc;}
	public String 	getIconLocation(){return this.iconLocation;}
	
	public void		setIconBounds(int x, int y, int w, int h){this.iconBounds = new Rectangle(x,y,w,h);}
	public Rectangle	getIconBounds(){return this.iconBounds;};
	
	public void 	setEventText(String t){this.eventText = t;}
	public String 	getEventText(){return this.eventText;}
	
	public void		setOption1(String t){this.option1 = t;}
	public String	getOption1(){return this.option1;}
	
	public void		setOption2(String t){this.option2 = t;}
	public String	getOption2(){return this.option2;}
	
	public void		setOption3(String t){this.option3 = t;}
	public String	getOption3(){return this.option3;}
	
	public void		setOption4(String t){this.option4 = t;}
	public String	getOption4(){return this.option4;}
	
	public static String getTypeString(int type){
		if(type == GameData.fuel) return "Fuel";
		else if(type == GameData.food) return "Food";
		else if(type == GameData.water) return "Water";
		else if(type == GameData.parts) return "Spare Parts";
		else return "ERROR";
	}
	public int getPenaltyType() {
		return penaltyType;
	}
	public void setPenaltyType(int penaltyType) {
		this.penaltyType = penaltyType;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public boolean isPenalty() {
		return Penalty;
	}
	public void setPenalty(boolean penalty) {
		Penalty = penalty;
	}
	public double getChance() {
		return chance;
	}
	public void setChance(double chance) {
		this.chance = chance;
	}
	public int getSkillType() {
		return skillType;
	}
	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}
	public String getGameOver() {
		return gameOver;
	}
	public void setGameOver(String gameOver) {
		this.gameOver = gameOver;
	}
	public boolean isInjury() {
		return Injury;
	}
	public void setInjury(boolean injury) {
		Injury = injury;
	}
	public boolean isDamage() {
		return Damage;
	}
	public void setDamage(boolean damage) {
		Damage = damage;
	}
	public boolean isOverCondition() {
		return OverCondition;
	}
	public void setOverCondition(boolean overCondition) {
		OverCondition = overCondition;
	}
}
