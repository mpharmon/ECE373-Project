package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Journey {
	private static Integer totalDistance;
	private static ArrayList<Event> events;
	private static Spaceship ship;
	private static Integer difficulty;
	private static ArrayList<Person> people;
	
	//Get'ers and Set'ers
	public static Integer getTotalDistance(){return Journey.totalDistance;};
	//public static ArrayList<Event> getWaypoints(){return Journey.waypoints;};
	public static Spaceship getSpaceship(){return Journey.ship;}
	public static Integer getDifficulty(){return Journey.difficulty;}
	
	public static void buildEvents(){
		//TODO - Add Additional Events
	}
	
	public static Boolean addPerson(String Name){
		Journey.people.add(new Person(Name));
		return true;
	}
	
	public static Boolean addPerson(String name, Integer skills){
		// Check to make sure there is only 1 VIP and 1 Captain
		if((skills | 5) > 0){
			Iterator<Person> peopleIterator = Journey.people.iterator();
			while(peopleIterator.hasNext()){
				Person currentPerson = peopleIterator.next();
				if(currentPerson.isCaptain() || currentPerson.isVIP())return false;
			}
		}
		Journey.people.add(new Person(name, skills));
		return true;
	}
}
