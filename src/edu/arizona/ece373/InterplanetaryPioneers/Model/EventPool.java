package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.ArrayList;
import gameExecution.GameData;

public class EventPool {
	
	private ArrayList<Event> Events;
	
	
	public EventPool(){
		Events = new ArrayList<Event>();
	}
	
	public void initEventPool(){
		/**
		 * Instantiate Event 1
		 */
		Event event1 = new Event(Event.Low, true, GameData.parts, 25, 0.50, Person.engineer);
		//Set event text
		event1.description = "The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.";
		//Set option text
		event1.option1 = "[Success chance "+ event1.chance*100 +"%] Attempt to resolve power outtage youself.";
		event1.option2 = "["+ String.valueOf(event1.cost - 15) + " "+ Event.getTypeString(event1.penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.";
		event1.option3 = "[5 - 25 "+ Event.getTypeString(event1.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.";
		event1.option4 = "The severity of the malfunction is low. You decide to ignore the problem for now.";
		
		/**
		 * Instantiate Event 2
		 */
		Event event2 = new Event(Event.Moderate, true, GameData.water, 15, 0.35, Person.scientist);
		event2.description = ("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		event2.option1 = "[Success chance "+ event2.chance*100 +"%] Attempt to resolve fire youself.";
		event2.option2 = "["+ String.valueOf(event2.cost - 15) + " "+ Event.getTypeString(event2.penaltyType) +"] Assign a Scientist to fix the problem. The fire will be resolved at no cost to resources.";
		event2.option3 = "[0 - 15 "+ Event.getTypeString(event2.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.";
		event2.option4 = "You hope nothing will go wrong and ignore the fire.";
		
		
		/**
		 * Add all created events to ArrayList
		 */
		Events.add(event1);
		Events.add(event2);
		//...
		//...
		//Events.add(eventN);
	}

}
