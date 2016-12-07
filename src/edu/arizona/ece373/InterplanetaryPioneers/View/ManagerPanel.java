package edu.arizona.ece373.InterplanetaryPioneers.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;

public class ManagerPanel extends JPanel {
	protected JProgressBar FuelBar;
	protected  JProgressBar FoodBar;
	protected  JProgressBar WaterBar;
	protected  JProgressBar PartBar;
	protected  JLabel lblBackground;
	protected  JLabel lblFuel;
	protected  JLabel labelFood;
	protected  JLabel lblWater;
	protected  JLabel lblSpareParts;
	
	private ArrayList<JLabel> crewSkill;
	private ArrayList<JLabel> crewName;
	private ArrayList<JLabel> crewIcon;
	
	protected  JLabel shipIcon;
	protected  JLabel hullStatus;
	private JTextField txtGameTime;
	public int seconds;

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		
		setBounds(0, 0, 1274, 692);
		setOpaque(false);
		setVisible(false);
		setLayout(null);
		
		crewSkill = new ArrayList<JLabel>(5);
		crewName = new ArrayList<JLabel>(5);
		crewIcon = new ArrayList<JLabel>(5);
		
		JLabel temp;

		for(int i = 0; i < 5; i++){
			temp = new JLabel("");
			crewIcon.add(temp);
		}

		crewIcon.get(0).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		crewIcon.get(0).setBounds(867, 16, 58, 57);
		add(crewIcon.get(0));
		
		crewIcon.get(1).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		crewIcon.get(1).setBounds(935, 16, 58, 57);
		add(crewIcon.get(1));
		

		crewIcon.get(2).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		crewIcon.get(2).setBounds(1003, 16, 58, 57);
		add(crewIcon.get(2));
		
		crewIcon.get(3).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		crewIcon.get(3).setBounds(1071, 16, 58, 57);
		add(crewIcon.get(3));
		
		crewIcon.get(4).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		crewIcon.get(4).setBounds(1139, 16, 58, 57);
		add(crewIcon.get(4));
		
		FuelBar = new JProgressBar();
		FuelBar.setForeground(new Color(0, 255, 0));
		FuelBar.setBounds(130, 152, 375, 22);
		add(FuelBar);
		
		FoodBar = new JProgressBar();
		FoodBar.setForeground(new Color(0, 255, 0));
		FoodBar.setBounds(130, 237, 375, 22);
		add(FoodBar);
		
		WaterBar = new JProgressBar();
		WaterBar.setForeground(new Color(0, 255, 0));
		WaterBar.setBounds(130, 327, 375, 22);
		add(WaterBar);
		
		PartBar = new JProgressBar();
		PartBar.setForeground(new Color(0, 255, 0));
		PartBar.setBounds(130, 419, 375, 22);
		add(PartBar);
		
		lblFuel = new JLabel("Fuel");
		lblFuel.setForeground(new Color(0, 255, 255));
		lblFuel.setFont(new Font("Slider", Font.PLAIN, 18));
		lblFuel.setBounds(289, 127, 46, 14);
		add(lblFuel);
		
		labelFood = new JLabel("Food");
		labelFood.setForeground(Color.CYAN);
		labelFood.setFont(new Font("Slider", Font.PLAIN, 18));
		labelFood.setBounds(289, 212, 46, 14);
		add(labelFood);
		
		lblWater = new JLabel("Water");
		lblWater.setForeground(Color.CYAN);
		lblWater.setFont(new Font("Slider", Font.PLAIN, 18));
		lblWater.setBounds(289, 302, 68, 14);
		add(lblWater);
		
		lblSpareParts = new JLabel("Spare Parts");
		lblSpareParts.setForeground(Color.CYAN);
		lblSpareParts.setFont(new Font("Slider", Font.PLAIN, 18));
		lblSpareParts.setBounds(261, 394, 112, 14);
		add(lblSpareParts);
		
		for(int i = 0; i < 5; i++){
			temp = new JLabel("");
			crewName.add(temp);
		}
		
