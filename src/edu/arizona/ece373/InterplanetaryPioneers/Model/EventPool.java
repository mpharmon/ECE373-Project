package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.awt.Color;
import java.util.ArrayList;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
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
		newEvent = new Event(Event.Low, true, GameData.parts, 25, 0.25, Person.engineer, false, true);
		//Set event text
		newEvent.setDescription("The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to resolve power outtage youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
		newEvent.setOption3("[0 -" +newEvent.getCost() +" "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
		newEvent.setOption4("The severity of the malfunction is low. You decide to ignore the problem for now.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/powerLoss.png";
		newEvent.setIconBounds(466, 95, 300, 300); 
        
		EventPool.events.add(newEvent);
        
		/*
		 *	Event #2 - Fire
		 */
		newEvent = new Event(Event.Moderate, true, GameData.water, 20, 0.35, Person.scientist, true, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to resolve fire youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You hope nothing will go wrong and ignore the fire.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/fire.png";
		newEvent.setIconBounds(440, 75, 453, 350); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #3 - Infectious Agent 1
         */
    	newEvent = new Event(Event.Moderate, true, GameData.water, 20, 0.35, Person.doctor, true, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There appears to be an infectious agent on board. The infectious agent must be contained before it infects someone. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to eliminate the infectious agent youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Doctor to eradicate the agent. The infectious agent will be contained at minimal cost.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You pretend like everything is perfectly fine and hope no one gets infected.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/infectiousAgent1.jpg";
		newEvent.setIconBounds(440, 75, 434, 300); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #4 - Black Hole
         */
    	newEvent = new Event(Event.Critical, true, GameData.fuel, 20, 0.20, Person.pilot, false, true);
		newEvent.titleColor = Color.RED;
		newEvent.setDescription("A rogue black hole will pass dangerously close to our path. A course correction is required in order to avoid it's"
								+ "sphere of influence. Either assign a member of the crew to perform the course correction or perform it yourself."
								+ " The \ndecision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to navigate around the black hole yourself. Who needs a pilot right?");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Pilot to perform the course correction. The pilot will perform the optimal maneuver.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the course correction. Potentially more or less efficient fuel use.");
		newEvent.setOption4("You pretend like everything is perfectly fine and claim black holes are a myth.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/blackHole.jpg";
		newEvent.setIconBounds(340, 45, 630, 325); 
		
        EventPool.events.add(newEvent);
	}
    
    public static Event getRandomEvent(){
    	return EventPool.events.get(rand.nextInt((EventPool.events.size())));
    }
    
    public static Event getEvent(int index){
    	return EventPool.events.get(index);
    }
}
