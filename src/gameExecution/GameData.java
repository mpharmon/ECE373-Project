package gameExecution;

import java.util.ArrayList;

import gameModel.*;

public class GameData {
	
	private int difficulty;
	
	private double Days; private static final double HOUR_CONST = 0.04167; // 1/24 Days
	private double Years;
						 
	private double Fuel;  private static final double FUEL_RATE = 0.0026;  //25 units consumed after 10 minutes @warp
	private double Food;  private static final double FOOD_RATE = 0.0052;   //50 units consumed after 10 minutes @warp
	private double Water; private static final double WATER_RATE = 0.0052;  //50 units consumed after 10 minutes @warp
	private double Parts; //private static final double PARTS_RATE = 0.001;
	
	private int destinationId;
	private double voyageDistance;
	private double currentDistance; //KM
	private int shipVelocity = 50000; // KPH
	
	private double destFactor = 1; //Destination scalar factor 1 - 1.5
	private double warpFactor = 8.333; //Warp scalar factor			
	
	public final static int fuel = 1;
	public final static int food = 2;
	public final static int water = 3;
	public final static int parts = 4;
	public static final double EventStartDist = 10000000; //10 MKM
	
	protected ArrayList<Person> Crew;
	private Spaceship spacecraft;
	protected int shipStatus;
	private int totalEvents;
	private int resolvedEvents;
	
	GameTimer gameTimer;
	
	public GameData() {
		gameTimer = new GameTimer(1000);
		Crew = new ArrayList<Person>();
		setSpacecraft(new Spaceship("SpaceX Shuttle"));
		
		setDifficulty(1);
		setDays(0);
		setYears(0);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
	public GameData(int diff, double days, double years) {
		gameTimer = new GameTimer(1000);
		Crew = new ArrayList<Person>();
		setDifficulty(diff);
		setDays(days);
		setYears(years);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
	public void dataUpdate(boolean Warp, boolean EventActive, boolean ResultActive, boolean resultReady, int Resolution, Event event, int cost){
		if(gameTimer.isUpdate() && !EventActive && !ResultActive){
			if(Warp){
				Fuel = Fuel - (FUEL_RATE)*(warpFactor);
				Food = Food - (FOOD_RATE)*(warpFactor);
				Water = Water - (WATER_RATE)*(warpFactor);
				Days = Days + HOUR_CONST*(warpFactor)*(destFactor);
				currentDistance = (currentDistance + (warpFactor)*(destFactor)*shipVelocity);
			}else{
				Fuel = Fuel - FUEL_RATE;
				Food = Food - FOOD_RATE;
				Water = Water - WATER_RATE;
				Days = Days + HOUR_CONST;
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
	
	public boolean updateCrewInjury(Event event){
		if(Crew.get(event.randomCrewInjury(liveCrew())).updateHealth(1)){
			System.out.println("injured id: " + event.getCrewInjuried());
			return true;
		}
		else return false;
	}
	public boolean updateShipDamage(){
		if(spacecraft.hullDamaged(1)) return true;
		else return false;
	}
	
	//Checks if current live crew complement has specified skill
	public boolean checkCrewForSkill(int skill){
		System.out.println("Looking for skill: " + skill);
		for(int i = 0; i < Crew.size(); i++){
			System.out.println("Crew member "+i+": " + Crew.get(i).getSkill() + " skill");
			if(skill == Crew.get(i).getSkill() && Crew.get(i).Alive()) return true;
		}
		return false;
	}
	
	//Checks for dead crew members
	public int deadCrew(){
		int dead = 0;
		for(int i = 0; i < Crew.size(); i++){
			if( 0 >= Crew.get(i).getHealthStatus()) dead++;
			System.out.println("Crew member "+i+": " + Crew.get(i).getHealthStatus() + " Health");
		}
		return dead;
	}
	//Checks for alive crew members
	public int liveCrew(){
		return (spacecraft.getCrewCapacity() - deadCrew());
	}
	
	/**
	 * Getters and Setters
	 */
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDestination() {
		return Destination.getId();
	}

	public double getDays() {
		return Days;
	}

	public void setDays(double days) {
		Days = days;
	}

	public double getYears() {
		return Years;
	}

	public void setYears(double years) {
		Years = years;
	}

	public int getFuel() {
		return (int) Math.round(Fuel);
	}

	public void setFuel(int fuel) {
		Fuel = fuel;
	}

	public int getFood() {
		return (int) Math.round(Food);
	}

	public void setFood(int food) {
		Food = food;
	}

	public int getWater() {
		return (int) Math.round(Water);
	}

	public void setWater(int water) {
		Water = water;
	}

	public int getParts() {
		return (int) Math.round(Parts);
	}

	public void setParts(int parts) {
		Parts = parts;
	}
	
	public void setResources(int fuel, int food, int water, int parts){
		this.Fuel = fuel;
		this.Food = food;
		this.Water = water;
		this.Parts = parts;
	}

	public double getVoyageDistance() {
		return voyageDistance;
	}

	public void setVoyageDistance(double voyageDistance) {
		this.voyageDistance = voyageDistance;
	}

	public double getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		this.currentDistance = currentDistance;
	}

	public ArrayList<Person> getCrew() {
		return Crew;
	}

	public void setCrew(ArrayList<Person> crew) {
		Crew = crew;
	}
	public void updateResource(int type, int diff){
		if(type == 1){
			Fuel = Fuel + diff;
		}else if(type == 2){
			Food = Food + diff;
		}else if(type == 3){
			Water = Water + diff;
		}else if(type == 4){
			Parts = Parts + diff;
		}
	}
	public int getResource(int type){
		Double temp;
		if(type == 1){
			temp = new Double(Fuel);
		}else if(type == 2){
			temp = new Double(Food);
		}else if(type == 3){
			temp = new Double(Water);
		}else if(type == 4){
			temp = new Double(Parts);
		}else{
			return 0;
		}
		return temp.intValue();
	}

	public Spaceship getSpacecraft() {
		return spacecraft;
	}

	public void setSpacecraft(Spaceship spacecraft) {
		this.spacecraft = spacecraft;
	}

	public int getShipVelocity() {
		return shipVelocity;
	}

	public void setShipVelocity(int shipVelocity) {
		this.shipVelocity = shipVelocity;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		if(destinationId == 1)
			destFactor = 1;
		else
			destFactor = 3.2;
		this.destinationId = destinationId;
	}

	public int getTotalEvents() {
		return totalEvents;
	}

	public void setTotalEvents(int totalEvents) {
		this.totalEvents = totalEvents;
	}

	public int getResolvedEvents() {
		return resolvedEvents;
	}

	public void setResolvedEvents(int resolvedEvents) {
		this.resolvedEvents = resolvedEvents;
	}
}
