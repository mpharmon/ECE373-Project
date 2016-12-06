package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Spaceship;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PreparationStage extends JFrame {

	private boolean proceedBtn;
	private JPanel contentPane;
	private final ButtonGroup Planet_buttonGroup = new ButtonGroup();
	private final ButtonGroup Spacecraft_buttonGroup = new ButtonGroup();
	private int windowId;

	JRadioButton rdbtnMars;
	JRadioButton rdbtnEuropa;
	
	JRadioButton rdbtnOrion;
	JRadioButton rdbtnSpaceX;

	/**
	 * Create the frame.
	 */
	public PreparationStage() {

		proceedBtn = false;
		setWindowId(2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Preparation Stage");
		lblTitle.setForeground(new Color(0, 255, 255));
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 34));
		lblTitle.setBounds(513, 11, 364, 42);
		contentPane.add(lblTitle);

		JLabel lblMarsimage = new JLabel("Mars");
		lblMarsimage.setIcon(new ImageIcon("lib/images/mars.jpg"));
		lblMarsimage.setBounds(25, 101, 225, 230);
		contentPane.add(lblMarsimage);

		JLabel lblEuropaimage = new JLabel("Europa");
		lblEuropaimage.setToolTipText("\r\n");
		lblEuropaimage.setLabelFor(lblEuropaimage);
		lblEuropaimage.setIcon(new ImageIcon("lib/images/Europa_2.jpg"));
		lblEuropaimage.setBounds(25, 368, 225, 216);
		contentPane.add(lblEuropaimage);

		rdbtnMars = new JRadioButton("Mars");
		rdbtnMars.setForeground(new Color(255, 255, 255));
		rdbtnMars.setOpaque(false);
		rdbtnMars.setSelected(true);
		Planet_buttonGroup.add(rdbtnMars);
		rdbtnMars.setFont(new Font("Slider", Font.PLAIN, 18));
		rdbtnMars.setBounds(89, 338, 109, 23);
		contentPane.add(rdbtnMars);

		rdbtnEuropa = new JRadioButton("Europa");
		rdbtnEuropa.setForeground(new Color(255, 255, 255));
		rdbtnEuropa.setOpaque(false);
		rdbtnEuropa.setSelected(false);
		Planet_buttonGroup.add(rdbtnEuropa);
		rdbtnEuropa.setFont(new Font("Slider", Font.PLAIN, 18));
		rdbtnEuropa.setBounds(89, 591, 109, 23);
		contentPane.add(rdbtnEuropa);

		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBackground(new Color(0, 255, 255));
		btnProceed.setFont(new Font("Slider", Font.PLAIN, 18));
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Planet_buttonGroup.getSelection().isSelected()
						&& Spacecraft_buttonGroup.getSelection().isSelected()) {
					proceedBtn = true;
					System.out.println("Proceed");
				}
			}
		});

		JLabel lblSelectSpacecraft = new JLabel("Select Spacecraft:");
		lblSelectSpacecraft.setBackground(new Color(255, 255, 255));
		lblSelectSpacecraft.setForeground(new Color(0, 255, 255));
		lblSelectSpacecraft.setFont(new Font("Slider", Font.PLAIN, 22));
		lblSelectSpacecraft.setBounds(755, 104, 204, 31);
		contentPane.add(lblSelectSpacecraft);

		JLabel lblOrionImage = new JLabel("Orion");
		lblOrionImage.setIcon(new ImageIcon("lib/images/OrionInSpace_Small.png"));
		lblOrionImage.setBounds(517, 163, 299, 216);
		contentPane.add(lblOrionImage);

		JLabel lblShuttleImage = new JLabel("SpaceX Shuttle");
		lblShuttleImage
				.setIcon(new ImageIcon("lib/images/SpaceX_Shuttle_2_Small.jpg"));
		lblShuttleImage.setBounds(837, 166, 385, 216);
		contentPane.add(lblShuttleImage);

		rdbtnOrion = new JRadioButton("Orion Spacecraft");
		rdbtnOrion.setOpaque(false);
		rdbtnOrion.setSelected(true);
		Spacecraft_buttonGroup.add(rdbtnOrion);
		rdbtnOrion.setFont(new Font("Slider", Font.PLAIN, 18));
		rdbtnOrion.setForeground(new Color(255, 255, 255));
		rdbtnOrion.setBounds(593, 394, 182, 23);
		contentPane.add(rdbtnOrion);
		
		JTextArea txtOrionData = new JTextArea();
		txtOrionData.setText("> Crew slots: 4\r\n> Max transfer velocity: 55,000 KPH\r\n> Ship integrity: 3\r\n> Score bonus");
		txtOrionData.setFont(new Font("Slider", Font.PLAIN, 16));
		txtOrionData.setForeground(Color.WHITE);
		txtOrionData.setOpaque(false);
		txtOrionData.setEditable(false);
		txtOrionData.setBounds(517, 431, 299, 89);
		contentPane.add(txtOrionData);

		rdbtnSpaceX = new JRadioButton("SpaceX Shuttle");
		rdbtnSpaceX.setOpaque(false);
		rdbtnSpaceX.setForeground(new Color(255, 255, 255));
		rdbtnSpaceX.setSelected(false);
		Spacecraft_buttonGroup.add(rdbtnSpaceX);
		rdbtnSpaceX.setFont(new Font("Slider", Font.PLAIN, 18));
		rdbtnSpaceX.setBounds(970, 389, 156, 23);
		contentPane.add(rdbtnSpaceX);
		
		JTextArea txtSpaceX_Data = new JTextArea();
		txtSpaceX_Data.setText("> Crew slots: 5\r\n> Max transfer velocity: 50,000 KPH\r\n> Ship integrity: 4");
		txtSpaceX_Data.setOpaque(false);
		txtSpaceX_Data.setForeground(Color.WHITE);
		txtSpaceX_Data.setFont(new Font("Slider", Font.PLAIN, 16));
		txtSpaceX_Data.setEditable(false);
		txtSpaceX_Data.setBounds(837, 431, 299, 89);
		contentPane.add(txtSpaceX_Data);
		btnProceed.setBounds(593, 591, 182, 55);
		contentPane.add(btnProceed);

		JLabel lblSelectDestination = new JLabel("Select Destination:");
		lblSelectDestination.setForeground(new Color(0, 255, 255));
		lblSelectDestination.setFont(new Font("Slider", Font.PLAIN, 22));
		lblSelectDestination.setBounds(45, 52, 217, 38);
		contentPane.add(lblSelectDestination);

		JTextArea txtrEuropaInfo = new JTextArea();
		txtrEuropaInfo.setOpaque(false);
		txtrEuropaInfo.setForeground(new Color(255, 255, 255));
		txtrEuropaInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		txtrEuropaInfo.setText(
				"Name: Europa\r\nClass: Moon\r\nType: Barren Ice world\r\nWater: Subterranean\r\nVoyage distance: 800 M Km\r\n");
		txtrEuropaInfo.setBounds(260, 432, 232, 106);
		contentPane.add(txtrEuropaInfo);

		JTextArea textMarsInfo = new JTextArea();
		textMarsInfo.setForeground(new Color(255, 255, 255));
		textMarsInfo.setOpaque(false);
		textMarsInfo.setText(
				"Name: Mars\r\nClass: Planet\r\nType: Arid world\r\nWater: Northern Ice Caps\r\nVoyage distance: 250 M Km\r\n");
		textMarsInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		textMarsInfo.setBounds(260, 166, 232, 106);
		contentPane.add(textMarsInfo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(new Color(255, 255, 255));
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1264, 684);
		contentPane.add(lblBackground);
	}

	public int checkButtons() {
		if (proceedBtn)
			return 1;
		else
			return 0;
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
	
	public String getDestination(){
		if(rdbtnMars.isSelected()) return rdbtnMars.getText();
		else if(rdbtnEuropa.isSelected()) return rdbtnEuropa.getText();
		else return null;
	}
	
	public int getDestinationId(){
		if(rdbtnMars.isSelected()) return 1;
		else if(rdbtnEuropa.isSelected()) return 2;
		else return 0;
	}
	
	public String getSpacecraft(){
		if(rdbtnOrion.isSelected()) return rdbtnOrion.getText();
		else if(rdbtnSpaceX.isSelected()) return rdbtnSpaceX.getText();
		else return null;
	}
	
	public int getSpacecraftId(){
		if(rdbtnOrion.isSelected()) return 1;
		else if(rdbtnSpaceX.isSelected()) return 2;
		else return 0;
	}
	
	public void updateGameData(){
		if(getSpacecraftId() == 1){
			GameData.spacecraft = new Spaceship(1);
			GameData.shipVelocity = GameData.spacecraft.getMaxVelocity();
		}else{
			GameData.spacecraft = new Spaceship(2);
		}
		if(getDestinationId() == 1){
			Destination.initDestination(1);
		}else{
			Destination.initDestination(2);
		}
		GameData.shipVelocity = GameData.spacecraft.getMaxVelocity();
		GameData.voyageDistance = Destination.getDistance().doubleValue();
	}
}
