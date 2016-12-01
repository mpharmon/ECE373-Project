package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Person;
import javax.swing.JProgressBar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SupplyStage extends JFrame {
	private int windowId;
	private JPanel contentPane;
	
	private boolean Confirm;
	private JButton btnConfirm;
	
	private float Resources;
	private int Fuel;
	private int Food;
	private int H2O;
	private int Parts;
	private float MAX_SUPPLIES = 1000;
	private final static float  w1 = (float) 4;
	private final static float  w2 = (float) 1;
	private final static float  w3 = (float) 1;
	private final static float  w4 = (float) 4;
	
	JSlider Fuel_Slider;
	JSlider Food_Slider;
	JSlider H2O_Slider;
	JSlider Parts_Slider;
	JLabel lblFuelStatus;
	JLabel lblFoodStatus;
	JLabel lblWaterStatus;
	JLabel lblPartStatus;
	JProgressBar progressBar;
	private int result = 0;
	JTextArea textArea;

	public SupplyStage() {
		
		windowId = 4;
		Confirm = false;
		Fuel = 100;
		Food = 100;
		H2O = 100;
		Parts = 100;
		Resources = 1000;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblSelectSupples = new JLabel("SELECT SUPPLES");
		lblSelectSupples.setBackground(Color.WHITE);
		lblSelectSupples.setForeground(Color.CYAN);
		lblSelectSupples.setFont(new Font("Slider", Font.PLAIN, 32));
		lblSelectSupples.setBounds(503, 11, 285, 36);
		contentPane.add(lblSelectSupples);
		/**
		 * Fuel Slider
		 */
		Fuel_Slider = new JSlider();
		Fuel_Slider.setToolTipText("Minimum is 25 units for planetary transfer. \r\nAdditional fuel is required for course corrections.");
		Fuel_Slider.setBorder(new LineBorder(new Color(0, 255, 0), 2, true));
		Fuel_Slider.setSnapToTicks(true);
		Fuel_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Fuel = Fuel_Slider.getValue();
			}
		});
		
		Fuel_Slider.setFont(new Font("Slider", Font.PLAIN, 14));
		Fuel_Slider.setForeground(new Color(255, 255, 255));
		Fuel_Slider.setMaximum(150);
		Fuel_Slider.setPaintLabels(true);
		Fuel_Slider.setPaintTicks(true);
		Fuel_Slider.setMajorTickSpacing(25);
		Fuel_Slider.setMinorTickSpacing(5);
		Fuel_Slider.setValue(100);
		Fuel_Slider.setBackground(new Color(0, 191, 255));
		Fuel_Slider.setBounds(88, 324, 246, 45);
		contentPane.add(Fuel_Slider);
		/**
		 * Food Slider
		 */
		Food_Slider = new JSlider();
		Food_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Food = Food_Slider.getValue();
			}
		});
		Food_Slider.setFont(new Font("Slider", Font.PLAIN, 14));
		Food_Slider.setValue(100);
		Food_Slider.setPaintTicks(true);
		Food_Slider.setPaintLabels(true);
		Food_Slider.setMinorTickSpacing(5);
		Food_Slider.setMaximum(150);
		Food_Slider.setMajorTickSpacing(25);
		Food_Slider.setForeground(Color.WHITE);
		Food_Slider.setBackground(new Color(0, 191, 255));
		Food_Slider.setBounds(377, 324, 246, 45);
		contentPane.add(Food_Slider);
		/**
		 * Parts Slider
		 */
		Parts_Slider = new JSlider();
		Parts_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Parts = Parts_Slider.getValue();
			}
		});
		Parts_Slider.setFont(new Font("Slider", Font.PLAIN, 14));
		Parts_Slider.setValue(100);
		Parts_Slider.setPaintTicks(true);
		Parts_Slider.setPaintLabels(true);
		Parts_Slider.setMinorTickSpacing(5);
		Parts_Slider.setMaximum(150);
		Parts_Slider.setMajorTickSpacing(25);
		Parts_Slider.setForeground(Color.WHITE);
		Parts_Slider.setBackground(new Color(0, 191, 255));
		Parts_Slider.setBounds(951, 324, 246, 45);
		contentPane.add(Parts_Slider);
		/**
		 * H2O Slider
		 */
		H2O_Slider = new JSlider();
		H2O_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				H2O = H2O_Slider.getValue();
			}
		});
		H2O_Slider.setFont(new Font("Slider", Font.PLAIN, 14));
		H2O_Slider.setValue(100);
		H2O_Slider.setPaintTicks(true);
		H2O_Slider.setPaintLabels(true);
		H2O_Slider.setMinorTickSpacing(5);
		H2O_Slider.setMaximum(150);
		H2O_Slider.setMajorTickSpacing(25);
		H2O_Slider.setForeground(Color.WHITE);
		H2O_Slider.setBackground(new Color(0, 191, 255));
		H2O_Slider.setBounds(667, 324, 246, 45);
		contentPane.add(H2O_Slider);
		
		/**
			Progress Bar
		*/
		progressBar = new JProgressBar();
		progressBar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
	
			}
		});
		progressBar.setBounds(377, 509, 536, 36);
		contentPane.add(progressBar);
		/**
		 * Slider Labels
		 */
		JLabel lblFuel = new JLabel("FUEL RESERVES");
		lblFuel.setForeground(Color.WHITE);
		lblFuel.setFont(new Font("Slider", Font.PLAIN, 18));
		lblFuel.setBounds(146, 380, 157, 22);
		contentPane.add(lblFuel);
		
		JLabel lblFood = new JLabel("FOOD RESERVES");
		lblFood.setForeground(Color.WHITE);
		lblFood.setFont(new Font("Slider", Font.PLAIN, 18));
		lblFood.setBounds(421, 380, 187, 22);
		contentPane.add(lblFood);
		
		JLabel lblH2O = new JLabel("WATER RESERVES");
		lblH2O.setForeground(Color.WHITE);
		lblH2O.setFont(new Font("Slider", Font.PLAIN, 18));
		lblH2O.setBounds(696, 380, 187, 22);
		contentPane.add(lblH2O);
		
		JLabel lblParts = new JLabel("SPARE PARTS");
		lblParts.setForeground(Color.WHITE);
		lblParts.setFont(new Font("Slider", Font.PLAIN, 18));
		lblParts.setBounds(1005, 380, 132, 22);
		contentPane.add(lblParts);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setFont(new Font("Slider", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(533, 554, 242, 22);
		contentPane.add(textArea);
		
		JLabel lblFuelIcon = new JLabel("New label");
		lblFuelIcon.setIcon(new ImageIcon("lib/images/Fuel_Icon_small.png"));
		lblFuelIcon.setBounds(135, 149, 151, 164);
		contentPane.add(lblFuelIcon);
		
		JLabel lblWaterIcon = new JLabel("New label");
		lblWaterIcon.setIcon(new ImageIcon("lib/images/water_icon_sm.png"));
		lblWaterIcon.setBounds(729, 173, 118, 116);
		contentPane.add(lblWaterIcon);
		
		JLabel lblFoodIcon = new JLabel("New label");
		lblFoodIcon.setIcon(new ImageIcon("lib/images/food_icon_sm2.png"));
		lblFoodIcon.setBounds(421, 161, 151, 140);
		contentPane.add(lblFoodIcon);
		
		JLabel lblPartsIcon = new JLabel("New label");
		lblPartsIcon.setIcon(new ImageIcon("lib/images/Parts_icon_sm_r.png"));
		lblPartsIcon.setBounds(986, 149, 151, 140);
		contentPane.add(lblPartsIcon);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setToolTipText("All supplies must have meet the minimum amount.");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnConfirm.isEnabled())
					Confirm = true;
			}
		});
		btnConfirm.setBackground(Color.CYAN);
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 22));
		btnConfirm.setBounds(553, 598, 187, 50);
		contentPane.add(btnConfirm);
		
		/**
		 * Resource Status Labels
		 */
		
		lblFuelStatus = new JLabel("Sufficient");
		lblFuelStatus.setFont(new Font("Slider", Font.PLAIN, 16));
		lblFuelStatus.setForeground(Color.GREEN);
		lblFuelStatus.setBackground(Color.WHITE);
		lblFuelStatus.setBounds(172, 400, 108, 22);
		contentPane.add(lblFuelStatus);
		
		lblFoodStatus = new JLabel("Sufficient");
		lblFoodStatus.setForeground(Color.GREEN);
		lblFoodStatus.setFont(new Font("Slider", Font.PLAIN, 16));
		lblFoodStatus.setBackground(Color.WHITE);
		lblFoodStatus.setBounds(453, 400, 108, 22);
		contentPane.add(lblFoodStatus);
		
		lblWaterStatus = new JLabel("Sufficient");
		lblWaterStatus.setForeground(Color.GREEN);
		lblWaterStatus.setFont(new Font("Slider", Font.PLAIN, 16));
		lblWaterStatus.setBackground(Color.WHITE);
		lblWaterStatus.setBounds(739, 400, 108, 22);
		contentPane.add(lblWaterStatus);
		
		lblPartStatus = new JLabel("Sufficient");
		lblPartStatus.setForeground(Color.GREEN);
		lblPartStatus.setFont(new Font("Slider", Font.PLAIN, 16));
		lblPartStatus.setBackground(Color.WHITE);
		lblPartStatus.setBounds(1029, 400, 108, 22);
		contentPane.add(lblPartStatus);

		JLabel lblBackground = new JLabel("Background");
		lblBackground.setForeground(new Color(255, 255, 255));
		lblBackground.setFont(new Font("Slider", Font.PLAIN, 18));
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);

	}
	
	public void updateProgress(int vipID){
		Double temp = new Double(0);
		
		Resources = Fuel*w1 + Food*w2 + H2O*w3 + Parts*w4;
		if(vipID == Person.Trump){
			temp = (Resources/(MAX_SUPPLIES*1.05))*100;
			result = temp.intValue();
			if(Resources > (MAX_SUPPLIES*1.05)){
				textArea.setForeground(Color.RED);
				textArea.setText("Insufficient Resources " + (MAX_SUPPLIES*1.05 - Resources));
				btnConfirm.setEnabled(false);
			}else {
				textArea.setForeground(Color.GREEN);
				textArea.setText("Available Resources " + (MAX_SUPPLIES*1.05 - Resources));
				if((Fuel>= 25) && (Parts >= 25) && (H2O >= 50) && (Food >= 50))
					btnConfirm.setEnabled(true);
				else{
					btnConfirm.setEnabled(false);
				}
			}
		}else{
			result = Math.round((Resources/MAX_SUPPLIES)*100);
			if(Resources > MAX_SUPPLIES){
				textArea.setForeground(Color.RED);
				textArea.setText("Insufficient Resources " + (MAX_SUPPLIES - Resources));
				btnConfirm.setEnabled(false);
			}else {
				textArea.setForeground(Color.GREEN);
				textArea.setText("Available Resources " + (MAX_SUPPLIES - Resources));
				if((Fuel>= 25) && (Parts >= 25) && (H2O >= 50) && (Food >= 50))
					btnConfirm.setEnabled(true);
				else{
					btnConfirm.setEnabled(false);
				}
			}
		}
		sliderHandler();
		//System.out.println(Resources);
		//System.out.println(result);
		progressBar.setValue(result);
	}
	
	public void sliderHandler(){
		
		if(Fuel < 25 ){ 
			Fuel_Slider.setBorder(new LineBorder(Color.RED, 2, true)); 
			lblFuelStatus.setForeground(Color.RED);
			lblFuelStatus.setText("Insufficient");
		}else if(Fuel < 50){
			Fuel_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
			lblFuelStatus.setForeground(Color.YELLOW);
			lblFuelStatus.setText("Minimum");
		}else{ 
			Fuel_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
			lblFuelStatus.setForeground(Color.GREEN);
			lblFuelStatus.setText("Sufficient");
		}
		if(Food < 50 ){ 
			Food_Slider.setBorder(new LineBorder(Color.RED, 2, true));
			lblFoodStatus.setForeground(Color.RED);
			lblFoodStatus.setText("Insufficient");
		}else if(Food < 100){ 
			Food_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
			lblFoodStatus.setForeground(Color.YELLOW);
			lblFoodStatus.setText("Minimum");
		}else{ 
			Food_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
			lblFoodStatus.setForeground(Color.GREEN);
			lblFoodStatus.setText("Sufficient");
		}
		if(H2O < 50 ){ 
			H2O_Slider.setBorder(new LineBorder(Color.RED, 2, true));
			lblWaterStatus.setForeground(Color.RED);
			lblWaterStatus.setText("Insufficient");
		}else if(H2O < 100){
			H2O_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
			lblWaterStatus.setForeground(Color.YELLOW);
			lblWaterStatus.setText("Minimum");
		}else{ 
			H2O_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
			lblWaterStatus.setForeground(Color.GREEN);
			lblWaterStatus.setText("Sufficient");
		}
		if(Parts < 25 ){ 
			Parts_Slider.setBorder(new LineBorder(Color.RED, 2, true));
			lblPartStatus.setForeground(Color.RED);
			lblPartStatus.setText("Insufficient");
		}else if(Parts < 50){ 
			Parts_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
			lblPartStatus.setForeground(Color.YELLOW);
			lblPartStatus.setText("Minimum");
		}else{
			Parts_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
			lblPartStatus.setForeground(Color.GREEN);
			lblPartStatus.setText("Sufficient");
		}
	}
	
	public void setResources(){
		if(GameData.difficulty == DifficultySet.Easy){
			MAX_SUPPLIES = 1000;
			Resources = 1000;
			Fuel = 100;
			Food = 100;
			H2O = 100;
			Parts = 100;
		}else if(GameData.difficulty == DifficultySet.Normal){
			MAX_SUPPLIES = 800;
			Resources = 800;
			Fuel = 100;
			Food = 100;
			H2O = 100;
			Parts = 50;
		}else{
			MAX_SUPPLIES = 600;
			Resources = 600;
			Fuel = 50;
			Food = 100;
			H2O = 100;
			Parts = 50;
		}
		Fuel_Slider.setValue(Fuel);
		Food_Slider.setValue(Food);
		H2O_Slider.setValue(H2O);
		Parts_Slider.setValue(Parts);
		updateProgress(GameData.vipID);
	}
	
	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public int checkButtons() {	
		if(Confirm) return 1;
		else return 0;
	}
	
	public int getFuel(){
		return Fuel;
	}
	
	public int getFood(){
		return Food;
	}
	
	public int getWater(){
		return H2O;
	}
	
	public int getParts(){
		return Parts;
	}
}
