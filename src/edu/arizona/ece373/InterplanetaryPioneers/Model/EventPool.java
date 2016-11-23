package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.ArrayList;
import gameExecution.GameData;
import java.util.Random;

public class EventPool {
	private static Random rand;
	private static ArrayList<Event> events;
	
	public static void initEventPool(){
		events = new ArrayList<Event>();
        Event newEvent = null;
        /*
         *	Event #1 - Power Malfunction
         */
		newEvent = new Event(Event.Low, true, GameData.parts, 25, 0.50, Person.engineer, true, false);
		//Set event text
		newEvent.setDescription("The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.getChance()*100 +"%] Attempt to resolve power outtage youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.cost - 15) + " "+ Event.getTypeString(newEvent.penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
		newEvent.setOption3("[5 - 25 "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
		newEvent.setOption4("The severity of the malfunction is low. You decide to ignore the problem for now.");
		
        EventPool.events.add(newEvent);
        
		/*
		 *	Event #2 - Fire
		 */
		Event event2 = new Event(Event.Moderate, true, GameData.water, 15, 0.35, Person.scientist, true, false);
		event2.description = ("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		event2.option1 = "[Success chance "+ event2.getChance()*100 +"%] Attempt to resolve fire youself.";
		event2.option2 = "["+ String.valueOf(event2.cost - 15) + " "+ Event.getTypeString(event2.getPenaltyType()) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.";
		event2.option3 = "[0 - 15 "+ Event.getTypeString(event2.getPenaltyType()) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.";
		event2.option4 = "You hope nothing will go wrong and ignore the fire.";

		newEvent = new Event(Event.Moderate, true, GameData.water, 15, 0.35, Person.scientist, true, false);
		newEvent.setTitle("FIRE!");
		newEvent.setDescription("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.getChance()*100 +"%] Attempt to resolve fire youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.cost - 15) + " "+ Event.getTypeString(newEvent.penaltyType) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.");
		newEvent.setOption3("[0 - 15 "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You hope nothing will go wrong and ignore the fire.");
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #3 - 
         */
		newEvent = new Event(Event.Moderate, true, GameData.water, 15, 0.35, Person.engineer, true, false);
		newEvent.setDescription("");
	}
    
    public static Event getRandomEvent(){
    	return EventPool.events.get(rand.nextInt((EventPool.events.size() - 1)));
    }
    
    public static Event getEvent(int index){
    	return EventPool.events.get(index);
    }
}
