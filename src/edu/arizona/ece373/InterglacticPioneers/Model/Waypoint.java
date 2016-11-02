package edu.arizona.ece373.InterglacticPioneers.Model;

public class Waypoint {
	private Integer distanceFromStart;
	private Boolean hasStore;
	private Store store;
	
	// Constructors
	public Waypoint(){
		this.distanceFromStart = 0;
		this.hasStore = false;
	}
	public Waypoint(Integer distance){
		this.distanceFromStart = distance;
		this.hasStore = false;
	}
	public Waypoint(Boolean hasStore){
		this.distanceFromStart = 0;
		this.hasStore = hasStore;
		if(this.hasStore)this.store = new Store((this.distanceFromStart / 1.0) / (Journey.getTotalDistance() / 1.0));
	}
	public Waypoint(Integer distance, Boolean hasStore){
		this.distanceFromStart = distance;
		this.hasStore = hasStore;
		if(this.hasStore)this.store = new Store((this.distanceFromStart / 1.0) / (Journey.getTotalDistance() / 1.0));
	};
	
	//Get'ers and Set'ers
	public Integer getDistanceFromStart(){return this.distanceFromStart;};
	public Boolean getHasStore(){return this.hasStore;};
	public Store getStore(){return this.store;};
	
}
