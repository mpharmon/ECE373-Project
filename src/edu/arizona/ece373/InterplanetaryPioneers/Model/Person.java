package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Person {
	
	private String name;
	private int skill;
	private int health;
	
	//Health definitions
	public static final int dead = 0; 
	public static final int critical = 1;
	public static final int injured = 2;
	public static final int nominal = 3;
	//Skill definitions
	public static final int none  = 	0; 
	public static final int pilot = 	1; 
	public static final int engineer =  2;
	public static final int scientist=  3;
	public static final int botanist =  4; 
	public static final int doctor = 	5;
	
	//VIP ID definitions
	public static final int Trump =  1; 
	public static final int Elon =  2; 
	public static final int Oprah =  3; 
	
	public Person(){
		name = "Unknown";
		skill = pilot;
		health = nominal;
	}
	
	public Person(String name, int skill, int health){
		this.name = name;
		this.skill = skill;
		this.health = health;
	}
	
	public String getSkill(boolean s){
		if(s){
				 if(getSkill() == pilot) 	 return "Pilot";
			else if(getSkill() == engineer)  return "Engineer";
			else if(getSkill() == scientist) return "Scientist";
			else if(getSkill() == doctor) 	 return "Doctor";
			else if(getSkill() == botanist)  return "Botanist";
		}
		
		return null;
	}
	
	public boolean updateHealth(int damage){
		
		if(health > damage){
			health = health - damage;
			return true; 	//still alive
		}else if(health > 0 && damage >= 1){
			health = health - 1;
			return false;
		}else{
			return false; 	//dead
		}
		
	}
	/**
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public int getHealthStatus() {
		return health;
	}
	public void setHealthStatus(int healthStatus) {
		health = healthStatus;
	}
	public boolean Alive(){
		if(health > 0) return true;
		else return false;
	}
	
}
