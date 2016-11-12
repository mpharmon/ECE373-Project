package gameExecution;

public class GameData {
	
	private int difficulty;
	private int destination;
	
	private double Days;
	private double Weeks;
	private double Years;
	
	private int Fuel;
	private int Food;
	private int Water;
	private int Parts;
	
	private double voyageDistance;
	private double currentDistance;
	
	
	public GameData() {
		setDifficulty(1);
		setDestination(1);
		setDays(0);
		setWeeks(0);
		setYears(0);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
	public GameData(int diff,int dest, double days, double weeks, double years) {
		setDifficulty(diff);
		setDestination(dest);
		setDays(days);
		setWeeks(weeks);
		setYears(years);
		Fuel = 0;
		Food = 0;
		Water = 0;
		Parts = 0;
		voyageDistance = 0;
		currentDistance = 0;
	}
	
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
		this.destination = destination;
	}

	public double getDays() {
		return Days;
	}

	public void setDays(double days) {
		Days = days;
	}

	public double getWeeks() {
		return Weeks;
	}

	public void setWeeks(double weeks) {
		Weeks = weeks;
	}

	public double getYears() {
		return Years;
	}

	public void setYears(double years) {
		Years = years;
	}

	public int getFuel() {
		return Fuel;
	}

	public void setFuel(int fuel) {
		Fuel = fuel;
	}

	public int getFood() {
		return Food;
	}

	public void setFood(int food) {
		Food = food;
	}

	public int getWater() {
		return Water;
	}

	public void setWater(int water) {
		Water = water;
	}

	public int getParts() {
		return Parts;
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

}
