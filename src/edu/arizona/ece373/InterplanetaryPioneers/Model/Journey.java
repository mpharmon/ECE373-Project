package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Journey {
	private static Integer totalDistance;
	private static ArrayList<Event> events;
	private static Spaceship ship;
	private static Integer difficulty;
	private static ArrayList<Person> people;

	// Get'ers and Set'ers
	public static Integer getTotalDistance() {
		return Journey.totalDistance;
	};

	public static ArrayList<Event> getEvents() {
		return Journey.events;
	};

	public static Spaceship getSpaceship() {
		return Journey.ship;
	}

	public static void setDifficulty(Integer d) {
		Journey.difficulty = d;
	}

	public static Integer getDifficulty() {
		return Journey.difficulty;
	}

	public static void buildEvents() {
		Journey.events.add(new Waypoint("Earth", "Planet Earth", true));
		// TODO - Add Events
	}

}
