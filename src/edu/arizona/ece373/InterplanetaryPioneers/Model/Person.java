package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Person {
	private Integer skills;
	private String name;
	private Integer lifeForce;

	// Constructor
	public Person(String name) {
		this.name = new String(name);
		this.skills = new Integer(0);
	}

	public Person(String name, Integer skills) {
		this.name = new String(name);
		this.skills = new Integer(skills);
	}

	// Get'ers and Set'ers
	public String getName() {
		return this.name;
	}

	public Integer getLifeForce() {
		return this.lifeForce;
	}

	//
	public void isVIP(Boolean b) {
		if (b) {
			this.skills |= 1;
		} else {
			this.skills &= ~1;
		}
	}

	public Boolean isVIP() {
		return ((this.skills & 1) > 0) ? true : false;
	}

	public void isPilot(Boolean b) {
		if (b) {
			this.skills |= 2;
		} else {
			this.skills &= ~2;
		}
	}

	public Boolean isPilot() {
		return ((this.skills & 2) > 0) ? true : false;
	}

	public void isCaptain(Boolean b) {
		if (b) {
			this.skills |= 4;
		} else {
			this.skills &= ~4;
		}
	}

	public Boolean isCaptain() {
		return ((this.skills & 4) > 0) ? true : false;
	}

	public void isBotanist(Boolean b) {
		if (b) {
			this.skills |= 8;
		} else {
			this.skills &= ~8;
		}
	}

	public Boolean isBotanist() {
		return ((this.skills & 8) > 0) ? true : false;
	}

	public void isDoctor(Boolean b) {
		if (b) {
			this.skills |= 16;
		} else {
			this.skills &= ~16;
		}
	}

	public Boolean isDoctor() {
		return ((this.skills & 16) > 0) ? true : false;
	}

	public void isEngineer(Boolean b) {
		if (b) {
			this.skills |= 32;
		} else {
			this.skills &= ~32;
		}
	}

	public Boolean isEngineer() {
		return ((this.skills & 32) > 0) ? true : false;
	}

	public void isScientist(Boolean b) {
		if (b) {
			this.skills |= 64;
		} else {
			this.skills &= 64;
		}
	}

	public Boolean isScientist() {
		return ((this.skills & 64) > 0) ? true : false;
	}

	public Boolean repairPerson(Person p) {
		if (!this.isDoctor())
			return false;
		return p.repair(this);
	}

	public Boolean repair(Person p) {
		if (!p.isDoctor())
			return false;
		this.lifeForce += 10;
		return true;
	}

	public Boolean repairSpaceship(Person p) {
		if (!p.isEngineer())
			return false;
		return Journey.getSpaceship().repair(this);
	}
}
