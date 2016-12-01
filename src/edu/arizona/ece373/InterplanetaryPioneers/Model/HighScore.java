package edu.arizona.ece373.InterplanetaryPioneers.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore implements Serializable{
	
	public static ArrayList<Score> scores;
	public static int scoreLimit;
	
	public static void initialize(){
		scores = new ArrayList<Score>();
		scoreLimit = 5;
	}
	
	public static void addScore(Score score){
		for(int i = 0; i < scores.size(); i++ ){
			
		}
		
	}
	
	public static void LoadScores(){
		
	}
	
	public static void SaveScores(){
		
	}

}