		crewName.get(0).setForeground(Color.CYAN);
		crewName.get(0).setFont(new Font("Slider", Font.BOLD, 12));
		crewName.get(0).setBounds(880, 76, 58, 14);
		add(crewName.get(0));
		
		crewName.get(1).setForeground(Color.CYAN);
		crewName.get(1).setFont(new Font("Slider", Font.BOLD, 12));
		crewName.get(1).setBounds(948, 76, 58, 14);
		add(crewName.get(1));
		
		crewName.get(2).setForeground(Color.CYAN);
		crewName.get(2).setFont(new Font("Slider", Font.BOLD, 12));
		crewName.get(2).setBounds(1016, 76, 58, 14);
		add(crewName.get(2));
		
		crewName.get(3).setForeground(Color.CYAN);
		crewName.get(3).setFont(new Font("Slider", Font.BOLD, 12));
		crewName.get(3).setBounds(1084, 76, 58, 14);
		add(crewName.get(3));
		
		crewName.get(4).setForeground(Color.CYAN);
		crewName.get(4).setFont(new Font("Slider", Font.BOLD, 12));
		crewName.get(4).setBounds(1152, 76, 58, 14);
		add(crewName.get(4));
		
		for(int i = 0; i < 5; i++){
			temp = new JLabel("");
			crewSkill.add(temp);
		}
		
		crewSkill.get(0).setText("Pilot");
		crewSkill.get(0).setForeground(Color.CYAN);
		crewSkill.get(0).setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill.get(0).setBounds(880, 92, 68, 14);
		add(crewSkill.get(0));
		
		crewSkill.get(1).setText("Engineer");
		crewSkill.get(1).setForeground(Color.CYAN);
		crewSkill.get(1).setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill.get(1).setBounds(948, 92, 68, 14);
		add(crewSkill.get(1));
		
		crewSkill.get(2).setText("Scientist");
		crewSkill.get(2).setForeground(Color.CYAN);
		crewSkill.get(2).setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill.get(2).setBounds(1016, 92, 68, 14);
		add(crewSkill.get(2));
		
		crewSkill.get(3).setText("Doctor");
		crewSkill.get(3).setForeground(Color.CYAN);
		crewSkill.get(3).setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill.get(3).setBounds(1084, 92, 68, 14);
		add(crewSkill.get(3));
		
		crewSkill.get(4).setText("Botanist");
		crewSkill.get(4).setForeground(Color.CYAN);
		crewSkill.get(4).setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill.get(4).setBounds(1152, 92, 68, 14);
		add(crewSkill.get(4));
		
		shipIcon = new JLabel("");
		shipIcon.setIcon(new ImageIcon("lib/images/spaceshipNominal.png"));
		shipIcon.setBounds(1112, 127, 128, 128);
		add(shipIcon);
		
		hullStatus = new JLabel("Nominal");
		hullStatus.setForeground(Color.CYAN);
		hullStatus.setFont(new Font("Slider", Font.BOLD, 12));
		hullStatus.setBounds(1139, 260, 68, 14);
		add(hullStatus);
		
