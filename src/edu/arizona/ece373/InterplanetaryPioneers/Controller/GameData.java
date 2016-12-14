package edu.arizona.ece373.InterplanetaryPioneers.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import edu.arizona.ece373.InterplanetaryPioneers.Model.*;



public class GameData{
	
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
	
	public static Score UserScore;
	
	static GameTimer gameTimer;
	
	public static void initialize(){
		gameTimer = new GameTimer(1000);
		crew = new ArrayList<Person>();
		GameData.spacecraft = new Spaceship("SpaceX Shuttle");
		
		GameData.difficulty = 1;
		GameData.days = 0.0;
		GameData.years = 0.0;
		fuel = 0.0;
		food = 0.0;
		water = 0.0;
		parts = 0.0;
		voyageDistance = 0.0;
		currentDistance = 0.0;
		totalEvents = 0;
		resolvedEvents = 0;
		UserScore = new Score();
	}
	
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
						if(Resolution == Event.Option2 || Resolution == Event.Option3)
							updateResource(event.getPenaltyType(), -cost);
					}else{
						updateResource(event.getPenaltyType(), event.getReward());
					}
				}
			}
			gameTimer.setUpdate(false);
		}
	}
	
	public static boolean updateCrewInjury(Event event){
		int crewInjured = event.randomCrewInjury(liveCrew());
		if(crewInjured != -1){
			if(crew.get(crewInjured).updateHealth(1)){
				System.out.println("injured id: " + event.getCrewInjuried());
				return true;
			}
		}
		return false;
	}
	public static boolean updateShipDamage(){
		if(spacecraft.hullDamaged(1)) return true;
		else return false;
	}
	public static boolean updateShipDamage(int damage){
		if(spacecraft.hullDamaged(damage)) return true;
		else return false;
	}
	//Checks if current live crew complement has specified skill
	public static boolean checkCrewForSkill(int skill){
		System.out.println("Looking for skill: " + skill);
		for(int i = 0; i < crew.size(); i++){
			System.out.println("Crew member "+i+": " + " skill "+ crew.get(i).getSkill());
			if(skill == crew.get(i).getSkill() && crew.get(i).Alive()) return true;
		}
		return false;
	}
	
	public static int LiveSkillCount(int skill){
		int alive = 0;
		for(int i = 0; i < crew.size(); i++){
			if(skill == crew.get(i).getSkill() && crew.get(i).Alive()) alive++;
		}
		return alive;
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
	
	public static int InjureAllCrew(int damage){
		int dead = 0;
		for(int i = 0; i < crew.size(); i++){
			//Injure all live crew
			if(crew.get(i).Alive()){
				if(!crew.get(i).updateHealth(damage)) //if injury resulted in death
					dead++;
			}
		}
		return dead; //return all crew killed
	}
	
	public static void setResources(Integer fuel, Integer food, Integer water, Integer parts){
		GameData.fuel = fuel.doubleValue();
		GameData.food = food.doubleValue();
		GameData.water = water.doubleValue();
		GameData.parts = parts.doubleValue();
	}
	
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

	public void setDestinationId(int dID) {
		if(destinationId == 1)
			GameData.destFactor = 1.0;
		else
			GameData.destFactor = 3.2;
		GameData.destinationId = dID;
	}

}
