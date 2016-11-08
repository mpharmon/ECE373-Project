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


public class SupplyStage extends JFrame {

	
	private int windowId = 3;
	private JPanel contentPane;
	
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
		
		JSlider Fuel_slider = new JSlider();
		Fuel_slider.setSnapToTicks(true);
		Fuel_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Fuel = Fuel_slider.getValue();
				//Resources = Fuel + Food + H2O + Parts;
				//System.out.println(Fuel);
			}
		});
		
		JLabel lblSelectSupples = new JLabel("SELECT SUPPLES");
		lblSelectSupples.setForeground(Color.WHITE);
		lblSelectSupples.setFont(new Font("Slider", Font.PLAIN, 32));
		lblSelectSupples.setBounds(503, 11, 285, 36);
		contentPane.add(lblSelectSupples);
		
		Fuel_slider.setFont(new Font("Slider", Font.PLAIN, 11));
		Fuel_slider.setForeground(new Color(255, 255, 255));
		Fuel_slider.setMaximum(150);
		Fuel_slider.setPaintLabels(true);
		Fuel_slider.setPaintTicks(true);
		Fuel_slider.setMajorTickSpacing(25);
		Fuel_slider.setMinorTickSpacing(5);
		Fuel_slider.setValue(100);
		Fuel_slider.setBackground(new Color(0, 191, 255));
		Fuel_slider.setBounds(88, 324, 246, 45);
		contentPane.add(Fuel_slider);
		
		JSlider Food_Slider = new JSlider();
		Food_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Food = Food_Slider.getValue();
			}
		});
		Food_Slider.setFont(new Font("Slider", Font.PLAIN, 11));
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
		
		JSlider Parts_Slider = new JSlider();
		Parts_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Parts = Parts_Slider.getValue();
			}
		});
		Parts_Slider.setFont(new Font("Slider", Font.PLAIN, 11));
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
		
		JSlider H2O_Slider = new JSlider();
		H2O_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				H2O = H2O_Slider.getValue();
			}
		});
		H2O_Slider.setFont(new Font("Slider", Font.PLAIN, 11));
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
		progressBar.setBounds(503, 494, 300, 36);
		contentPane.add(progressBar);
		
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
		textArea.setBounds(533, 541, 242, 22);
		contentPane.add(textArea);

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
		//System.out.println(Resources);
		//System.out.println(result);
		progressBar.setValue(result);
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
}
