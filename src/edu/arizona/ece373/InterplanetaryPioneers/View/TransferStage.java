package edu.arizona.ece373.InterplanetaryPioneers.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameTimer;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.CustomPlayer;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.SongPath;

import java.awt.Component;
import javax.swing.JTextField;

public class TransferStage extends JFrame {
	
	public static boolean Debug = false;  //For debugging end game disables events
	public static int DRIVER_FACTOR = 8;
	public static double PERF_FACTOR = 4;   //Modify refresh rate to X number of ms
	
	private int windowId;
	
	private ArrayList<Integer> x_Pos; //Tracks X position of all moving objects(JLabel Icons)
	private int Y5_pos, Y6_pos, Y7_pos, Y9_pos;
	
	private boolean Warp;
	private boolean Manager;
	
	private double speed;							//Rate at which space overlays move at and base for all objects
	private double X0_temp, X3_temp, X4_temp, X8_temp, X9_temp;
	private double factor_3 = 0.075;          //Scales Earths movement
	private double factor_4 = 0.015;          //Scales Moons movement
	private double factor_8 = 0.0125;		  //Scales Jupiter movement
	private double factor_9 = 0.0025;		  //Scales Destination movement
	private double factor_0 = 0.000853;		//Scales Background Space movement
	private static final int standard = 20;			//Game timer update w/o warp
	private static final int TimeWarp = 2;			//Game timer update w/ warp
	private static final int cruise = 1;			//Pixel movement w/o warp
	private static final int Supercruise = 5;       //Pixel movement w/ warp
	private boolean satelite = false;
	private boolean chance = false;
	private boolean chance2 = false;
	private boolean oscillate = false;
	private boolean WarpOut = false;
	private Double offset = 0.0;
	private double offset_temp = 0;
	private static final double SAT_CHANCE = 0.50;
	private static final double AST_CHANCE = 0.90;
	
	public double END_SEQUENCE_DIST;
	
	
	private GameTimer spaceTimer;
	private GameTimer sateliteTimer;
	private GameTimer EventTimer;

	private JPanel transferPane;
	
	private ManagerPanel managerPanel;
	
	private JLabel lblTimeWarp;
	private JLabel lblSpaceFrame1;
	private JLabel lblSpaceFrame2;
	private JLabel lblSpacecraft;
	private JLabel lblAsteroid1;
	private JLabel lblSatelite1;
	private JLabel lblDestination;
	private JLabel lblJupiter; 
	private JLabel lblEarth; 
	private JLabel lblMoon;
	
	private Rectangle shipBounds;
	private Rectangle thrustBounds;
	
	private JLabel lblBackground;
	private JLabel lblVoyageManager;
	private JLabel lblThruster;
	private JTextField textDistance;
	private JLabel lblDistance;
	private JLabel lblMiles;
	
	private EventPanel eventPanel;
	private boolean event;
	private double EVENT_CHANCE = 0.30;
	private boolean First_Event = false;
	
	private ResolutionPanel resultPanel;
	private GameOverPanel gameOverPanel;
	
	private CustomPlayer player;
	private JLabel lblDays;
	private JTextField textDays;
	
