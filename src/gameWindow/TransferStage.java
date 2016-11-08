package gameWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TransferStage extends JFrame {
	
	private int windowId;
	private int X1_pos, X2_pos;
	private static final int standard = 1;
	private static final int cruise = 2;
	private static final int Supercruise = 5;
	

	private JPanel contentPane;
	JLabel lblSpaceFrame1;
	JLabel lblSpaceFrame2;
	
	/**
	 * Create the frame.
	 */
	public TransferStage() {
		
		windowId = 5;
		X1_pos = 0;
		X2_pos = -1280;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSpaceFrame1 = new JLabel("New label");
		lblSpaceFrame1.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame1.setBounds(X1_pos, 0, 1264, 682);
		contentPane.add(lblSpaceFrame1);
		
		lblSpaceFrame2 = new JLabel("New label");
		lblSpaceFrame2.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Space_MoveFrame.png")));
		lblSpaceFrame2.setBounds(X2_pos, 0, 1264, 682);
		contentPane.add(lblSpaceFrame2);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon(TransferStage.class.getResource("/images/Nebula_2T.jpg")));
		lblBackground.setBounds(0, 0, 1264, 682);
		contentPane.add(lblBackground);
	}
	
	public void moveSpace(){
		if(X1_pos > 1280) X1_pos = 0;
		if(X2_pos >= 0) X2_pos = -1280;
		X1_pos = X1_pos + standard;
		X2_pos = X2_pos + standard;
		
		lblSpaceFrame1.setBounds(X2_pos, 0, 1264, 682);
		lblSpaceFrame2.setBounds(X1_pos, 0, 1264, 682);
	}
	
	public void moveSpace(int rate){
		
		int speed = standard;
		
		if(rate == 2) speed = cruise;
		else if(rate == 3) speed = Supercruise;	
		
		if(X1_pos >= 1280) X1_pos = 0;
		if(X2_pos >= 0) X2_pos = -1280;
		X1_pos = X1_pos + speed;
		X2_pos = X2_pos + speed;
		
		lblSpaceFrame1.setBounds(X2_pos, 0, 1280, 720);
		lblSpaceFrame2.setBounds(X1_pos, 0, 1280, 720);
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

}
