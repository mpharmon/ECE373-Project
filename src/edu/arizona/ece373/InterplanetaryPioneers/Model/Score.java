package edu.arizona.ece373.InterplanetaryPioneers.Model;
import java.io.Serializable;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.View.DifficultySet;

public class Score implements Serializable{
	
	private String captName;
	private int score;
	private int difficulty;
	private int destID;
	private int shipID;
	
	public Score(){
		captName = "Unknown";
		score = 0;
		difficulty = DifficultySet.Easy;
		destID = Destination.MARS;
	}
	
	public Score(String captName, int score, int difficulty, int destID){
		captName = "Unknown";
		score = 0;
		difficulty = DifficultySet.Easy;
		destID = Destination.MARS;
	}
	
	public String getCaptName() {
		return captName;
	}
	public void setCaptName(String captName) {
		this.captName = captName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getDestID() {
		return destID;
	}
	public void setDestID(int destID) {
		this.destID = destID;
	}
	public String toString(){
		return (captName +" "+ destID +" "+ difficulty +" " + score);
	}

	public int getShipID() {
		return shipID;
	}

	public void setShipID(int shipID) {
		this.shipID = shipID;
	}
	
}
