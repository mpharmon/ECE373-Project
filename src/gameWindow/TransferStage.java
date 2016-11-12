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

import gameExecution.GameTimer;

import java.awt.Component;

public class TransferStage extends JFrame {
	
	private int windowId;
	private int X0_pos, X1_pos, X2_pos, X3_pos, X4_pos, X5_pos, X6_pos;
	private int Y5_pos, Y6_pos;
	
	private boolean Warp;
	private boolean Manager;
	
	private double speed;
	private double X0_temp, X3_temp, X4_temp;
	private final double factor = 0.075;
	private final double factor_2 = 0.015;
	private final double factor_0 = 0.0005;
	private static final int standard = 10;
	private static final int TimeWarp = 2;
	private static final int cruise = 1;
	private static final int Supercruise = 5;
	private boolean satelite = false;
	private boolean chance = false;
	private boolean oscillate = false;
	private boolean WarpOut = false;
	private int offset = 0;
	private double offset_temp = 0;
	private static final double SAT_CHANCE = 0.50;
	private static final double AST_CHANCE = 0.90;
	
	private GameTimer gameTimer;
	private GameTimer gameTimer2;

	private JPanel transferPane;
	private JPanel managerPanel;
	private JLabel lblTimeWarp;
	private JLabel lblSpaceFrame1;
	private JLabel lblSpaceFrame2;
	private JLabel lbSpacecraft;
	private JLabel lblAsteroid;
	private JLabel lblSatelite;
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
	
	/**
	 * Create the frame.
	 */
	public TransferStage() {
		
		gameTimer = new GameTimer();
		gameTimer2 = new GameTimer(5000);
		
		Warp = false;
		Manager = false;
		speed = 1;
		
		windowId = 5;
		X0_pos = -656; X0_temp = -656;
		X1_pos = 0;
		X2_pos = -1280;
		
		X3_pos = 0;    X3_temp = 0;
		X4_pos = 0;    X4_temp = -257;
		X5_pos = -186; Y5_pos = 175;
		X6_pos = 999;  Y6_pos = 295;
		
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
				if(!Manager){
					Warp = !Warp; //Toggle Warp
					lblTimeWarp.setEnabled(Warp);
				}
			}
		});
		/**
		 * Manager Panel
		 */
		initManagerPanel();
		
		lblVoyageManager = new JLabel("Voyage Manager");
		lblVoyageManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Manager = !Manager;
				if(Warp) { Warp = false; lblTimeWarp.setEnabled(Warp);}
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
		
		lbSpacecraft = new JLabel("");
		lbSpacecraft.setBounds(999, 295, 255, 82);
		transferPane.add(lbSpacecraft);
		lbSpacecraft.setIcon(new ImageIcon(TransferStage.class.getResource("/images/SpaceXModel.png")));
		
		lblSatelite = new JLabel("");
		lblSatelite.setBounds(-186, 175, 186, 83);
		transferPane.add(lblSatelite);
		lblSatelite.setIcon(new ImageIcon(TransferStage.class.getResource("/images/SateliteSmall.png")));
		
		lblAsteroid = new JLabel("");
		lblAsteroid.setIcon(new ImageIcon(TransferStage.class.getResource("/images/asteroid2sm.png")));
		lblAsteroid.setBounds(-240, 11, 120, 99);
		transferPane.add(lblAsteroid);
		
		lblEarth = new JLabel("Earth");
		lblEarth.setIcon(new ImageIcon(TransferStage.class.getResource("/images/EarthSmall.png")));
		lblEarth.setBounds(0, 0, 362, 384);
		transferPane.add(lblEarth);
		
		lblMoon = new JLabel("");
		lblMoon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/MoonSmall.png")));
		lblMoon.setBounds(-257, 0, 257, 252);
		transferPane.add(lblMoon);
		
		lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Nebula_2.jpg")));
		lblBackground.setBounds(-656, 0, 1970, 1080);
		transferPane.add(lblBackground);
		transferPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTimeWarp, lblSpaceFrame1, lblSpaceFrame2, lblBackground}));
	}
	
	private void initManagerPanel() {
			
		managerPanel = new JPanel();
		managerPanel.setBounds(0, 0, 1264, 682);
		transferPane.add(managerPanel);
		managerPanel.setOpaque(false);
		managerPanel.setVisible(false);
		managerPanel.setLayout(null);
		
		FuelBar = new JProgressBar();
		FuelBar.setBounds(130, 152, 375, 22);
		managerPanel.add(FuelBar);
		
		FoodBar = new JProgressBar();
		FoodBar.setBounds(130, 237, 375, 22);
		managerPanel.add(FoodBar);
		
		WaterBar = new JProgressBar();
		WaterBar.setBounds(130, 327, 375, 22);
		managerPanel.add(WaterBar);
		
		PartBar = new JProgressBar();
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
	}
	
	public void moveSpace(){
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
			lblBackground.setBounds(X0_pos, 0, 1970, 1080);
			
			moveSpacecraft();
			movePlanets();
			moveSatelites();
			
			
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
				
				if(!chance)lblSatelite.setBounds(X5_pos, Y5_pos, 186, 83);
				else lblAsteroid.setBounds(X5_pos, Y5_pos, 120, 99);
			}else{
				chance = (Math.random() > 0.50);
				satelite = false;
				X5_pos = -186;
				if(chance) Y5_pos = 175;
				else Y5_pos = 450;	
				chance = false;	
			}
		}
	}
	
	public void moveSpacecraft(){
		
		if(Warp){
			offset = oscillate(offset, offset_temp, oscillate, 25, 0.05);
		
			if(X6_pos > 800) X6_pos = (int) (X6_pos - cruise);
			lbSpacecraft.setBounds(X6_pos, Y6_pos + offset, 255, 82);
			WarpOut = true;
		}else{
			if(WarpOut){
				if(offset > 0) offset = offset - cruise;
				else if(offset < 0) offset = offset + cruise;
				else {WarpOut = false; offset_temp = 0;}
			}else{
				
				offset = oscillate(offset, offset_temp, oscillate, 2, 0.05);
			}
			
			if(X6_pos < 999) X6_pos = (int) (X6_pos + speed);
			lbSpacecraft.setBounds(X6_pos, Y6_pos + offset, 255, 82);
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
}
