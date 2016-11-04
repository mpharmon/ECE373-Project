package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;

abstract class Event {
	protected String title;
	protected String description;
	protected ArrayList<EventOption> options;
	protected Integer distanceFromStart;
	
	// Constructor(s)
	public Event(String t, String d){
		this.title = t;
		this.description = d;
		this.options = new ArrayList<EventOption>();
	}
	
	// Get'ers and Set'ers
	public String getTitle(){return this.title;}
	public String getdescription(){return this.description;}
	public ArrayList<EventOption> getEventOptions(){return this.options;}
	
	class EventOption{
		private String description;
		
		// Constructor(s)
		public EventOption(String d){
			this.description = d;
		}
		
		// Get'ers and Set'ers
		public String getDescription(){return this.description;}
	}
}
