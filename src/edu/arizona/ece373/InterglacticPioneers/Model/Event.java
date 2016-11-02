package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;

public class Event {
	private String title;
	private String description;
	private ArrayList<EventOption> options;
	
	// Constructor(s)
	public Event(){
		
	}
	
	// Get'ers and Set'ers
	public String getTitle(){return this.title;}
	public String getdescription(){return this.description;}
	public ArrayList<EventOption> getEventOptions(){return this.options;}
	
	class EventOption{
		private String description;
		
		//Get'ers and Set'ers
		public String getDescription(){return this.description;}
	}
}
