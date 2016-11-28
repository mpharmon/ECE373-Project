package edu.arizona.ece373.InterplanetaryPioneers.Controller;

import java.util.ArrayList;

import edu.arizona.ece373.InterplanetaryPioneers.Model.*;

public class GameData {
	
	public static int difficulty;
	
	public static Double days; final public static double HOUR_CONST = 0.04167; // 1/24 Days
	public static Double years;
						 
	public static Double fuel;  final public static double FUEL_RATE = 0.0026;  //25 units consumed after 10 minutes @warp
	public static Double food;  final public static double FOOD_RATE = 0.0052;   //50 units consumed after 10 minutes @warp
	public static Double water; final public static double WATER_RATE = 0.0052;  //50 units consumed after 10 minutes @warp
	public static Double parts; //private static final double PARTS_RATE = 0.001;
	
	public static Integer destinationId;
	public static Double voyageDistance;
	public static Double currentDistance; //KM
	public static Integer shipVelocity = 50000; // KPH
	
	public static Double destFactor = 1.0; //Destination scalar factor 1 - 1.5
	public static Double warpFactor = 8.333; //Warp scalar factor			
	
	public final static int FUEL = 1;
	public final static int FOOD = 2;
	public final static int WATER = 3;
	public final static int PARTS = 4;
	public static final double EventStartDist = 10000000; //10 MKM
	
	public static ArrayList<Person> crew;
	public static Spaceship spacecraft;
	public static int vipID;
	protected int shipStatus;
	public static int totalEvents;
	public static int resolvedEvents;
	
	static GameTimer gameTimer;
	
	public static void initialize(){
		gameTimer = new GameTimer(1000);
		crew = new ArrayList<Person>();
		GameData.spacecraft = new Spaceship("SpaceX Shuttle");
		//setSpacecraft(new Spaceship("SpaceX Shuttle"));
		
		//setDifficulty(1);
		GameData.difficulty = 1;
		//setDays(0);
		GameData.days = 0.0;
		//setYears(0);
		GameData.years = 0.0;
		fuel = 0.0;
		food = 0.0;
		water = 0.0;
		parts = 0.0;
		voyageDistance = 0.0;
		currentDistance = 0.0;
	}
	
	//public GameData() {
	//	gameTimer = new GameTimer(1000);
	//	crew = new ArrayList<Person>();
	//	GameData.spacecraft = new Spaceship("SpaceX Shuttle");
	//	//setSpacecraft(new Spaceship("SpaceX Shuttle"));
	//	
	//	//setDifficulty(1);
	//	GameData.difficulty = 1;
	//	//setDays(0);
	//	GameData.days = 0.0;
	//	//setYears(0);
	//	GameData.years = 0.0;
	//	fuel = 0.0;
	//	food = 0.0;
	//	water = 0.0;
	//	parts = 0.0;
	//	voyageDistance = 0.0;
	//	currentDistance = 0.0;
	//}
	
	//public GameData(int diff, double days, double years) {
	//	gameTimer = new GameTimer(1000);
	//	crew = new ArrayList<Person>();
	//	//setDifficulty(diff);
	//	GameData.difficulty = diff;
	//	//setDays(days);
	//	GameData.days = days;
	//	//setYears(years);
	//	GameData.years = years;
	//	fuel = 0.0;
	//	food = 0.0;
	//	water = 0.0;
	//	parts = 0.0;
	//	voyageDistance = 0.0;
	//	currentDistance = 0.0;
	//}
	
	public static void dataUpdate(boolean Warp, boolean EventActive, boolean ResultActive, boolean resultReady, int Resolution, Event event, int cost){
		if(gameTimer.isUpdate() && !EventActive && !ResultActive){
			if(Warp){
				fuel -= (FUEL_RATE * warpFactor);
				food -= (FOOD_RATE * warpFactor);
				water -= (WATER_RATE * warpFactor);
				days += (HOUR_CONST * warpFactor * destFactor);
				currentDistance += (warpFactor * destFactor * shipVelocity);
			}else{
				fuel -= FUEL_RATE;
				food -= FOOD_RATE;
				water -= WATER_RATE;
				days += HOUR_CONST;
				currentDistance = (currentDistance + shipVelocity);
			}
			if(resultReady){ 							//Data ready to be updated after Result panel
				if(event.isOutcome()){ 					//Event Resolved
					if(event.isPenalty()) {				//Event has penalty
						if(Resolution == Event.Option2 || Resolution == Event.Option3){
							updateResource(event.getPenaltyType(), -cost);
					}else{								//Event has no penalty
						updateResource(event.getPenaltyType(), cost);
					}
				}
				}
			}
			gameTimer.setUpdate(false);
		}
	}
	
	public static boolean updateCrewInjury(Event event){
		if(crew.get(event.randomCrewInjury(liveCrew())).updateHealth(1)){
			System.out.println("injured id: " + event.getCrewInjuried());
			return true;
		}
		else return false;
	}
	public static boolean updateShipDamage(){
		if(spacecraft.hullDamaged(1)) return true;
		else return false;
	}
	
