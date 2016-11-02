package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Journey {
	private static Integer totalDistance;
	private static ArrayList<Waypoint> waypoints;
	private static ArrayList<Event> events;
	private static ArrayList<Person> people;
	private static Spaceship ship;
	
	//Get'ers and Set'ers
	public static Integer getTotalDistance(){return Journey.totalDistance;};
	public static ArrayList<Waypoint> getWaypoints(){return Journey.waypoints;};
	public static Spaceship getSpaceship(){return Journey.ship;}
	
	public static void buildPath(Waypoint Destination){
		Journey.waypoints.add(new Waypoint("Earth"));
	}
	
	public static void buildEvents(){
		Journey.events.add(new Event());
	}
	
	public static Boolean addPerson(String Name){
		Journey.people.add(new Person(Name));
		return true;
	}
	
	public static Boolean addPerson(String name, Integer skills){
		Iterator<Person> peopleIterator = Journey.people.iterator();
		while(peopleIterator.hasNext()){
			Person currentPerson = peopleIterator.next();
			// Check to make sure there is only 1 VIP and 1 Captain
			if(currentPerson.isCaptain() || currentPerson.isVIP())return false;
		}
		Journey.people.add(new Person(name, skills));
		return true;
	}
}
