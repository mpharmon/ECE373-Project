package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.awt.Color;
import java.util.ArrayList;
import gameExecution.GameData;
import java.util.Random;

public class EventPool {
	private static Random rand;
	private static ArrayList<Event> events;
	
	public static void initEventPool(){
		rand = new Random();
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
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to resolve power outtage youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
		newEvent.setOption3("[5 - 25 "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
		newEvent.setOption4("The severity of the malfunction is low. You decide to ignore the problem for now.");
		//Set Icon location
		newEvent.iconLocation = "/images/powerLoss.png";
		newEvent.setIconBounds(466, 95, 300, 300); 
        
		EventPool.events.add(newEvent);
        
		/*
		 *	Event #2 - Fire
		 */
		newEvent = new Event(Event.Moderate, true, GameData.water, 15, 0.35, Person.scientist, true, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to resolve fire youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.");
		newEvent.setOption3("[0 - 15 "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You hope nothing will go wrong and ignore the fire.");
		//Set Icon location
		newEvent.iconLocation = "/images/fire.png";
		newEvent.setIconBounds(440, 75, 453, 350); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #3 - 
         */
	}
    
    public static Event getRandomEvent(){
    	return EventPool.events.get(rand.nextInt((EventPool.events.size() - 1)));
    }
    
    public static Event getEvent(int index){
    	return EventPool.events.get(index);
    }
}
