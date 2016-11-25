package edu.arizona.ece373.InterplanetaryPioneers.Model;

public class Destination {
	
	private static int id;
	private static String name;
	private static String type;
	private static int distance;
	
	public static void initDestination(int select){
		if(select == 1){
			id = 1;
			name = "Mars";
			type = "Planet";
			distance = 500000000; //500 MKM
		}else{
			id = 2;
			name = "Europa";
			type = "Moon";
			distance = 500000000; //500 MKM
		}
	}
	
	public static int getId() {
		return id;
	}

	public static String getName() {
		return name;
	}

	public static String getType() {
		return type;
	}

	public static int getDistance() {
		return distance;
	}

}