	//Checks if current live crew complement has specified skill
	public static boolean checkCrewForSkill(int skill){
		System.out.println("Looking for skill: " + skill);
		for(int i = 0; i < crew.size(); i++){
			System.out.println("Crew member "+i+": " + crew.get(i).getSkill() + " skill");
			if(skill == crew.get(i).getSkill() && crew.get(i).Alive()) return true;
		}
		return false;
	}
	
	//Checks for dead crew members
	public static Integer deadCrew(){
		int dead = 0;
		for(int i = 0; i < crew.size(); i++){
			if( 0 >= crew.get(i).getHealthStatus()) dead++;
			System.out.println("Crew member "+i+": " + crew.get(i).getHealthStatus() + " Health");
		}
		return dead;
	}
	//Checks for alive crew members
	public static Integer liveCrew(){
		return (spacecraft.getCrewCapacity() - deadCrew());
	}
	
	public static int crewSkillCount(int skill){
		int skillCnt = 0;
		for(int i = 0; i < crew.size(); i++){
			if(crew.get(i).getSkill() == skill) skillCnt++;
		}
		return skillCnt;
	}
	
	/**
	 * Getters and Setters
	 */
	
	//public int getDifficulty() {
	//	return difficulty;
	//}

	//public void setDifficulty(int difficulty) {
	//	this.difficulty = difficulty;
	//}

	//public int getDestination() {
	//	return Destination.getId();
	//}

	//public double getDays() {
	//	return days;
	//}

	//public void setDays(double days) {
	//	Days = days;
	//}

	//public double getYears() {
	//	return years;
	//}

	//public void setYears(double y) {
	//	years = y;
	//}

	//public int getFuel() {
	//	return (int) Math.round(fuel);
	//}

	//public void setFuel(int f) {
	//	fuel = f;
	//}

	public int getFood() {
		return (int) Math.round(food);
	}

	//public void setFood(int f) {
	//	food = f;
	//}

	//public int getWater() {
	//	return (int) Math.round(water);
	//}

	//public void setWater(int w) {
	//	water = w;
	//}

	//public int getParts() {
	//	return (int) Math.round(parts);
	//}

	//public void setParts(int p) {
	//	parts = p;
	//}
	
	public static void setResources(Integer fuel, Integer food, Integer water, Integer parts){
		GameData.fuel = fuel.doubleValue();
		GameData.food = food.doubleValue();
		GameData.water = water.doubleValue();
		GameData.parts = parts.doubleValue();
	}

	//public double getVoyageDistance() {
	//	return voyageDistance;
	//}

	//public void setVoyageDistance(double voyageDistance) {
	//	this.voyageDistance = voyageDistance;
	//}

	//public double getCurrentDistance() {
	//	return currentDistance;
	//}

	//public void setCurrentDistance(double currentDistance) {
	//	this.currentDistance = currentDistance;
	//}

	//public ArrayList<Person> getCrew() {
	//	return crew;
	//}

	//public void setCrew(ArrayList<Person> c) {
	//	crew = c;
	//}
	
	public static void updateResource(int type, int diff){
		if(type == 1){
			fuel += diff;
		}else if(type == 2){
			food += diff;
		}else if(type == 3){
			water += diff;
		}else if(type == 4){
			parts += diff;
		}
	}
	public static int getResource(int type){
		Double temp;
		if(type == 1){
			temp = new Double(fuel);
		}else if(type == 2){
			temp = new Double(food);
		}else if(type == 3){
			temp = new Double(water);
		}else if(type == 4){
			temp = new Double(parts);
		}else{
			return 0;
		}
		return temp.intValue();
	}

	//public Spaceship getSpacecraft() {
	//	return spacecraft;
	//}

	//public void setSpacecraft(Spaceship spacecraft) {
	//	this.spacecraft = spacecraft;
	//}

	//public int getShipVelocity() {
	//	return shipVelocity;
	//}

	//public void setShipVelocity(int shipVelocity) {
	//	this.shipVelocity = shipVelocity;
	//}

	//public int getDestinationId() {
	//	return destinationId;
	//}

	public void setDestinationId(int dID) {
		if(destinationId == 1)
			GameData.destFactor = 1.0;
		else
			GameData.destFactor = 3.2;
		GameData.destinationId = dID;
	}

	//public int getTotalEvents() {
	//	return totalEvents;
	//}

	//public void setTotalEvents(int totalEvents) {
	//	this.totalEvents = totalEvents;
	//}

	//public int getResolvedEvents() {
	//	return resolvedEvents;
	//}

	//public void setResolvedEvents(int resolvedEvents) {
	//	this.resolvedEvents = resolvedEvents;
	//}

	//public int getVipID() {
	//	return vipID;
	//}

	//public void setVipID(int vipID) {
	//	this.vipID = vipID;
	//}
}