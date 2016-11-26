package gameModel;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import gameExecution.GameData;

public class Event {
	private String  	title;
	private int 	  	severity;
	private boolean 	Penalty;
	protected int 	  	penaltyType;
	private int	  		cost;
	protected double  	chance;
	private int 	  	skillType;
	protected String  	description;
	private String  	option1;
	private String  	option2;
	private String  	option3;
	private String  	option4;
	protected String  	gameOverInfo;
	protected String  	iconLocation;
	protected Color	  	titleColor;
	protected String  	eventText;
	protected Rectangle iconBounds;
	private boolean Injury;		 //Crew Injury flag
	private int crewInjuried;    //Injured crew ID
	private boolean Damage;        //Ship Damage flag
	public boolean GAMEOVER; //Game over flag
	private boolean Outcome; //update upon event resolution

	//Event severity definitions
	public final static int Low = 1;
	public final static int Moderate = 2;
	public final static int Critical = 3;
	
	public final static int Option1 = 1;
	public final static int Option2 = 2;
	public final static int Option3 = 3;
	public final static int Option4 = 4;
	
	public final static boolean RESOLVED = true;
	public final static boolean FAILED = false;
	
	// Constructor(s)
	public Event() {
		title = "Event Ecounter";
		setSeverity(Low);
		setPenalty(false);
		setPenaltyType(GameData.parts);
		setCost(0);
		chance = 0.50;
		setSkillType(Person.none);
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOverInfo = "All critical events must have a game over description";
		this.titleColor = new Color(0,255,255);
	}
	//Custom Constructor
	public Event(int severity, boolean penalty, int penaltyType, int cost, double chance, int skillType, boolean injury, boolean damage) {
		title = "Event Encounter";
		this.setSeverity(severity);
		this.setPenalty(penalty);
		this.setPenaltyType(penaltyType);
		this.setCost(cost);
		this.chance = chance;
		this.Injury = injury;
		this.Damage = damage;
		this.setSkillType(skillType);
		titleColor = new Color(0, 255, 255); //default color
		description = "Event info goes here...";
		option1 = "Resolve yourself";
		option2 = "Assign crew member with appropiate skill...";
		option3 = "Assign vip to resolve issue...";
		option4 = "Ignore problem...";
		gameOverInfo = "All critical events must have a game over description";
		if(severity == Critical) GAMEOVER = true;
		else  GAMEOVER = false;
		Outcome = false;
	}
	
	public int randomCrewInjury(int numAlive){
		Random rand = new Random();
		setCrewInjuried(rand.nextInt(numAlive-1));
		return crewInjuried;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isPenalty() {
		return Penalty;
	}
	public void setPenalty(boolean penalty) {
		Penalty = penalty;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public boolean isOutcome() {
		return Outcome;
	}
	public void setOutcome(boolean outcome) {
		Outcome = outcome;
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
	public int getCrewInjuried() {
		return crewInjuried;
	}
	public void setCrewInjuried(int crewInjuried) {
		this.crewInjuried = crewInjuried;
	}
	public int getSkillType() {
		return skillType;
	}
	public void setSkillType(int skillType) {
		this.skillType = skillType;
	}
	
}
