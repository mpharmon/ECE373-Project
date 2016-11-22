package gameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import gameExecution.GameData;
import gameExecution.GameTimer;
import gameSound.CustomPlayer;
import sounds.SongPath;

import java.awt.Component;
import javax.swing.JTextField;

public class TransferStage extends JFrame {
	
	private int windowId;
	private int X0_pos, X1_pos, X2_pos, X3_pos, X4_pos, X5_pos, X6_pos, X7_pos;
	private int Y5_pos, Y6_pos, Y7_pos;
	
	private boolean Warp;
	private boolean Manager;
	
	private double speed;
	private double X0_temp, X3_temp, X4_temp;
	private final double factor = 0.075;
	private final double factor_2 = 0.015;
	private final double factor_0 = 0.00043;
	private static final int standard = 10;
	private static final int TimeWarp = 2;
	private static final int cruise = 1;
	private static final int Supercruise = 5;
	private boolean satelite = false;
	private boolean chance = false;
	private boolean chance2 = false;
	private boolean oscillate = false;
	private boolean WarpOut = false;
	private int offset = 0;
	private double offset_temp = 0;
	private static final double SAT_CHANCE = 0.50;
	private static final double AST_CHANCE = 0.90;
	
	private GameTimer gameTimer;
	private GameTimer gameTimer2;
	private GameTimer EventTimer;

	private JPanel transferPane;
	private JPanel managerPanel;
	
	private JLabel lblTimeWarp;
	private JLabel lblSpaceFrame1;
	private JLabel lblSpaceFrame2;
	private JLabel lbSpacecraft;
	private JLabel lblAsteroid1;
	private JLabel lblSatelite1;
	private JLabel lblEarth; 
	private JLabel lblMoon;
	
	private JProgressBar FuelBar;
	private JProgressBar FoodBar;
	private JProgressBar WaterBar;
	private JProgressBar PartBar;
	private JLabel lblBackground;
	private JLabel lblFuel;
	private JLabel labelFood;
	private JLabel lblWater;
	private JLabel lblSpareParts;
	private JLabel lblVoyageManager;
	private JLabel lblThruster;
	private JTextField textDistance;
	private JLabel lblDistance;
	private JLabel lblMiles;
	
	private EventPanel eventPanel;
	private boolean event;
	private double EVENT_CHANCE = 0.10;
	
	private ResolutionPanel resultPanel;
	
	SongPath sp = new SongPath();
	CustomPlayer player = new CustomPlayer();
	
	private JLabel crewSkill1; private JLabel crewName1;
	private JLabel crewSkill2; private JLabel crewName2;
	private JLabel crewSkill3; private JLabel crewName3;
	private JLabel crewSkill4; private JLabel crewName4;
	private JLabel crewSkill5; private JLabel crewName5;
	private JLabel shipIntegrity;
	private JLabel hullStatus;
	
