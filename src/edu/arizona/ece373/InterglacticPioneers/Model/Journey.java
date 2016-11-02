package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;

public class Journey {
	private static Integer totalDistance;
	private static ArrayList<Waypoint> waypoints;
	
	//Get'ers and Set'ers
	public static Integer getTotalDistance(){return Journey.totalDistance;};
	public static ArrayList<Waypoint> getWaypoints(){return Journey.waypoints;};
	
	public static void buildPath(Waypoint Destination){
		Journey.waypoints.add(new Waypoint("Earth"));
	}
}
