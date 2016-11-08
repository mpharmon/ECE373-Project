package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.Random;

public class AlienEncounter extends Event implements EncounterData {
	final public static String ENCOUNTER_TITLE = "";
	final public static String ENCOUNTER_DESCRIPTION = "";
	private Boolean isGood, looksGood;

	// Constructor
	public AlienEncounter() {
		super(AlienEncounter.ENCOUNTER_TITLE, AlienEncounter.ENCOUNTER_DESCRIPTION);
		this.isGood = new Random().nextBoolean();
		this.looksGood = new Random().nextBoolean();
		this.buildOptions();
	}

	public AlienEncounter(Boolean isG, Boolean looksG) {
		super(AlienEncounter.ENCOUNTER_TITLE, AlienEncounter.ENCOUNTER_DESCRIPTION);
		this.isGood = isG;
		this.looksGood = looksG;
		this.buildOptions();
	}

	public String getTitle() {
		return AlienEncounter.ENCOUNTER_TITLE;
	}

	public String getDescription() {
		return AlienEncounter.ENCOUNTER_DESCRIPTION;
	}

	private void buildOptions() {
		this.options.add(new EventOption("Run!"));
		this.options.add(new EventOption("Talk"));
	}

}