	/**
	 * Create the frame.
	 */
	public TransferStage(boolean debug) {
		
		Debug = debug;
		
		setResizable(false);

		Warp = false;
		Manager = false;
		speed = 1;
		
		windowId = 5;
		
		x_Pos = new ArrayList<Integer>(10);
		x_Pos.add(new Integer(-1280));  // x0
		x_Pos.add(new Integer(0));      // x1
		x_Pos.add(new Integer(-1280));  // x2
		x_Pos.add(new Integer(0));      // x3
		x_Pos.add(new Integer(0));  	// x4
		x_Pos.add(new Integer(-186));   // x5
		x_Pos.add(new Integer(999));   // x6
		x_Pos.add(new Integer(1189));  // x7
		x_Pos.add(new Integer(-476));  // x8
		x_Pos.add(new Integer(-370));  // x9
		
		X0_temp = -1280;
		X3_temp = 0;
		X4_temp = -257;
		Y5_pos = 125;
		Y6_pos = 295;
		Y7_pos =  282;
		X8_temp = -476;
		X9_temp = -370; 
		Y9_pos = 100;
		
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
					getManagerPanel().setVisible(false);
				}
				if(!Warp){ 
					player.setPath(SongPath.getPath(20));
					player.play(-1);
				}else{ player.setPath(SongPath.getPath(19));
					player.play(-1);
				}
			}
		});
		
		/**
		 * Initialize All Panels
		 */
		initEventPanel();
		initManagerPanel();
		initResultPanel();
		initGameOverPanel();

		lblVoyageManager = new JLabel("Voyage Manager");
		lblVoyageManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Manager = !Manager;
				if(Warp) { 
					Warp = false; lblTimeWarp.setEnabled(Warp);
					player.setPath(SongPath.getPath(20));
					player.play(-1);
					}
				lblVoyageManager.setEnabled(Manager);
				if(Manager){
					managerPanel.updateManager(true);
					getManagerPanel().setVisible(true);
				}
				else getManagerPanel().setVisible(false);
			}
		});
		lblVoyageManager.setBounds(523, 11, 270, 32);
		transferPane.add(lblVoyageManager);
		lblVoyageManager.setEnabled(false);
		lblVoyageManager.setForeground(Color.CYAN);
		lblVoyageManager.setFont(new Font("Slider", Font.PLAIN, 32));
		//managerPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{FuelBar, FoodBar, WaterBar, PartBar, lblFuel, labelFood, lblWater, lblSpareParts, lblVoyageManager}));
		
		lblTimeWarp.setEnabled(false);
		lblTimeWarp.setForeground(new Color(0, 255, 255));
		lblTimeWarp.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTimeWarp.setBackground(new Color(255, 255, 255));
		lblTimeWarp.setBounds(565, 605, 174, 45);
		transferPane.add(lblTimeWarp);
		
		lblSpaceFrame1 = new JLabel("New label");
		lblSpaceFrame1.setIcon(new ImageIcon("lib/images/Space_MoveFrame.png"));
		lblSpaceFrame1.setBounds(x_Pos.get(1), 0, 1264, 682);
		transferPane.add(lblSpaceFrame1);
		
		lblSpaceFrame2 = new JLabel("New label");
		lblSpaceFrame2.setIcon(new ImageIcon("lib/images/Space_MoveFrame.png"));
		lblSpaceFrame2.setBounds(x_Pos.get(2), 0, 1264, 682);
		transferPane.add(lblSpaceFrame2);
		
		lblDays = new JLabel("Days in Space");
		lblDays.setForeground(Color.CYAN);
		lblDays.setFont(new Font("Slider", Font.PLAIN, 20));
		lblDays.setBounds(850, 600, 180, 26);
		transferPane.add(lblDays);
		
		textDays = new JTextField();
		textDays.setHorizontalAlignment(SwingConstants.RIGHT);
		textDays.setBorder(null);
		textDays.setOpaque(false);
		textDays.setEditable(false);
		textDays.setForeground(Color.CYAN);
		textDays.setFont(new Font("Slider", Font.PLAIN, 20));
		textDays.setBounds(850, 623, 150, 26);
		transferPane.add(textDays);
		textDays.setColumns(10);
		
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
		
		lblSpacecraft = new JLabel("");
		lblSpacecraft.setBounds(999, 295, 255, 82);
		transferPane.add(lblSpacecraft);
		lblSpacecraft.setIcon(new ImageIcon("lib/images/SpaceXModel.png"));
		
		lblThruster = new JLabel("");
		lblThruster.setBounds(1189, 282, 196, 108);
		transferPane.add(lblThruster);
		lblThruster.setIcon(new ImageIcon("lib/images/thrustSmall.png"));
		
		lblSatelite1 = new JLabel("");
		lblSatelite1.setBounds(-186, 175, 186, 83);
		transferPane.add(lblSatelite1);
		lblSatelite1.setIcon(new ImageIcon("lib/images/SateliteSmall.png"));
		
		lblAsteroid1 = new JLabel("");
		lblAsteroid1.setIcon(new ImageIcon("lib/images/asteroid2sm.png"));
		lblAsteroid1.setBounds(-240, 11, 120, 150);
		transferPane.add(lblAsteroid1);
		
		lblDestination = new JLabel("");
		lblDestination.setBounds(x_Pos.get(9), Y9_pos, 270, 284);
		lblDestination.setIcon(new ImageIcon("lib/images/MarsTransparent.png"));
		transferPane.add(lblDestination);
		
		lblJupiter = new JLabel("");
		lblJupiter.setBounds(0, 0, 476, 435);
		lblJupiter.setIcon(new ImageIcon("lib/images/JupiterTransparent.png"));
		transferPane.add(lblJupiter);
		
		lblEarth = new JLabel("Earth");
		lblEarth.setIcon(new ImageIcon("lib/images/EarthSmall.png"));
		lblEarth.setBounds(0, 0, 362, 384);
		transferPane.add(lblEarth);
		
		lblMoon = new JLabel("");
		lblMoon.setIcon(new ImageIcon("lib/images/MoonSmall.png"));
		lblMoon.setBounds(-257, 0, 257, 252);
		transferPane.add(lblMoon);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("lib/images/Deep-Space-CloudF.jpg"));
		lblBackground.setBounds(-1280, 0, 2560, 1024);
		transferPane.add(lblBackground);
		transferPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTimeWarp, lblSpaceFrame1, lblSpaceFrame2, lblBackground}));
	}
	
	/**
	 * Initialize Game Data and Timers
	 */
	public void initTransfer(){
		player = new CustomPlayer();

		spaceTimer = new GameTimer();
		sateliteTimer = new GameTimer(5000);
		EventTimer = new GameTimer(15000);
		EventTimer.getTimer().stop();
		shipBounds = new Rectangle();
		thrustBounds = new Rectangle();
		
		if(GameData.difficulty == DifficultySet.Normal) EVENT_CHANCE = EVENT_CHANCE + 0.100;
		else if(GameData.difficulty == DifficultySet.Hard) EVENT_CHANCE = EVENT_CHANCE + 0.200;
		
	}
	
	
	
	public void startup(){
		initTransfer(); 	//Initialize Game Data!
		managerPanel.ManagerSetup();
		eventPanel.initEventData();
		initSpacecraft();
		initDestination();
		ActionListener taskPerformer = new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	managerPanel.updateTimeElapsed();
		    }
		};
		Timer timeElapsed = new Timer(1000 , taskPerformer);
		timeElapsed.start();
		setVisible(true);
	}
	
	public void initSpacecraft(){
		factor_0 = 0.00043;		   //Scales Background Space movement
		factor_3 = 0.075;          //Scales Earths movement
		factor_4 = 0.015;          //Scales Moons movement
		if(GameData.spacecraft.getId() == 2){
			x_Pos.set(6, 999); Y6_pos = 295;
			x_Pos.set(7, 1189); Y7_pos =  282;
			lblSpacecraft.setIcon(new ImageIcon("lib/images/SpaceXModel.png"));
			shipBounds.setBounds(x_Pos.get(6), Y6_pos , 255, 82);
			lblThruster.setIcon(new ImageIcon("lib/images/thrustSmall.png"));
			thrustBounds.setBounds(x_Pos.get(7), Y7_pos, 196, 108);
		}else{
			x_Pos.set(6, 999); Y6_pos = 176; 
			x_Pos.set(7, 1125); Y7_pos =  282;
			lblSpacecraft.setIcon(new ImageIcon("lib/images/OrionModel.png"));
			shipBounds.setBounds(x_Pos.get(6), Y6_pos, 255, 320);
			lblThruster.setIcon(new ImageIcon("lib/images/glowEffectSmall.png"));
			thrustBounds.setBounds(x_Pos.get(7), Y7_pos, 196, 108);
			factor_0 = factor_0*1.10;
			factor_3 = factor_3*1.10;
			factor_4 = factor_4*1.10;
		}
		lblSpacecraft.setBounds(shipBounds);
		lblThruster.setBounds(thrustBounds);
	}
	
	public void initDestination(){
		GameData.destinationId = Destination.getId();
		
		if(Destination.getId() == Destination.MARS) factor_9 = 0.0125;
		
		END_SEQUENCE_DIST = Destination.getDistance() - Destination.PROXIMITY;
		lblDestination.setBounds(x_Pos.get(9), Y9_pos, 270, 284);
		lblJupiter.setBounds(x_Pos.get(8), 0, 476, 435);
		if(Destination.getId() == 1){
			lblDestination.setIcon(new ImageIcon("lib/images/MarsTransparent.png"));
			transferPane.remove(lblJupiter);
		}else{
			lblDestination.setIcon(new ImageIcon("lib/images/EuropaTransparent.png"));
			lblDestination.repaint();
			transferPane.repaint();
		}
		if(Debug) GameData.currentDistance = END_SEQUENCE_DIST - Destination.PROXIMITY;
	}
	
	public int destinationSequence(Double currentDist){
		if(currentDist >= END_SEQUENCE_DIST){
			if(currentDist < Destination.getDistance())
				return Destination.DESTINATION_APPROACH; //Final Approach
			else
				return Destination.DESTINATION_REACHED; //Destination reached game over
		}else 
			return Destination.IN_PROGRESS;  //Destination still to far
	}
	
	private void initManagerPanel() {
		managerPanel = new ManagerPanel();
		managerPanel.initResources(GameData.fuel.intValue(), 
								        GameData.food.intValue(), 
								        GameData.water.intValue(), 
								        GameData.parts.intValue());
		transferPane.add(managerPanel);
	}
	
	private void initEventPanel(){
		setEventPanel(new EventPanel());
		getEventPanel().setLocation(0, 0);
		getEventPanel().setOpaque(false);
		getEventPanel().setSize(1280, 692);
		transferPane.add(getEventPanel());
	}
	
	private void initResultPanel(){
		resultPanel = new ResolutionPanel();
		resultPanel.setVisible(false);
		resultPanel.setLocation(0,0);
		resultPanel.setSize(1280,692);
		getContentPane().add(getResultPanel());
		resultPanel.setPenaltyUpdated(false);
		repaint();
	}
	
	private void initGameOverPanel(){
		gameOverPanel = new GameOverPanel();
		gameOverPanel.setLocation(0, 0);
		gameOverPanel.setSize(1280,692);
		gameOverPanel.setVisible(false);
		transferPane.add(gameOverPanel);
	}
	
	public boolean TransferUpdate(){
		//Update GameData
		GameData.dataUpdate(Warp, eventPanel.isEventActive(), 
							resultPanel.isResolutionActive(), 
							resultPanel.isDataReady(),
							eventPanel.getResolution(),
							eventPanel.getCurrentEvent(),
							eventPanel.getCost());
		//If neither event, result, or gameover panel are active continue planetary transfer
		if(!getEventPanel().isEventActive() && !getResultPanel().isResolutionActive() && !getGameOverPanel().isGameOverActive()){
			
			//Check for game over condition
			if((destinationSequence(GameData.currentDistance) == Destination.IN_PROGRESS) && First_Event){
				if(gameOverPanel.checkGameOver(eventPanel.getCurrentEvent())){
					gameOverPanel.displayGameOver();
					gameOverPanel.setVisible(true);
					EventTimer.setUpdate(false);
				}
			}
			moveSpace();
			
			if(EventTimer.isUpdate()  && !Manager && (GameData.currentDistance > GameData.EventStartDist)
					&& (GameData.currentDistance < (Destination.getDistance()-Destination.PROXIMITY))) {
				event = (Math.random() < EVENT_CHANCE);
				System.out.println("Event occurence: " + event + " Event Chance: " + EVENT_CHANCE + " Events: " + GameData.totalEvents + " Timestamp: " + managerPanel.seconds);
				EventTimer.setUpdate(false);
				if(event) { 
					getEventPanel().displayEventEncounter();
					getResultPanel().setResolutionActive(true);
					player.setPath(SongPath.getPath(22));
					player.play(-1);
					EventTimer.getTimer().stop();
					event = false;
					First_Event = true;
				}
			}
			//Reactivate timer if necessary
			if(!EventTimer.getTimer().isRunning() && !Debug){
				EventTimer.getTimer().restart();
				EventTimer.getTimer().start();
			}else if((GameData.currentDistance > GameData.EventStartDist) && !First_Event && !Debug){
				EventTimer.getTimer().start();
			}
			
		}else if(!eventPanel.isEventActive() && !getResultPanel().isUpdated()){
				resultPanel.DisplayResolution(eventPanel.isOutcome(),
										  eventPanel.getResolution(),
										  eventPanel.getCost(),
										  eventPanel.getCurrentEvent());
			//managerPanel.updateManager(gameData, true);
			EventTimer.setUpdate(false);
		}

		if(resultPanel.isDataReady()) resultPanel.setDataReady(false);
		
		if(destinationSequence(GameData.currentDistance) == Destination.DESTINATION_REACHED)
			return true;
		else 
			return false;
	}
	
	public void moveSpace(){
		if(x_Pos.get(1) >= 1280) x_Pos.set(1, 0);
		if(x_Pos.get(2) >= 0) x_Pos.set(2, -1280);
		
		if(spaceTimer.isUpdate()){
			
			checkTimeWarp();
			
			X0_temp = X0_temp + (speed*factor_0);
 
			x_Pos.set(0, (int) Math.round(X0_temp));
			 
			x_Pos.set(1, (int) (x_Pos.get(1) + speed)); 
			x_Pos.set(2, (int) (x_Pos.get(2) + speed));
			
			lblSpaceFrame1.setLocation(x_Pos.get(2), 0);
			lblSpaceFrame2.setLocation(x_Pos.get(1), 0);
			lblBackground.setLocation(x_Pos.get(0), 0);
			
			moveSpacecraft();
			movePlanets();
			moveSatelites();
			
			textDistance.setText(Destination.distFormat.format(GameData.currentDistance));
			textDays.setText(String.format("%.2f", GameData.days));
			
			spaceTimer.setUpdate(false);
			if(sateliteTimer.isUpdate()) sateliteTimer.setUpdate(false);
		}

	}
	
	public boolean movePlanets(){
		
		if(x_Pos.get(3) < 1280) {
			X3_temp = (X3_temp) + (speed*factor_3);
			x_Pos.set(3, (int) Math.round(X3_temp));
			lblEarth.setBounds(x_Pos.get(3), 0, 362, 384);
		}else if (x_Pos.get(4) < 1280) {
			X4_temp = (X4_temp) + (speed*factor_3);
			x_Pos.set(4, (int) Math.round(X4_temp));
			lblMoon.setBounds(x_Pos.get(4), 0, 362, 384);
		}else {
			if(destinationSequence(GameData.currentDistance) == Destination.DESTINATION_APPROACH ){
				X8_temp = (X8_temp) + (speed*factor_8);
				x_Pos.set(8, (int) Math.round(X8_temp));
				X9_temp = (X9_temp) + (speed*factor_9);
				x_Pos.set(9, (int) Math.round(X9_temp));
				lblDestination.setLocation(x_Pos.get(9), Y9_pos);
				if(Destination.getId() == Destination.EUROPA) lblJupiter.setLocation(x_Pos.get(8), 0);
			}
		}
		return false;
	}
	
	public void moveSatelites(){
		
		if(sateliteTimer.isUpdate() && !satelite) chance = (Math.random() < SAT_CHANCE);
		
		if(chance || satelite){
			if(x_Pos.get(5) < 1280){
				if(x_Pos.get(5) == -186) chance = (Math.random() < AST_CHANCE);
				
				satelite = true;
				x_Pos.set(5, (int) (x_Pos.get(5) + speed));
				if(!chance)lblSatelite1.setBounds(x_Pos.get(5), Y5_pos, 186, 140);
				else lblAsteroid1.setBounds(x_Pos.get(5), Y5_pos, 120, 150);
			}else{
				chance = (Math.random() > 0.50);
				satelite = false;
				x_Pos.set(5, -186);
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
				lblAsteroid1.setIcon(new ImageIcon("lib/images/asteroid2sm.png"));
				lblSatelite1.setIcon(new ImageIcon("lib/images/SateliteSmall.png"));
			}else{
				System.out.println("2");
				lblAsteroid1.setIcon(new ImageIcon("lib/images/asteroid3sm.png"));
				lblSatelite1.setIcon(new ImageIcon("lib/images/sateliteGoldSmall.png"));
			}
	}
	
	public void moveSpacecraft(){
		
		if(Warp){
			offset = oscillate(offset.intValue(), offset_temp, oscillate, 25, 0.05)*1.0;
		
			if(x_Pos.get(6) > 800){ 
				x_Pos.set(6, (int) (x_Pos.get(6) - cruise*PERF_FACTOR));
				x_Pos.set(7, (int) (x_Pos.get(7) - cruise*PERF_FACTOR));
			}
			lblSpacecraft.setLocation(x_Pos.get(6), Y6_pos + offset.intValue());
			lblThruster.setLocation(x_Pos.get(7), Y7_pos + offset.intValue());
			WarpOut = true;
		}else{
			if(WarpOut){
				if(offset > 1.0) offset = offset - cruise*PERF_FACTOR*0.1;
				else if(offset < -1.0) offset = offset + cruise*PERF_FACTOR*0.1;
				else {WarpOut = false; offset_temp = 0.0;}
			}else{
				
				offset = oscillate(offset.intValue(), offset_temp, oscillate, 2, 0.05)*1.0;
			}
			
			if(x_Pos.get(6) < 999){
				x_Pos.set(6, (int) (x_Pos.get(6) + speed*0.5));
				x_Pos.set(7, (int) (x_Pos.get(7) + speed*0.5));
			}
			lblSpacecraft.setLocation(x_Pos.get(6), Y6_pos + offset.intValue());
			lblThruster.setLocation(x_Pos.get(7), Y7_pos + offset.intValue());
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
			speed = Supercruise*PERF_FACTOR;
			spaceTimer.getTimer().setDelay(TimeWarp);
		}else{
			speed = cruise*PERF_FACTOR;
			spaceTimer.getTimer().setDelay(standard);
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

	public ManagerPanel getManagerPanel() {
		return managerPanel;
	}

	public void setManagerPanel(ManagerPanel managerPanel) {
		this.managerPanel = managerPanel;
	}

	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}

	public void setGameOverPanel(GameOverPanel gameOverPanel) {
		this.gameOverPanel = gameOverPanel;
	}
}
