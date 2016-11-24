package gameWindow;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;
import gameExecution.GameData;

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
	
	protected  JLabel crewSkill1; protected  JLabel crewName1; protected  JLabel CrewIcon1;
	protected  JLabel crewSkill2; protected  JLabel crewName2; protected  JLabel CrewIcon2;
	protected  JLabel crewSkill3; protected JLabel crewName3;  protected  JLabel CrewIcon3;
	protected  JLabel crewSkill4; protected  JLabel crewName4; protected  JLabel CrewIcon4;
	protected  JLabel crewSkill5; protected  JLabel crewName5; protected  JLabel CrewIcon5;
	
	protected  JLabel shipIcon;
	protected  JLabel hullStatus;

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		
		setBounds(0, 0, 1274, 692);
		setOpaque(false);
		setVisible(false);
		setLayout(null);
		
		CrewIcon1 = new JLabel("");
		CrewIcon1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon1.setBounds(1003, 16, 58, 57);
		add(CrewIcon1);
		
		CrewIcon2 = new JLabel("");
		CrewIcon2.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon2.setBounds(935, 16, 58, 57);
		add(CrewIcon2);
		
		CrewIcon3 = new JLabel("");
		CrewIcon3.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon3.setBounds(1071, 16, 58, 57);
		add(CrewIcon3);
		
		CrewIcon4 = new JLabel("");
		CrewIcon4.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon4.setBounds(867, 16, 58, 57);
		add(CrewIcon4);
		
		CrewIcon5 = new JLabel("");
		CrewIcon5.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon5.setBounds(1139, 16, 58, 57);
		add(CrewIcon5);
		
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
		
		crewName1 = new JLabel("Decker");
		crewName1.setForeground(Color.CYAN);
		crewName1.setFont(new Font("Slider", Font.BOLD, 12));
		crewName1.setBounds(880, 76, 58, 14);
		add(crewName1);
		
		crewName2 = new JLabel("Maxx");
		crewName2.setForeground(Color.CYAN);
		crewName2.setFont(new Font("Slider", Font.BOLD, 12));
		crewName2.setBounds(948, 76, 58, 14);
		add(crewName2);
		
		crewName3 = new JLabel("Smith");
		crewName3.setForeground(Color.CYAN);
		crewName3.setFont(new Font("Slider", Font.BOLD, 12));
		crewName3.setBounds(1016, 76, 58, 14);
		add(crewName3);
		
		crewName4 = new JLabel("Jane");
		crewName4.setForeground(Color.CYAN);
		crewName4.setFont(new Font("Slider", Font.BOLD, 12));
		crewName4.setBounds(1084, 76, 58, 14);
		add(crewName4);
		
		crewName5 = new JLabel("John");
		crewName5.setForeground(Color.CYAN);
		crewName5.setFont(new Font("Slider", Font.BOLD, 12));
		crewName5.setBounds(1152, 76, 58, 14);
		add(crewName5);
		
		crewSkill1 = new JLabel("Pilot");
		crewSkill1.setForeground(Color.CYAN);
		crewSkill1.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill1.setBounds(880, 92, 68, 14);
		add(crewSkill1);
		
		crewSkill2 = new JLabel("Engineer");
		crewSkill2.setForeground(Color.CYAN);
		crewSkill2.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill2.setBounds(948, 92, 68, 14);
		add(crewSkill2);
		
		crewSkill3 = new JLabel("Scientist");
		crewSkill3.setForeground(Color.CYAN);
		crewSkill3.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill3.setBounds(1016, 92, 68, 14);
		add(crewSkill3);
		
		crewSkill4 = new JLabel("Doctor");
		crewSkill4.setForeground(Color.CYAN);
		crewSkill4.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill4.setBounds(1084, 92, 68, 14);
		add(crewSkill4);
		
		crewSkill5 = new JLabel("Botanist");
		crewSkill5.setForeground(Color.CYAN);
		crewSkill5.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill5.setBounds(1152, 92, 68, 14);
		add(crewSkill5);
		
		shipIcon = new JLabel("");
		shipIcon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipNominal.png")));
		shipIcon.setBounds(1112, 127, 128, 128);
		add(shipIcon);
		
		hullStatus = new JLabel("Nominal");
		hullStatus.setForeground(Color.CYAN);
		hullStatus.setFont(new Font("Slider", Font.BOLD, 12));
		hullStatus.setBounds(1139, 260, 68, 14);
		add(hullStatus);
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
	
	public void ManagerSetup(GameData gameData){
		//Set Crew Names in Manager UI
		crewName1.setText(gameData.getCrew().get(0).getName());
		crewName2.setText(gameData.getCrew().get(1).getName());
		crewName3.setText(gameData.getCrew().get(2).getName());
		crewName4.setText(gameData.getCrew().get(3).getName());
		crewName5.setText(gameData.getCrew().get(4).getName());
		//Set Crew Skills in Manager UI
		crewSkill1.setText(gameData.getCrew().get(0).getSkill(true));
		crewSkill2.setText(gameData.getCrew().get(1).getSkill(true));
		crewSkill3.setText(gameData.getCrew().get(2).getSkill(true));
		crewSkill4.setText(gameData.getCrew().get(3).getSkill(true));
		crewSkill5.setText(gameData.getCrew().get(4).getSkill(true));
	}
	
	public void updateManager(GameData gameData){
		FuelBar.setValue(gameData.getFuel());
		FoodBar.setValue(gameData.getFood());
		WaterBar.setValue(gameData.getWater());
		PartBar.setValue(gameData.getParts());
		for(int i = 0; i< gameData.getCrew().size(); i++){
			updateCrewIcon(gameData.getCrew().get(i), i);
		}
		 updateShipIcon(gameData.getSpacecraft().getHull());
	}
	
	public void updateCrewIcon(Person crewMember, int id){
		
		if(crewMember.getHealthStatus() >= Person.nominal){
			getCrewIcon(id).setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		}else if(crewMember.getHealthStatus() >= Person.injured){
			getCrewIcon(id).setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewInjured.png")));
		}else if(crewMember.getHealthStatus() >= Person.critical){
			getCrewIcon(id).setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewCritical.png")));
		}else{
			getCrewIcon(id).setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewDead.png")));
		}
	}
	
	public JLabel getCrewIcon(int id){
		switch(id+1){
			case 1:
				return CrewIcon1;
			case 2:
				return CrewIcon2;
			case 3:
				return CrewIcon3;
			case 4:
				return CrewIcon4;
			case 5:
				return CrewIcon5;
			default:
				return CrewIcon1;
		}
	}
	
	public void updateShipIcon(int hull){
		if(hull >= Spaceship.nominal){
			shipIcon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipNominal.png")));
			hullStatus.setText("Nominal");
			hullStatus.setForeground(Color.CYAN);
		}else if(hull >= Spaceship.damaged){
			shipIcon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipDamaged.png")));
			hullStatus.setText("Damaged");
			hullStatus.setForeground(Color.YELLOW);
		}else if(hull >= Spaceship.critical){
			shipIcon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipCritical.png")));
			hullStatus.setText("Critical");
			hullStatus.setForeground(Color.RED);
		}else{
			shipIcon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipDestroyed.png")));
			hullStatus.setText("Destroyed");
			hullStatus.setForeground(Color.GRAY);
		}
	}

}
