package edu.arizona.ece373.InterplanetaryPioneers.Model;

import java.text.DecimalFormat;

public class Destination {
	
	private static int id;
	private static String name;
	private static String type;
	private static int distance;
	
	public static final Integer MARS = 1;
	public static final Integer EUROPA = 2;
	public static final Integer MarsDistance   = 250000000; // 250 MKM
	public static final Integer EuropaDistance = 800000000; // 800 MKM
	public static final Integer IN_PROGRESS = 0;
	public static final Integer DESTINATION_APPROACH = 1;
	public static final Integer DESTINATION_REACHED = 2;
	public static Integer PROXIMITY = 25000000;
	public static DecimalFormat distFormat = new DecimalFormat("###,###,###");
	
	public static void initDestination(int select){
		if(select == 1){
			id = 1;
			name = "Mars";
			type = "Planet";
			distance = MarsDistance; //250 MKM
			PROXIMITY = 10000000;
		}else{
			id = 2;
			name = "Europa";
			type = "Moon";
			distance = EuropaDistance; //800 MKM
			PROXIMITY = 40000000;
		}
	}
	
	public static int getId() {
		return id;
	}

	public static String getName() {
		return name;
	}
	
	public static String getName(int ID) {
		if(ID == MARS)
			return "Mars";
		else
			return "Europa";
	}

	public static String getType() {
		return type;
	}

	public static Integer getDistance() {
		return distance;
	}

}
