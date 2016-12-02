package edu.arizona.ece373.InterplanetaryPioneers.Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class HighScore implements Serializable{
	
	public ArrayList<Score> scores;
	private int scoreLimit;
	
	public HighScore(){
		scores = new ArrayList<Score>();
		scoreLimit = 8;
	}
	
	//Adds new score and then resorts the list. Removes items passed scoreLimit(number of scores stored)
	public void addScore(Score score){
		System.out.println("Current scores stored: " + scores.size());
		if(scores.size() < scoreLimit){
			if(!scores.add(score)) System.out.println("Failed to add score to list of scores.");
			Collections.sort(scores, new ScoreCompare());
		}else{
			scores.add(score);
			Collections.sort(scores, new ScoreCompare());
			scores.remove(scoreLimit); //remove last
		}
		System.out.println("After new scores added: " + scores.size());
	}
	
	public void sort(){
		Collections.sort(scores, new ScoreCompare());
	}
	
	class ScoreCompare implements Comparator<Score>{
	    @Override
	    public int compare(Score s1, Score s2){
			 //Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. 
			if(s1.getScore() < s2.getScore())
				return 1;
			else 
				return -1;
		}
	}

	public static void saveData(HighScore newScores){
		
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			
			fileOut = new FileOutputStream("highScore.ser");
			objOut = new ObjectOutputStream(fileOut);
			
			objOut.writeObject(newScores);
			
			objOut.close();
			fileOut.close();
		}
		
		catch (IOException i){
			
			i.printStackTrace();
		}
		
	}
	
	
	public static HighScore loadData(){
		
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		HighScore highScore = null;
		boolean empty = false;
		
		try {
			
			fileIn = new FileInputStream("highScore.ser");
			objIn = new ObjectInputStream(fileIn);
			
			highScore = (HighScore) objIn.readObject();	
			
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i){
			System.out.println("Not Found.");
			HighScore.saveData(new HighScore());
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e)
		{	empty = true;
			System.out.println("No High Scores.");
			e.printStackTrace();
			
		}
		if(empty)
			return new HighScore();
		else
			return highScore;
	}
	
	public ArrayList<Score> getScores(){
		return scores;
	}
	
	public void printData(){
		System.out.println("Printing Score data "+ scores.size() + " Total:");
		for(int i = 0; i< scores.size(); i++){
			System.out.println(scores.get(i).toString());
		}
	}
	
}
