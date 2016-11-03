package edu.arizona.ece373.InterglacticPioneers.Model;

public class Waypoint extends Event{
	private Boolean hasStore;
	private Store store;
	
	// Constructors
	public Waypoint(String t, String d){
		super(t,d);
		this.title = t;
		this.description = d;
		this.hasStore = false;
	}
	public Waypoint(String t, String d, Boolean hasStore){
		super(t,d);
		this.distanceFromStart = 0;
		this.hasStore = hasStore;
		if(this.hasStore)this.store = new Store((this.distanceFromStart / 1.0) / (Journey.getTotalDistance() / 1.0));
	}
	
	//Get'ers and Set'ers
	public Integer getDistanceFromStart(){return this.distanceFromStart;}
	public Boolean getHasStore(){return this.hasStore;}
	public Store getStore(){return this.store;}
}
