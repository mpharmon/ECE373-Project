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
		newEvent = new Event(Event.Low, true, GameData.PARTS, 25, 0.25, Person.engineer, false, true, false);
		//Set event text
		newEvent.setDescription("The ship is experiencing minor power malfunctions. Currently the severity is low. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance * 100 +"%] Attempt to resolve power outtage youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.penaltyType) +"] Assign an Engineer to fix the problem. The power outtage will be resolved at a minimal cost to resources.");
		newEvent.setOption3("[0 -" + newEvent.getCost() +" "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more parts.");
		newEvent.setOption4("The severity of the malfunction is low. You decide to ignore the problem for now.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/powerLoss.png";
		newEvent.setIconBounds(500, 95, 300, 300); 
        
		EventPool.events.add(newEvent);
        
		/*
		 *	Event #2 - Fire
		 */
		newEvent = new Event(Event.Moderate, true, GameData.WATER, 20, 0.35, Person.scientist, true, false, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There is a fire in the cargo area. The fire must be put out to avoid ship damage. You can resolve the issue\n "
							+ "yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance * 100 +"%] Attempt to resolve ship fire youself. Your not afraid of no fire.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Scientist to fix the problem. The fire will be resolved at minimal cost to resources.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" "+ Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You hope nothing will go wrong and ignore the fire.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/fire.png";
		newEvent.setIconBounds(440, 75, 453, 350); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #3 - Infectious Agent 1
         */
    	newEvent = new Event(Event.Moderate, true, GameData.WATER, 20, 0.35, Person.doctor, true, false, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There appears to be an infectious agent on board. The infectious agent must be contained before it infects someone.\n "
				                + "You can resolve the issue yourself or assign a crew member to resolve it. The decision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance * 100 +"%] Attempt to eliminate the infectious agent youself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " "+ Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Doctor to eradicate the agent. The infectious agent will be contained at minimal cost.");
		newEvent.setOption3("[0 - "+ newEvent.getCost() + " " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the issue. Theres a chance your VIP will use less or more water.");
		newEvent.setOption4("You pretend like everything is perfectly fine and hope no one gets infected.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/infectiousAgent1.jpg";
		newEvent.setIconBounds(440, 75, 434, 300); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #4 - Black Hole
         */
    	newEvent = new Event(Event.Critical, true, GameData.FUEL, 20, 0.20, Person.pilot, false, true, false);
		newEvent.titleColor = Color.RED;
		newEvent.setDescription("A rogue black hole will pass dangerously close to our path. A course correction is required in order to avoid it's\n "
								+ "sphere of influence. Either assign a member of the crew to perform the course correction or perform it yourself."
								+ " The \ndecision is yours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to navigate around the black hole yourself. Who needs a pilot right?");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Pilot to perform the course correction. The pilot will perform the optimal maneuver.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to resolve the course correction. Potentially more or less efficient fuel use.");
		newEvent.setOption4("You pretend like everything is perfectly fine and claim black holes are a myth.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/blackHole.jpg";
		newEvent.setIconBounds(340, 45, 630, 325); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #5 - Rogue AI
         */
    	newEvent = new Event(Event.Moderate, true, GameData.PARTS, 25, 0.25, Person.engineer, true, false, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("The ships AI has gone rogue. It seems to ignore all commands given and is causing glitches in all the ship's "
								+ "systems. \nLife support is among the systems at risk. Shutdown the AI yourself or assign an engineer to bypass "
								+ "the AI's primary control circuits.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to shut down the rogue AI yourself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign an Engineer to shutdown the AI. The engineer will require parts to perform bypass.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to shutdown the AI somehow. Potentially more or less efficient use of parts.");
		newEvent.setOption4("You threaten the AI and demand it to shut itself down.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/rogueAI.png";
		newEvent.setIconBounds(420, 45, 524, 300); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #6 - Satellite Salvage Opportunity
         */
    	newEvent = new Event(Event.Low, false, GameData.PARTS, 15, 0.25, Person.engineer, false, false, false);
    	newEvent.setTitle("Salvage Opportunity");
		newEvent.titleColor = Color.GREEN;
		newEvent.setDescription("You have encountered an abandoned satellite which appears to have been drifting in space for a long time. You"
								+ " can \nattempt to salavge some parts off the satellite yourself or assign a qualified crew member to do so."
								+ " The decision is \nyours captain.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to salvage parts off the satellite yourself. Who needs an engineer right?");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 5) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign an Engineer to perform the salvage operation and recover some parts.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to perform the salvage operation. Potentially more or less parts recovered.");
		newEvent.setOption4("You decide not to perform the salvage operation. And claim your too civilized to be collecting garbage.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/Voyager_spacecraft.jpg";
		newEvent.setIconBounds(340, 45, 543, 335); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #7 - Solar Wind Radiation
         */
    	newEvent = new Event(Event.Moderate, true, GameData.PARTS, 25, 0.35, Person.engineer, true, false, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("You have recieved reports from scientists on earth that dangerous solar winds are imminent. They recommend you"
								+ " \nreinforce the ship with any parts available to reduce the risk of dangerous radiation levels. You may"
								+ " perform the \nreinforcements yourself or assign an Engineer to do so.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to rig the ship reinforcments yourself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign an Engineer to perform the required ship reinforcements.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to delegate and supervise the ship reinforcements.");
		newEvent.setOption4("You ignore the reports and continue on your journey keeping your crew completely oblivious.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/SolarWind.jpg";
		newEvent.setIconBounds(360, 45, 576, 324); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #8 - Space Anomaly
         */
    	newEvent = new Event(Event.Moderate, true, GameData.FOOD, 25, 0.35, Person.botanist, true, false, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There appears to be a spatial anomaly dangerously close to the ships path to " + Destination.getName() +"."
								+ " The anomaly appears to\n drain energy. Earth scientists recommend you temporarily power down all"
								+ " non critical systems and keep life support in low power mode. Your crew will consume extra food since"
								+ " the ship will become extremely cold.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to navigate around the anomaly with all systems on.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Botanist to hand out minimal rations compensated by ship grown food.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to distribute extra food rations.");
		newEvent.setOption4("You power down all systems and deny your crew extra food rations.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/Space_Anamoly_1.jpg";
		newEvent.setIconBounds(420, 45, 420, 333); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #9 - Asteroid
         */
    	newEvent = new Event(Event.Moderate, true, GameData.FUEL, 25, 0.35, Person.pilot, false, true, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("There appears to be an asteroid that is dangerously close to the ships path to " + Destination.getName() +"."
								+ " A collision is very likely if you \ndo not perform a course correction captain. Mission control advises"
								+ " a course correction by a qualified crew member.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to navigate around the asteroid yourself. You claim your the best pilot there every was.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Pilot to perform the optimal manuever at minimal cost.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to oversee the course correction. Potentially more or less fuel consumption.");
		newEvent.setOption4("You decide not to perform the course correction and tell the crew not to look out the window.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/iceAsteroid.jpg";
		newEvent.setIconBounds(360, 45, 600, 335); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #10 - Gamma Ray Burst
         */
    	newEvent = new Event(Event.Moderate, true, GameData.PARTS, 30, 0.35, Person.scientist, true, true, false);
		newEvent.titleColor = Color.YELLOW;
		newEvent.setDescription("An important transmission from earth reports that the ships is at risk of being hit by a gamma ray burst resulting \nfrom a near by star going supernova. The ship could be"
								+ " severely damaged. Mission control recommends you have a scientist determine which of your available materials can be used to insulate the ship and the crew.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Attempt to macgyver the required ship insulations yourself. You claim to be a material science expert.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a scientist to determine the required materials.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to handle or oversee the required ship insulation.");
		newEvent.setOption4("You ignore the reports and keep the entire crew oblivious of the impending doom.");
		//Set Icon location
		newEvent.iconLocation = "lib/images/superNova.jpg";
		newEvent.setIconBounds(400, 45, 518, 327); 
		
        EventPool.events.add(newEvent);
        
        /*
         *	Event #11 - WormHole
         */
    	newEvent = new Event(Event.Low, true, GameData.FUEL, 25, 0.35, Person.pilot, false, false, true);
		newEvent.titleColor = Color.CYAN;
		newEvent.setDescription("You have recieved an important transmission from mission control mentioning the anamolous appearance of a wormhole on your trajectory to "+ Destination.getName() + "."+
								" No one knows where it leads. You may try to enter it but it is very likely that it will \nevaporate shortly after since it appears highly unstable. There is a chance it may increase or decrease your voyage.");
		//Set option text
		newEvent.setOption1("[Success chance "+ newEvent.chance*100 +"%] Pilot the ship into the wormhole yourself.");
		newEvent.setOption2("["+ String.valueOf(newEvent.getCost() - 15) + " " + Event.getTypeString(newEvent.getPenaltyType()) +"] Assign a Pilot to perform the optimal manuever into the wormhole.");
		newEvent.setOption3("[0 - "+ newEvent.getCost()+" " + Event.getTypeString(newEvent.penaltyType) +"] Assign your VIP to oversee the course correction. Potentially more or less fuel consumption.");
		newEvent.setOption4("You decide not to enter the wormhole and maintain your current trajectory to " + Destination.getName() + ".");
		//Set Icon location
		newEvent.iconLocation = "lib/images/wormHole.jpg";
		newEvent.setIconBounds(450, 45, 408, 337); 
		
        EventPool.events.add(newEvent);
	}
    
    public static Event getRandomEvent(){
    	return EventPool.events.get(rand.nextInt((EventPool.events.size())));
    }
    
    public static Event getEvent(int index){
    	return EventPool.events.get(index);
    }
}