		txtGameTime = new JTextField();
		txtGameTime.setBorder(null);
		txtGameTime.setOpaque(false);
		txtGameTime.setForeground(Color.CYAN);
		txtGameTime.setText("Game time: ");
		txtGameTime.setFont(new Font("Slider", Font.PLAIN, 18));
		txtGameTime.setBounds(130, 16, 375, 20);
		add(txtGameTime);
		txtGameTime.setColumns(10);
	}
	
	public void initResources(int fuel, int food, int water, int parts){
		if(fuel >100) FuelBar.setValue(100);
		else FuelBar.setValue(fuel);
		if(food >100) FoodBar.setValue(100);
		else FoodBar.setValue(food);
		if(water >100) WaterBar.setValue(100);
		else WaterBar.setValue(water);
		if(parts >100) PartBar.setValue(100);
		else PartBar.setValue(parts);
	}
	
	public void ManagerSetup(){
		seconds = 0;
		//Set Crew Names in Manager UI
		crewName.get(0).setText(GameData.crew.get(0).getName());
		crewName.get(1).setText(GameData.crew.get(1).getName());
		crewName.get(2).setText(GameData.crew.get(2).getName());
		crewName.get(3).setText(GameData.crew.get(3).getName());

		//Set Crew Skills in Manager UI
		crewSkill.get(0).setText(GameData.crew.get(0).getSkill(true));
		crewSkill.get(1).setText(GameData.crew.get(1).getSkill(true));
		crewSkill.get(2).setText(GameData.crew.get(2).getSkill(true));
		crewSkill.get(3).setText(GameData.crew.get(3).getSkill(true));
		if(GameData.crew.size() > 4){
			crewName.get(4).setText(GameData.crew.get(4).getName());
			crewSkill.get(4).setText(GameData.crew.get(4).getSkill(true));
		}else{
			crewName.get(4).setVisible(false);
			crewSkill.get(4).setVisible(false);
			crewIcon.get(4).setVisible(false);
		}
	}
	
	public void updateManager(boolean IconUpdate){
		FuelBar.setValue(GameData.fuel.intValue());
		FoodBar.setValue(GameData.food.intValue());
		WaterBar.setValue(GameData.water.intValue());
		PartBar.setValue(GameData.parts.intValue());
		if(IconUpdate){
			for(int i = 0; i < GameData.crew.size(); i++){
				System.out.println("Crew member "+i+": " + GameData.crew.get(i).getName()+" "+ GameData.crew.get(i).getHealthStatus());
				updateCrewIcon(GameData.crew.get(i), i);
			}
			 updateShipIcon(GameData.spacecraft.getHull());
		}
	}
	
	public void updateCrewIcon(Person crewMember, int id){
		
		if(crewMember.getHealthStatus() >= Person.nominal){
			getCrewIcon(id).setIcon(new ImageIcon("lib/images/crewNominal.png"));
		}else if(crewMember.getHealthStatus() >= Person.injured){
			getCrewIcon(id).setIcon(new ImageIcon("lib/images/crewInjured.png"));
		}else if(crewMember.getHealthStatus() >= Person.critical){
			getCrewIcon(id).setIcon(new ImageIcon("lib/images/crewCritical.png"));
		}else{
			getCrewIcon(id).setIcon(new ImageIcon("lib/images/crewDead.png"));
		}
	}
	
	public JLabel getCrewIcon(int id){
		switch(id){
			case 0:
				return crewIcon.get(0);
			case 1:
				return crewIcon.get(1);
			case 2:
				return crewIcon.get(2);
			case 3:
				return crewIcon.get(3);
			case 4:
				return crewIcon.get(4);
			default:
				return crewIcon.get(0);
		}
	}
	
	public void updateShipIcon(int hull){
		if(hull >= Spaceship.nominal){
			shipIcon.setIcon(new ImageIcon("lib/images/spaceshipNominal.png"));
			hullStatus.setText("Nominal");
			hullStatus.setForeground(Color.CYAN);
		}else if(hull >= Spaceship.damaged){
			shipIcon.setIcon(new ImageIcon("lib/images/spaceshipDamaged.png"));
			hullStatus.setText("Damaged");
			hullStatus.setForeground(Color.YELLOW);
		}else if(hull >= Spaceship.critical){
			shipIcon.setIcon(new ImageIcon("lib/images/spaceshipCritical.png"));
			hullStatus.setText("Critical");
			hullStatus.setForeground(Color.RED);
		}else{
			shipIcon.setIcon(new ImageIcon("lib/images/spaceshipDestroyed.png"));
			hullStatus.setText("Destroyed");
			hullStatus.setForeground(Color.GRAY);
		}
	}
	
	public boolean updateTimeElapsed(){
		seconds++;
		if(seconds <= 1800){
			txtGameTime.setText("Game time: "+  seconds/60 +":" + String.format(java.util.Locale.US, "%02d" , seconds%60));
			return true;
		}
		return false;
	}
}