	/**
	 * Create the frame.
	 */
	public TransferStage() {
		setResizable(false);
		
		SongPath sp = new SongPath();
		CustomPlayer player = new CustomPlayer();

		gameTimer = new GameTimer();
		gameTimer2 = new GameTimer(5000);
		EventTimer = new GameTimer(5000);
		
		Warp = false;
		Manager = false;
		speed = 1;
		
		windowId = 5;
		X0_pos = -656; X0_temp = -656;
		X1_pos = 0;
		X2_pos = -1280;
		
		X3_pos = 0;    X3_temp = 0;
		X4_pos = 0;    X4_temp = -257;
		X5_pos = -186; Y5_pos = 125;
		X6_pos = 999;  Y6_pos = 295;
		X7_pos = 1189; Y7_pos =  282;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		transferPane = new JPanel();
		transferPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(transferPane);
		transferPane.setLayout(null);
		
		lblTimeWarp = new JLabel("Time Warp");
		lblTimeWarp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Warp = !Warp; //Toggle Warp
				if(!Manager){
					lblTimeWarp.setEnabled(Warp);
				}else{
					Manager = !Manager;
					lblTimeWarp.setEnabled(Warp);
					lblVoyageManager.setEnabled(Manager);
					managerPanel.setVisible(false);
				}
				if(!Warp){ 
					player.setPath(sp.getPath(20));
					player.play(-1);
				}else{ player.setPath(sp.getPath(19));
					player.play(-1);
				}
			}
		});
		
		/**
		 * Event Panel
		 */
		
		initEventPanel();
		/**
		 * Manager Panel
		 */
		initManagerPanel();
		/**
		 * Resolution Panel
		 */
		initResultPanel();
		
		
		lblVoyageManager = new JLabel("Voyage Manager");
		lblVoyageManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Manager = !Manager;
				if(Warp) { 
					Warp = false; lblTimeWarp.setEnabled(Warp);
					player.setPath(sp.getPath(20));
					player.play(-1);
					}
				lblVoyageManager.setEnabled(Manager);
				if(Manager) managerPanel.setVisible(true);
				else managerPanel.setVisible(false);
			}
		});
		lblVoyageManager.setBounds(523, 11, 270, 32);
		transferPane.add(lblVoyageManager);
		lblVoyageManager.setEnabled(false);
		lblVoyageManager.setForeground(Color.CYAN);
		lblVoyageManager.setFont(new Font("Slider", Font.PLAIN, 32));
		managerPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{FuelBar, FoodBar, WaterBar, PartBar, lblFuel, labelFood, lblWater, lblSpareParts, lblVoyageManager}));
		
		lblTimeWarp.setEnabled(false);
		lblTimeWarp.setForeground(new Color(0, 255, 255));
		lblTimeWarp.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTimeWarp.setBackground(new Color(255, 255, 255));
		lblTimeWarp.setBounds(565, 605, 174, 45);
		transferPane.add(lblTimeWarp);
		
		lblSpaceFrame1 = new JLabel("New label");
		lblSpaceFrame1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame1.setBounds(X1_pos, 0, 1264, 682);
		transferPane.add(lblSpaceFrame1);
		
		lblSpaceFrame2 = new JLabel("New label");
		lblSpaceFrame2.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame2.setBounds(X2_pos, 0, 1264, 682);
		transferPane.add(lblSpaceFrame2);
		
		lblDistance = new JLabel("Distance Traveled");
		lblDistance.setBounds(1050, 600, 180, 26);
		transferPane.add(lblDistance);
		lblDistance.setFont(new Font("Slider", Font.PLAIN, 20));
		lblDistance.setForeground(new Color(0, 255, 255));
		
		textDistance = new JTextField();
		textDistance.setBorder(null);
		textDistance.setOpaque(false);
		textDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		textDistance.setText("0");
		textDistance.setEditable(false);
		textDistance.setForeground(new Color(0, 255, 255));
		textDistance.setFont(new Font("Slider", Font.PLAIN, 20));
		textDistance.setBounds(972, 623, 245, 26);
		transferPane.add(textDistance);
		textDistance.setColumns(10);
		
		lblMiles = new JLabel("km");
		lblMiles.setBounds(1221, 625, 31, 22);
		transferPane.add(lblMiles);
		lblMiles.setFont(new Font("Slider", Font.PLAIN, 20));
		lblMiles.setForeground(new Color(0, 255, 255));
		
		lbSpacecraft = new JLabel("");
		lbSpacecraft.setBounds(999, 295, 255, 82);
		transferPane.add(lbSpacecraft);
		lbSpacecraft.setIcon(new ImageIcon(TransferStage.class.getResource("/images/SpaceXModel.png")));
		
		lblThruster = new JLabel("");
		lblThruster.setBounds(1189, 282, 196, 108);
		transferPane.add(lblThruster);
		lblThruster.setIcon(new ImageIcon(TransferStage.class.getResource("/images/thrustSmall.png")));
		
		lblSatelite1 = new JLabel("");
		lblSatelite1.setBounds(-186, 175, 186, 83);
		transferPane.add(lblSatelite1);
		lblSatelite1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/SateliteSmall.png")));
		
		lblAsteroid1 = new JLabel("");
		lblAsteroid1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/asteroid2sm.png")));
		lblAsteroid1.setBounds(-240, 11, 120, 150);
		transferPane.add(lblAsteroid1);
		
		lblEarth = new JLabel("Earth");
		lblEarth.setIcon(new ImageIcon(TransferStage.class.getResource("/images/EarthSmall.png")));
		lblEarth.setBounds(0, 0, 362, 384);
		transferPane.add(lblEarth);
		
		lblMoon = new JLabel("");
		lblMoon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/MoonSmall.png")));
		lblMoon.setBounds(-257, 0, 257, 252);
		transferPane.add(lblMoon);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Nebula_2.jpg")));
		lblBackground.setBounds(-640, 0, 1920, 1080);
		transferPane.add(lblBackground);
		transferPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTimeWarp, lblSpaceFrame1, lblSpaceFrame2, lblBackground}));
	}
	
	private void initManagerPanel() {
		
		managerPanel = new JPanel();
		managerPanel.setBounds(0, 0, 1274, 692);
		transferPane.add(managerPanel);
		managerPanel.setOpaque(false);
		managerPanel.setVisible(false);
		managerPanel.setLayout(null);
		
		JLabel CrewIcon1 = new JLabel("");
		CrewIcon1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon1.setBounds(1003, 16, 58, 57);
		managerPanel.add(CrewIcon1);
		
		JLabel CrewIcon2 = new JLabel("");
		CrewIcon2.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon2.setBounds(935, 16, 58, 57);
		managerPanel.add(CrewIcon2);
		
		JLabel CrewIcon3 = new JLabel("");
		CrewIcon3.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon3.setBounds(1071, 16, 58, 57);
		managerPanel.add(CrewIcon3);
		
		JLabel CrewIcon4 = new JLabel("");
		CrewIcon4.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon4.setBounds(867, 16, 58, 57);
		managerPanel.add(CrewIcon4);
		
		JLabel CrewIcon5 = new JLabel("");
		CrewIcon5.setIcon(new ImageIcon(TransferStage.class.getResource("/images/crewNominal.png")));
		CrewIcon5.setBounds(1139, 16, 58, 57);
		managerPanel.add(CrewIcon5);
		
		FuelBar = new JProgressBar();
		FuelBar.setForeground(new Color(0, 255, 0));
		FuelBar.setBounds(130, 152, 375, 22);
		managerPanel.add(FuelBar);
		
		FoodBar = new JProgressBar();
		FoodBar.setForeground(new Color(0, 255, 0));
		FoodBar.setBounds(130, 237, 375, 22);
		managerPanel.add(FoodBar);
		
		WaterBar = new JProgressBar();
		WaterBar.setForeground(new Color(0, 255, 0));
		WaterBar.setBounds(130, 327, 375, 22);
		managerPanel.add(WaterBar);
		
		PartBar = new JProgressBar();
		PartBar.setForeground(new Color(0, 255, 0));
		PartBar.setBounds(130, 419, 375, 22);
		managerPanel.add(PartBar);
		
		lblFuel = new JLabel("Fuel");
		lblFuel.setForeground(new Color(0, 255, 255));
		lblFuel.setFont(new Font("Slider", Font.PLAIN, 18));
		lblFuel.setBounds(289, 127, 46, 14);
		managerPanel.add(lblFuel);
		
		labelFood = new JLabel("Food");
		labelFood.setForeground(Color.CYAN);
		labelFood.setFont(new Font("Slider", Font.PLAIN, 18));
		labelFood.setBounds(289, 212, 46, 14);
		managerPanel.add(labelFood);
		
		lblWater = new JLabel("Water");
		lblWater.setForeground(Color.CYAN);
		lblWater.setFont(new Font("Slider", Font.PLAIN, 18));
		lblWater.setBounds(289, 302, 68, 14);
		managerPanel.add(lblWater);
		
		lblSpareParts = new JLabel("Spare Parts");
		lblSpareParts.setForeground(Color.CYAN);
		lblSpareParts.setFont(new Font("Slider", Font.PLAIN, 18));
		lblSpareParts.setBounds(261, 394, 112, 14);
		managerPanel.add(lblSpareParts);
		
		crewName1 = new JLabel("Decker");
		crewName1.setForeground(Color.CYAN);
		crewName1.setFont(new Font("Slider", Font.BOLD, 12));
		crewName1.setBounds(880, 76, 58, 14);
		managerPanel.add(crewName1);
		
		crewName2 = new JLabel("Maxx");
		crewName2.setForeground(Color.CYAN);
		crewName2.setFont(new Font("Slider", Font.BOLD, 12));
		crewName2.setBounds(948, 76, 58, 14);
		managerPanel.add(crewName2);
		
		crewName3 = new JLabel("Smith");
		crewName3.setForeground(Color.CYAN);
		crewName3.setFont(new Font("Slider", Font.BOLD, 12));
		crewName3.setBounds(1016, 76, 58, 14);
		managerPanel.add(crewName3);
		
		crewName4 = new JLabel("Jane");
		crewName4.setForeground(Color.CYAN);
		crewName4.setFont(new Font("Slider", Font.BOLD, 12));
		crewName4.setBounds(1084, 76, 58, 14);
		managerPanel.add(crewName4);
		
		crewName5 = new JLabel("John");
		crewName5.setForeground(Color.CYAN);
		crewName5.setFont(new Font("Slider", Font.BOLD, 12));
		crewName5.setBounds(1152, 76, 58, 14);
		managerPanel.add(crewName5);
		
		crewSkill1 = new JLabel("Pilot");
		crewSkill1.setForeground(Color.CYAN);
		crewSkill1.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill1.setBounds(880, 92, 68, 14);
		managerPanel.add(crewSkill1);
		
		crewSkill2 = new JLabel("Engineer");
		crewSkill2.setForeground(Color.CYAN);
		crewSkill2.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill2.setBounds(948, 92, 68, 14);
		managerPanel.add(crewSkill2);
		
		crewSkill3 = new JLabel("Scientist");
		crewSkill3.setForeground(Color.CYAN);
		crewSkill3.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill3.setBounds(1016, 92, 68, 14);
		managerPanel.add(crewSkill3);
		
		crewSkill4 = new JLabel("Doctor");
		crewSkill4.setForeground(Color.CYAN);
		crewSkill4.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill4.setBounds(1084, 92, 68, 14);
		managerPanel.add(crewSkill4);
		
		crewSkill5 = new JLabel("Botanist");
		crewSkill5.setForeground(Color.CYAN);
		crewSkill5.setFont(new Font("Slider", Font.BOLD, 12));
		crewSkill5.setBounds(1152, 92, 68, 14);
		managerPanel.add(crewSkill5);
		
		shipIntegrity = new JLabel("");
		shipIntegrity.setIcon(new ImageIcon(TransferStage.class.getResource("/images/spaceshipNominal.png")));
		shipIntegrity.setBounds(1112, 127, 128, 128);
		managerPanel.add(shipIntegrity);
		
		hullStatus = new JLabel("Nominal");
		hullStatus.setForeground(Color.CYAN);
		hullStatus.setFont(new Font("Slider", Font.BOLD, 12));
		hullStatus.setBounds(1139, 260, 68, 14);
		managerPanel.add(hullStatus);
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
	
	public void updateManagerUI(GameData gameData){
		FuelBar.setValue(gameData.getFuel());
		FoodBar.setValue(gameData.getFood());
		WaterBar.setValue(gameData.getWater());
		PartBar.setValue(gameData.getParts());
	}
	
	private void initEventPanel(){
		setEventPanel(new EventPanel(0));
		getEventPanel().setLocation(0, 0);
		getEventPanel().setOpaque(false);
		getEventPanel().setSize(1280, 692);
		transferPane.add(getEventPanel());
	}
	
	private void initResultPanel(){
		setResultPanel(new ResolutionPanel());
		getResultPanel().setVisible(false);
		getResultPanel().setLocation(0,0);
		getResultPanel().setSize(1280,692);
		getContentPane().add(getResultPanel());
		repaint();
	}
	
	public void initResources(int fuel, int food, int water, int parts){
		if(fuel >100) FuelBar.setValue(100);
		else FuelBar.setValue(fuel);
		if(food >100) FoodBar.setValue(100);
		else FoodBar.setValue(food);
		if(water >100) WaterBar.setValue(100);
		else WaterBar.setValue(water);
		if(fuel >100) PartBar.setValue(100);
		else PartBar.setValue(parts);
	}
	
	public boolean TransferUpdate(String distance){
		
		//If event window is not active continue interplanetary transfer
		if(!getEventPanel().isEventActive() && !getResultPanel().isResolutionActive()){
			
			moveSpace(distance);
			
			if(EventTimer.isUpdate()  && !Manager) {
				event = (Math.random() < EVENT_CHANCE);
				EventTimer.setUpdate(false);
				if(event) { 
					getEventPanel().displayEventEncounter(0);
					getResultPanel().setResolutionActive(true);
					player.setPath(sp.getPath(22));
					player.play(-1);
					event = false;
				}
			}
		}else if(getResultPanel().isResolutionActive()){
			if(!eventPanel.isEventActive()) getResultPanel().DisplayResolution(eventPanel.isOutcome(),
																		  eventPanel.getResolution(),
																		  eventPanel.getCost(),
																		  eventPanel.getTypeString(true));
		}
		
		return Warp;
	}
	
	public void moveSpace(String distance){
		if(X1_pos >= 1280) X1_pos = 0;
		if(X2_pos >= 0) X2_pos = -1280;
		
		if(gameTimer.isUpdate()){
			
			checkTimeWarp();
			
			X0_temp = X0_temp + (speed*factor_0);
			X0_pos = (int) Math.round(X0_temp);
			
			X1_pos = (int) (X1_pos + speed);
			X2_pos = (int) (X2_pos + speed);
			
		
			lblSpaceFrame1.setBounds(X2_pos, 0, 1280, 720);
			lblSpaceFrame2.setBounds(X1_pos, 0, 1280, 720);
			lblBackground.setBounds(X0_pos, 0, 1920, 1080);
			
			moveSpacecraft();
			movePlanets();
			moveSatelites();
			
			textDistance.setText(distance);
			gameTimer.setUpdate(false);
			if(gameTimer2.isUpdate()) gameTimer2.setUpdate(false);
		}

	}
	
	public void movePlanets(){
		
		if(X3_pos < 1280) {
			X3_temp = (X3_temp) + (speed*factor);
			X3_pos = (int) Math.round(X3_temp);
			lblEarth.setBounds(X3_pos, 0, 362, 384);
		}else if (X4_pos < 1280) {
			X4_temp = (X4_temp) + (speed*factor_2);
			X4_pos = (int) Math.round(X4_temp);
			lblMoon.setBounds(X4_pos, 0, 362, 384);
		}
	}
	
	public void moveSatelites(){
		
		if(gameTimer2.isUpdate() && !satelite) chance = (Math.random() < SAT_CHANCE);
		//System.out.println(X5_temp);
		
		if(chance || satelite){
			if(X5_pos < 1280){
				if(X5_pos == -186) chance = (Math.random() < AST_CHANCE);
				
				satelite = true;
				X5_pos = (int) (X5_pos + speed);
				
				if(!chance)lblSatelite1.setBounds(X5_pos, Y5_pos, 186, 120);
				else lblAsteroid1.setBounds(X5_pos, Y5_pos, 120, 150);
			}else{
				chance = (Math.random() > 0.50);
				satelite = false;
				X5_pos = -186;
				shuffleSatelites();
				if(chance) Y5_pos = 125;
				else Y5_pos = 450;	
				chance = false;	
			}
		}
	}
	public void shuffleSatelites(){

			System.out.println("Switch");
			chance2 = (Math.random() < (SAT_CHANCE));
			if(chance2) {
				System.out.println("1");
				lblAsteroid1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/asteroid2sm.png")));
				lblSatelite1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/SateliteSmall.png")));
			}else{
				System.out.println("2");
				lblAsteroid1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/asteroid3sm.png")));
				lblSatelite1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/sateliteGoldSmall.png")));
			}
	}
	
	public void moveSpacecraft(){
		
		if(Warp){
			offset = oscillate(offset, offset_temp, oscillate, 25, 0.05);
		
			if(X6_pos > 800){ 
				X6_pos = (int) (X6_pos - cruise);
				X7_pos = (int) (X7_pos - cruise);
			}
			lbSpacecraft.setBounds(X6_pos, Y6_pos + offset, 255, 82);
			lblThruster.setBounds(X7_pos, Y7_pos + offset, 196, 108);
			WarpOut = true;
		}else{
			if(WarpOut){
				if(offset > 0) offset = offset - cruise;
				else if(offset < 0) offset = offset + cruise;
				else {WarpOut = false; offset_temp = 0;}
			}else{
				
				offset = oscillate(offset, offset_temp, oscillate, 2, 0.05);
			}
			
			if(X6_pos < 999){
				X6_pos = (int) (X6_pos + speed);
				X7_pos = (int) (X7_pos + cruise);				
			}
			lbSpacecraft.setBounds(X6_pos, Y6_pos + offset, 255, 82);
			lblThruster.setBounds(X7_pos, Y7_pos + offset, 196, 108);
		}
		
	}
	
	public int oscillate(int offset, double offset_temp, boolean oscillate, int limit, double scale){
		
		if(oscillate){
			offset_temp = (offset_temp + speed*scale);
			if(offset > limit) oscillate = !oscillate;
		}
		else{
			offset_temp = (offset_temp - speed*scale);
			if(offset < -limit) oscillate = !oscillate;
		}
		
		this.oscillate = oscillate;
		this.offset_temp = offset_temp;
		
		offset = (int) Math.round(offset_temp);
		
		return offset;
	}
	
	public void checkTimeWarp(){
		if(Warp){
			speed = Supercruise;
			gameTimer.getTimer().setDelay(TimeWarp);
		}else{
			speed = cruise;
			gameTimer.getTimer().setDelay(standard);
		}
	}
	
	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public EventPanel getEventPanel() {
		return eventPanel;
	}

	public void setEventPanel(EventPanel eventPanel) {
		this.eventPanel = eventPanel;
	}

	public ResolutionPanel getResultPanel() {
		return resultPanel;
	}

	public void setResultPanel(ResolutionPanel resultPanel) {
		this.resultPanel = resultPanel;
	}
}
