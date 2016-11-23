package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.ArrayList;

import gameExecution.GameData;

public class Event {
	
	protected String  title;
	protected int 	  severity;
	protected boolean Penalty;
	protected int 	  penaltyType;
	protected int	  cost;
	protected double  chance;
	protected int 	  skillType;
	protected String  description;
	protected String  option1;
	protected String  option2;
	protected String  option3;
	protected String  option4;
	protected String  gameOver;
	//Event severity definitions
	public final static int Low = 1;
	public final static int Moderate = 2;
	public final static int High = 3;
	public final static int Critical = 4;

	// Constructor(s)
	public Event() {
		title = "Event Ecounter";
		severity = Low;
		Penalty = false;
		penaltyType = GameData.parts;
		cost = 0;
		chance = 0.50;
		skillType = Person.none;
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOver = "All critical events must have a game over description";
	}
	//Custom Constructor
	public Event(int severity, boolean penalty, int penaltyType, int cost, double chance, int skillType) {
		title = "Event Ecounter";
		this.severity = severity;
		this.Penalty = penalty;
		this.penaltyType = penaltyType;
		this.cost = cost;
		this.chance = chance;
		this.skillType = skillType;
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOver = "All critical events must have a game over description";
	}

	// Get'ers and Set'ers
	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}
	
	public static String getTypeString(int type){
		
		if(type == GameData.fuel) return "Fuel";
		else if(type == GameData.food) return "Food";
		else if(type == GameData.water) return "water";
		else if(type == GameData.parts) return "Spare parts";
		
		return null;
	}
	
}
