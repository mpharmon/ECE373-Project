package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gameExecution.GameData;

public class Event {
	protected String  	title;
	protected int 	  	severity;
	protected boolean 	Penalty;
	protected int 	  	penaltyType;
	protected int	  	cost;
	protected double  	chance;
	protected int 	  	skillType;
	protected String  	description;
	protected String  	option1;
	protected String  	option2;
	protected String  	option3;
	protected String  	option4;
	protected String  	gameOver;
	protected String  	iconLocation;
	protected Color	  	titleColor;
	protected String  	eventText;
	protected Rectangle iconBounds;
	protected boolean Injury;		 //Crew Injury flag
	protected boolean Damage;        //Ship Damage flag
	protected boolean OverCondition; //Game over flag

	//Event severity definitions
	public final static int Low = 1;
	public final static int Moderate = 2;
	//public final static int High = 3;
	public final static int Critical = 3;

	// Constructor(s)
	public Event() {
		title = "Event Ecounter";
		severity = Low;
		Penalty = false;
		setPenaltyType(GameData.parts);
		cost = 0;
		chance = 0.50;
		skillType = Person.none;
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOver = "All critical events must have a game over description";
		this.titleColor = new Color(0,255,255);
	}
	//Custom Constructor
	public Event(int severity, boolean penalty, int penaltyType, int cost, double chance, int skillType, boolean injury, boolean damage) {
		title = "Event Ecounter";
		this.severity = severity;
		this.Penalty = penalty;
		this.setPenaltyType(penaltyType);
		this.cost = cost;
		this.chance = chance;
		this.Injury = injury;
		this.skillType = skillType;
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOver = "All critical events must have a game over description";
		if(severity == Critical) OverCondition = true;
		else  OverCondition = false;
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
<<<<<<< Updated upstream
	public int getPenaltyType() {
		return penaltyType;
	}
	public void setPenaltyType(int penaltyType) {
		this.penaltyType = penaltyType;
	}
	
=======
>>>>>>> Stashed changes
}
