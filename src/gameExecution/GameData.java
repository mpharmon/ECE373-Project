package gameExecution;

import java.util.ArrayList;
import edu.arizona.ece373.InterplanetaryPioneers.Model.*;

public class GameData {
	
	private int difficulty;
	private int destination;
	
	private double Days;
	private double Years;
						 
	private double Fuel;  private static final double FUEL_RATE = 0.00095;  //25 units consumed after 10 minutes @warp
	private double Food;  private static final double FOOD_RATE = 0.002;   //50 units consumed after 10 minutes	@warp
	private double Water; private static final double WATER_RATE = 0.002;  //50 units consumed after 10 minutes @warp
	private double Parts; //private static final double PARTS_RATE = 0.001;
	
	private double voyageDistance;
	private double currentDistance; //KM
	private static final int shipVelocity = 50000; // KPH
	private static final double MarsDistance = 500000000; // 500 MKM
	
	public final static int fuel = 1;
	public final static int food = 2;
	public final static int water = 3;
	public final static int parts = 4;
	public static final double EventStartDist = 25000000;
	
	protected ArrayList<Person> Crew;
	protected Spaceship spacecraft;
	
	protected int shipStatus;
	
	GameTimer gameTimer;
	
	
	public GameData() {
		gameTimer = new GameTimer(1000);
		Crew = new ArrayList<Person>();
		spacecraft = new Spaceship("SpaceX Shuttle");
		
		setDifficulty(1);
		setDestination(1);
		setDays(0);
		setYears(0);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
	public GameData(int diff,int dest, double days, double years) {
		gameTimer = new GameTimer(1000);
		Crew = new ArrayList<Person>();
		setDifficulty(diff);
		setDestination(dest);
		setDays(days);
		setYears(years);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
	public void dataUpdate(boolean Warp, boolean Event, boolean Resolution, boolean resultReady, int resourceType, int cost){
		if(gameTimer.isUpdate() && !Event && !Resolution){
			if(Warp){
				Fuel = Fuel - 5*FUEL_RATE;
				Food = Food - 5*FOOD_RATE;
				Water = Water - 5*WATER_RATE;
				currentDistance = (currentDistance + 7.2*shipVelocity);
			}else{
				Fuel = Fuel - FUEL_RATE;
				Food = Food - FOOD_RATE;
				Water = Water - WATER_RATE;
				currentDistance = (currentDistance + shipVelocity);
			}
			if(resultReady){
				updateResource(resourceType, cost);
			}
			gameTimer.setUpdate(false);
		}
	}
	//Checks if current crew complement has specified skill
	public boolean checkCrewForSkill(int skill){
		
		for(int i = 0; i < Crew.size(); i++){
			if(skill == Crew.get(i).getSkill()) return true;
		}
		return false;
	}
	
	//Checks for dead crew members
	public int deadCrew(){
		int dead = 0;
		for(int i = 0; i < Crew.size(); i++){
			if( 0 <= Crew.get(i).getHealthStatus()) dead++;
		}
		return dead;
	}
	//Checks for alive crew members
	public int liveCrew(){
		return 5 -deadCrew();
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
		return destination;
	}

	public void setDestination(int destination) {
		if(destination == 1) voyageDistance = MarsDistance;
		this.destination = destination;
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
}
