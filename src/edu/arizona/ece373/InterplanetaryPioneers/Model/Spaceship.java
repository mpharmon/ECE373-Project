package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Spaceship {
	private String name;
	private int hull;

	// Constructor(s)
	public Spaceship(String name) {
		this.name = name;
		this.setHull(3);
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

}
