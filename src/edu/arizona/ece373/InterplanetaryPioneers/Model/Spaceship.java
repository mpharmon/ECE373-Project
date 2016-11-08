package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Spaceship {
	private String name;
	private Integer lifeForce;

	// Constructor(s)
	public Spaceship(String name) {
		this.name = name;
		this.lifeForce = new Integer(100);
	}

	// Get'ers and Set'ers
	public String getName() {
		return this.name;
	}

	public Integer getLifeForce() {
		return this.lifeForce;
	}

	public Boolean repair(Person p) {
		if (!p.isEngineer())
			return false;
		this.lifeForce += 10;
		return true;
	}
}
