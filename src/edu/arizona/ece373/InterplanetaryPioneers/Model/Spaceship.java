package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Spaceship {
	private String name;
	private int hull;				//Hit-points of ship
	private int maxVelocity;
	private int maxHP;

	// Constructor(s)
	public Spaceship(String name) {
		this.name = name;
		this.setHull(3);
		maxVelocity = 50000; //KPH
		setMaxHP(3);
	}

	// Get'ers and Set'ers
	public String getName() {
		return this.name;
	}

	public int getHull() {
		return hull;
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

}
