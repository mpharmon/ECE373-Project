package gameWindow;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JProgressBar;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.math.*;
import javax.swing.JTextArea;
import java.lang.Object.*;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SupplyStage extends JFrame {

	
	private int windowId;
	private JPanel contentPane;
	
	private boolean Confirm;
	
	private float Resources;
	private int Fuel;
	private int Food;
	private int H2O;
	private int Parts;
	private float MAX_SUPPLIES = 400;
	private final static float  w1 = (float) 1;
	private final static float  w2 = (float) 1;
	private final static float  w3 = (float) 1;
	private final static float  w4 = (float) 1;
	
	JSlider Fuel_Slider;
	JSlider Food_Slider;
	JSlider H2O_Slider;
	JSlider Parts_Slider;
	JProgressBar progressBar;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyStage frame = new SupplyStage();
					frame.setVisible(true);
					//frame.updateProgress();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SupplyStage() {
		
		windowId = 4;
		Confirm = false;
		Fuel = 100;
		Food = 100;
		H2O = 100;
		Parts = 100;
		Resources = 400;
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SupplyStage.class.getResource("/images/Fuel_Icon_small.png")));
		lblNewLabel.setBounds(135, 149, 151, 164);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SupplyStage.class.getResource("/images/water_icon_sm.png")));
		lblNewLabel_1.setBounds(729, 173, 118, 116);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(SupplyStage.class.getResource("/images/food_icon_sm2.png")));
		lblNewLabel_2.setBounds(421, 161, 151, 140);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(SupplyStage.class.getResource("/images/Parts_icon_sm_r.png")));
		lblNewLabel_3.setBounds(986, 149, 151, 140);
		contentPane.add(lblNewLabel_3);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Confirm = true;
			}
		});
		btnConfirm.setBackground(Color.CYAN);
		btnConfirm.setFont(new Font("Slider", Font.PLAIN, 22));
		btnConfirm.setBounds(553, 598, 187, 50);
		contentPane.add(btnConfirm);

		JLabel lblBackground = new JLabel("Background");
		lblBackground.setForeground(new Color(255, 255, 255));
		lblBackground.setFont(new Font("Slider", Font.PLAIN, 18));
		lblBackground.setIcon(new ImageIcon(SupplyStage.class.getResource("/images/hud_bg_full.jpg")));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);

	}
	
	public void updateProgress(){
		int result = 0;
		Resources = Fuel*w1 + Food*w2 + H2O*w3 + Parts*w4;
		result = Math.round((Resources/MAX_SUPPLIES)*100);
		if(Resources > MAX_SUPPLIES){
			textArea.setForeground(Color.RED);
			textArea.setText("Insufficient Resources " + (MAX_SUPPLIES - Resources));
		}else {
			textArea.setForeground(Color.GREEN);
			textArea.setText("Available Resources " + (MAX_SUPPLIES - Resources));
		}
		sliderHandler();
		//System.out.println(Resources);
		//System.out.println(result);
		progressBar.setValue(result);
	}
	
	public void sliderHandler(){
		if(Fuel < 25 ) Fuel_Slider.setBorder(new LineBorder(Color.RED, 2, true));
		else if(Fuel < 50) Fuel_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
		else Fuel_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
		
		if(Food < 75 ) Food_Slider.setBorder(new LineBorder(Color.RED, 2, true));
		else if(Food < 100) Food_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
		else Food_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
		
		if(H2O < 75 ) H2O_Slider.setBorder(new LineBorder(Color.RED, 2, true));
		else if(H2O < 100) H2O_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
		else H2O_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
		
		if(Parts < 25 ) Parts_Slider.setBorder(new LineBorder(Color.RED, 2, true));
		else if(Parts < 50) Parts_Slider.setBorder(new LineBorder(Color.YELLOW, 2, true));
		else Parts_Slider.setBorder(new LineBorder(Color.GREEN, 2, true));
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
}
