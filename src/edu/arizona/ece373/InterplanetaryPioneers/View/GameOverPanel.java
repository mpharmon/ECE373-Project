package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Event;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOverPanel extends JPanel {
	private boolean GameOver;
	private boolean GameOverActive = false;
	private JTextField txtCondition;
	private JTextField txtDays;
	private JTextField txtDistance;
	private JTextField txtEventSuccess;
	private JTextField txtDestination;
	private JTextField txtEvents;
	
	private boolean criticalFail;
	private boolean noFood;
	private boolean Destroyed;
	private boolean noWater;
	private boolean lowFuel;
	
	private boolean Continue;

	/**
	 * Create the panel.
	 */
	public GameOverPanel() {
		setLayout(null);
		
		criticalFail = false;
		noFood = false;
		Destroyed = false;
		noWater = false;
		
		JLabel lblTitle = new JLabel("Game Over");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 42));
		lblTitle.setBounds(541, 22, 230, 51);
		add(lblTitle);
		
		JLabel lblGameOverImage = new JLabel("");
		lblGameOverImage.setIcon(new ImageIcon("lib/images/gameOver.jpg"));
		lblGameOverImage.setBounds(382, 71, 538, 433);
		add(lblGameOverImage);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestination.setForeground(Color.WHITE);
		lblDestination.setFont(new Font("Slider", Font.PLAIN, 18));
		lblDestination.setBounds(401, 499, 205, 28);
		add(lblDestination);
		
		txtDestination = new JTextField();
		txtDestination.setText("Mars");
		txtDestination.setOpaque(false);
		txtDestination.setForeground(Color.WHITE);
		txtDestination.setFont(new Font("Slider", Font.PLAIN, 18));
		txtDestination.setColumns(10);
		txtDestination.setBorder(null);
		txtDestination.setBounds(626, 499, 205, 28);
		add(txtDestination);
		
		JLabel lblFailCondition = new JLabel("Game Over Condition:");
		lblFailCondition.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFailCondition.setForeground(Color.WHITE);
		lblFailCondition.setFont(new Font("Slider", Font.PLAIN, 18));
		lblFailCondition.setBounds(401, 526, 205, 28);
		add(lblFailCondition);
		
		txtCondition = new JTextField();
		txtCondition.setBorder(null);
		txtCondition.setText("N/A");
		txtCondition.setOpaque(false);
		txtCondition.setForeground(Color.WHITE);
		txtCondition.setFont(new Font("Slider", Font.PLAIN, 18));
		txtCondition.setBounds(626, 526, 613, 28);
		add(txtCondition);
		txtCondition.setColumns(10);
		
		JLabel lblDaysSurvived = new JLabel("Days Survived:");
		lblDaysSurvived.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaysSurvived.setForeground(Color.WHITE);
		lblDaysSurvived.setFont(new Font("Slider", Font.PLAIN, 18));
		lblDaysSurvived.setBounds(468, 551, 138, 28);
		add(lblDaysSurvived);
		
		txtDays = new JTextField();
		txtDays.setBorder(null);
		txtDays.setText("0");
		txtDays.setOpaque(false);
		txtDays.setForeground(Color.WHITE);
		txtDays.setFont(new Font("Slider", Font.PLAIN, 18));
		txtDays.setColumns(10);
		txtDays.setBounds(626, 551, 205, 28);
		add(txtDays);
		
		JLabel lblDistanceTraveled = new JLabel("Distance Traveled:");
		lblDistanceTraveled.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistanceTraveled.setForeground(Color.WHITE);
		lblDistanceTraveled.setFont(new Font("Slider", Font.PLAIN, 18));
		lblDistanceTraveled.setBounds(432, 575, 174, 28);
		add(lblDistanceTraveled);
		
		txtDistance = new JTextField();
		txtDistance.setBorder(null);
		txtDistance.setText("0 KM");
		txtDistance.setOpaque(false);
		txtDistance.setForeground(Color.WHITE);
		txtDistance.setFont(new Font("Slider", Font.PLAIN, 18));
		txtDistance.setColumns(10);
		txtDistance.setBounds(626, 577, 205, 28);
		add(txtDistance);
		
		JLabel lblEvents = new JLabel("Event Encounters:");
		lblEvents.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvents.setForeground(Color.WHITE);
		lblEvents.setFont(new Font("Slider", Font.PLAIN, 18));
		lblEvents.setBounds(421, 598, 185, 28);
		add(lblEvents);
		
		txtEvents = new JTextField();
		txtEvents.setText("0");
		txtEvents.setOpaque(false);
		txtEvents.setForeground(Color.WHITE);
		txtEvents.setFont(new Font("Slider", Font.PLAIN, 18));
		txtEvents.setColumns(10);
		txtEvents.setBorder(null);
		txtEvents.setBounds(626, 598, 205, 28);
		add(txtEvents);
		
		JLabel lblEventSuccess = new JLabel("Event Success:");
		lblEventSuccess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEventSuccess.setForeground(Color.WHITE);
		lblEventSuccess.setFont(new Font("Slider", Font.PLAIN, 18));
		lblEventSuccess.setBounds(468, 620, 138, 28);
		add(lblEventSuccess);
		
		txtEventSuccess = new JTextField();
		txtEventSuccess.setBorder(null);
		txtEventSuccess.setText("0  %");
		txtEventSuccess.setOpaque(false);
		txtEventSuccess.setForeground(Color.WHITE);
		txtEventSuccess.setFont(new Font("Slider", Font.PLAIN, 18));
		txtEventSuccess.setColumns(10);
		txtEventSuccess.setBounds(626, 620, 205, 28);
		add(txtEventSuccess);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Continue = true;
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Slider", Font.PLAIN, 18));
		btnNewButton.setBounds(575, 650, 168, 41);
		add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("lib/images/gameOverHud.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);
		setGameOver(false);
		setVisible(false);
		
	}
	public boolean isGameOver() {
		return GameOver;
	}
	public void setGameOver(boolean gameOver) {
		GameOver = gameOver;
	}
	
	public void displayGameOver(){
		GameOverActive = true;
		GameOver = true;
		Continue = false;
		//Update all text fields then display panel
		txtDestination.setText(Destination.getName());
		if(criticalFail){
			txtCondition.setText("A critical event was unresolved which ended in catastrophic failure.");
		}else if(Destroyed){
			txtCondition.setText("The ship was destroyed.");
		}else if(noFood){
			txtCondition.setText("The food reserves were depleted. The crew died of starvation.");
		}else if(noWater){
			txtCondition.setText("The water reserves were depleted. The crew died of dehydration.");
		}else if(lowFuel){
			txtCondition.setText("The fuel reserves were depleted. Life support failed.");
		}else{
			txtCondition.setText("An anomaly occured which ended your voyage early.");
		}
		txtDays.setText(String.format(java.util.Locale.US, "%.0f" , GameData.days));
		txtDistance.setText(Destination.distFormat.format(GameData.currentDistance)+ " KM");
		txtEvents.setText(String.valueOf(GameData.totalEvents));
		if(GameData.totalEvents > 0){
			System.out.println("resolvedEvents: " + GameData.resolvedEvents);
			System.out.println("totalEvents: " + GameData.totalEvents);
			Double temp = (GameData.resolvedEvents * 1.0) / GameData.totalEvents * 100.0;
			System.out.println("Events successful: " + GameData.resolvedEvents + "\n" + temp);
			txtEventSuccess.setText(String.format(java.util.Locale.US, "%4.1f" , temp) + " %");
		}
	}
	
	public boolean checkGameOver(Event currentEvent){
		//Check if critical event failed
		if(currentEvent.getSeverity() == Event.Critical){
			if(currentEvent.isOutcome() == Event.FAILED){
				criticalFail = true;
				return true;
			}
		}else	
		{	//Check if ship destroyed
			if(GameData.spacecraft.getHull() <= Spaceship.destroyed){
				Destroyed = true;
				return true;
			}
			//Additional game over conditions for difficulties above easy
			if(GameData.difficulty > DifficultySet.Easy){
				//Check if out of food
				if(GameData.food <= 0){
					noFood = true;
					return true;
				}
				//Check if out of Water
				if(GameData.water <= 0){
					noWater = true;
					return true;
				}
				//Check if insufficient fuel for landing
				if(GameData.fuel <= 0){
					lowFuel = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isNoFood() {
		return noFood;
	}
	public void setNoFood(boolean noFood) {
		this.noFood = noFood;
	}
	public boolean isDestroyed() {
		return Destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		Destroyed = destroyed;
	}
	public boolean isNoWater() {
		return noWater;
	}
	public void setNoWater(boolean noWater) {
		this.noWater = noWater;
	}
	public boolean isCriticalFail() {
		return criticalFail;
	}
	public void setCriticalFail(boolean criticalFail) {
		this.criticalFail = criticalFail;
	}
	public boolean isLowFuel() {
		return lowFuel;
	}
	public void setLowFuel(boolean lowFuel) {
		this.lowFuel = lowFuel;
	}
	public boolean isContinue() {
		return Continue;
	}
	public void setContinue(boolean Continue) {
		this.Continue = Continue;
	}
	public boolean isGameOverActive() {
		return GameOverActive;
	}
	public void setGameOverActive(boolean gameOverActive) {
		GameOverActive = gameOverActive;
	}
}
