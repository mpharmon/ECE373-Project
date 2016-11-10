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
import java.awt.Component;

public class TransferStage extends JFrame {
	
	private int windowId;
	private int X1_pos, X2_pos, X3_pos, X4_pos;
	private boolean Warp;
	private double speed;
	private double X3_temp, X4_temp;
	private final double factor = 0.075;
	private final double factor_2 = 0.015;
	private static final int standard = 10;
	private static final int TimeWarp = 2;
	private static final int cruise = 1;
	private static final int Supercruise = 5;
	private GameTimer gameTimer;

	private JPanel contentPane;
	private JLabel lblTimeWarp;
	private JLabel lblSpaceFrame1;
	private JLabel lblSpaceFrame2;
	private JLabel lblEarth; 
	private JLabel lblMoon;
	
	/**
	 * Create the frame.
	 */
	public TransferStage() {
		
		gameTimer = new GameTimer();
		Warp = false;
		speed = 1;
		
		windowId = 5;
		X1_pos = 0;
		X2_pos = -1280;
		
		X3_pos = 0; X3_temp = 0;
		X4_pos = 0; X4_temp = -257;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTimeWarp = new JLabel("Time Warp");
		lblTimeWarp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Warp = !Warp; //Toggle Warp
				lblTimeWarp.setEnabled(Warp);
			}
		});
		lblTimeWarp.setEnabled(false);
		lblTimeWarp.setForeground(new Color(0, 255, 255));
		lblTimeWarp.setFont(new Font("Slider", Font.PLAIN, 32));
		lblTimeWarp.setBackground(new Color(255, 255, 255));
		lblTimeWarp.setBounds(565, 605, 174, 45);
		contentPane.add(lblTimeWarp);
		
		lblSpaceFrame1 = new JLabel("New label");
		lblSpaceFrame1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame1.setBounds(X1_pos, 0, 1264, 682);
		contentPane.add(lblSpaceFrame1);
		
		lblSpaceFrame2 = new JLabel("New label");
		lblSpaceFrame2.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame2.setBounds(X2_pos, 0, 1264, 682);
		contentPane.add(lblSpaceFrame2);
		
		lblEarth = new JLabel("Earth");
		lblEarth.setIcon(new ImageIcon(TransferStage.class.getResource("/images/EarthSmall.png")));
		lblEarth.setBounds(0, 0, 362, 384);
		contentPane.add(lblEarth);
		
		lblMoon = new JLabel("");
		lblMoon.setIcon(new ImageIcon(TransferStage.class.getResource("/images/MoonSmall.png")));
		lblMoon.setBounds(-257, 0, 257, 252);
		contentPane.add(lblMoon);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Nebula_2T.jpg")));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblTimeWarp, lblSpaceFrame1, lblSpaceFrame2, lblBackground}));
	}
	
	public void moveSpace(){
		if(X1_pos >= 1280) X1_pos = 0;
		if(X2_pos >= 0) X2_pos = -1280;
		
		if(gameTimer.isUpdate()){
			
			checkTimeWarp();
			
			X1_pos = (int) (X1_pos + speed);
			X2_pos = (int) (X2_pos + speed);
			
		
			lblSpaceFrame1.setBounds(X2_pos, 0, 1280, 720);
			lblSpaceFrame2.setBounds(X1_pos, 0, 1280, 720);
			
			movePlanets();
			
			gameTimer.setUpdate(false);
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
	
	public void moveSpace(int rate){
		
		int speed = standard;
		
		if(rate == 2) speed = cruise;
		else if(rate == 3) speed = Supercruise;	
		
		if(X1_pos >= 1280) X1_pos = 0;
		if(X2_pos >= 0) X2_pos = -1280;
		
		if(gameTimer.isUpdate()){
			X1_pos = X1_pos + speed;
			X2_pos = X2_pos + speed;
		
			lblSpaceFrame1.setBounds(X2_pos, 0, 1280, 720);
			lblSpaceFrame2.setBounds(X1_pos, 0, 1280, 720);
			
			gameTimer.setUpdate(false);
		}
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
