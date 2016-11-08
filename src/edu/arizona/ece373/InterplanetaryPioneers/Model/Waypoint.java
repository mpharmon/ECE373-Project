package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.ArrayList;

public class Waypoint extends Event {
	private Boolean hasStore;
	private Store store;

	// Constructors
	public Waypoint(String t, String d) {
		super(t, d);
		this.title = t;
		this.description = d;
		this.hasStore = false;
		this.buildOptions();
	}

	public Waypoint(String t, String d, Boolean hasStore) {
		super(t, d);
		this.distanceFromStart = 0;
		this.hasStore = hasStore;
		if (this.hasStore)
			this.store = new Store((this.distanceFromStart / 1.0) / (Journey.getTotalDistance() / 1.0));
		this.buildOptions();
	}

	private void buildOptions() {
		if (this.hasStore)
			this.options.add(new EventOption("Visit Store"));
		this.options.add(new EventOption("Rest"));
		this.options.add(new EventOption("Talk to Locals"));
		this.options.add(new EventOption("Continue"));
	}

	// Get'ers and Set'ers
	public Integer getDistanceFromStart() {
		return this.distanceFromStart;
	}

	public Boolean getHasStore() {
		return this.hasStore;
	}

	public Store getStore() {
		return this.store;
	}

	public ArrayList<EventOption> getEventOptions() {
		return this.options;
	}
}
