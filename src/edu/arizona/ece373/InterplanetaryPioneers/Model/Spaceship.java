package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Spaceship {
	private String name;
	private int id;
	private int hull;				//Hit-points of ship
	private int maxVelocity;
	private int maxHP;
	private int crewCapacity;
	
	//Hull definitions
	public static final int destroyed = 0; 
	public static final int critical = 1;
	public static final int damaged = 2;
	public static final int nominal = 3;
	
	public static final int ORION_CAPSULE = 1;
	public static final int SPACEX_SHUTTLE = 2;

	// Constructor(s)
	public Spaceship(String name) {
		this.name = name;
		this.setHull(3);
		maxVelocity = 50000; //KPH
		setMaxHP(3);
	}
	
	public Spaceship(int select){
		if(select == 1){
			setId(1);
			this.name = "Orion Spacecraft";
			this.setHull(3);
			maxVelocity = 55000; //KPH
			setMaxHP(3);
			crewCapacity = 4;
		}else{
			setId(2);
			this.name = "SpaceX Shuttle";
			this.setHull(4);
			maxVelocity = 50000; //KPH
			setMaxHP(4);
			crewCapacity = 5;
		}
	}

	// Get'ers and Set'ers
	public String getName() {
		return this.name;
	}

	public int getHull() {
		return hull;
	}
	
	public String getHullStatus(){
		
		if(hull >= nominal)
			return "Nominal";
		else if(hull == damaged)
			return "Damaged";
		else if(hull == critical)
			return "Critical";
		else if(hull == destroyed)
			return "Destroyed";

		return null;
	}

	public void setHull(int hull) {
		this.hull = hull;
	}
	
	public boolean repairHull(){
		if(hull < maxHP){
			hull = hull + 1;
			return true;
		}
		return false;
	}

	public int getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(int maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	
	public boolean hullDamaged(int damage){
		
		if(hull > damage) {
			hull = hull - damage;
			return true;
		}
		else{
			hull = 0;
		}
		
		return false;
	}

	public int getCrewCapacity() {
		return crewCapacity;
	}

	public void setCrewCapacity(int crewCapacity) {
		this.crewCapacity = crewCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static String getShipName(int id){
		if(id == ORION_CAPSULE)
			return "Orion";
		else
			return "SpaceX";
	}

}
