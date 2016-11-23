package gameWindow;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResolutionPanel extends JPanel {
	
	private JTextField ResultField;
	
	private JTextField txtResourcesUsed;
	private JTextField txtResourcesRecovered;
	private JTextField txtCrewLost;
	private JTextField txtShipDamage;
	
	
	private JTextField usedField;
	private JTextField recoveredField;
	private JTextField crewLostField;
	private JTextField shipDamageField;
	
	protected boolean Continue;
	private boolean ResolutionActive;
	private boolean dataReady;

	/**
	 * Create the panel.
	 */
	public ResolutionPanel() {
		setLayout(null);
		
		Continue = false;
		setResolutionActive(false);
		
		JLabel lblEvent = new JLabel("Event Encounter");
		lblEvent.setForeground(new Color(0, 255, 255));
		lblEvent.setFont(new Font("Slider", Font.PLAIN, 32));
		lblEvent.setBounds(523, 11, 262, 38);
		add(lblEvent);
		
		ResultField = new JTextField();
		ResultField.setBorder(null);
		ResultField.setEditable(false);
		ResultField.setForeground(new Color(0, 255, 0));
		ResultField.setText("Resolved!");
		ResultField.setFont(new Font("Slider", Font.PLAIN, 44));
		ResultField.setOpaque(false);
		ResultField.setBounds(545, 137, 280, 96);
		add(ResultField);
		ResultField.setColumns(10);
		
		txtResourcesUsed = new JTextField();
		txtResourcesUsed.setText("Resources Used: ");
		txtResourcesUsed.setOpaque(false);
		txtResourcesUsed.setForeground(new Color(0, 255, 255));
		txtResourcesUsed.setFont(new Font("Slider", Font.PLAIN, 22));
		txtResourcesUsed.setEditable(false);
		txtResourcesUsed.setColumns(10);
		txtResourcesUsed.setBorder(null);
		txtResourcesUsed.setBounds(324, 386, 238, 32);
		add(txtResourcesUsed);
		
		txtCrewLost = new JTextField();
		txtCrewLost.setText("Crew Lost: ");
		txtCrewLost.setOpaque(false);
		txtCrewLost.setForeground(new Color(0, 255, 255));
		txtCrewLost.setFont(new Font("Slider", Font.PLAIN, 22));
		txtCrewLost.setEditable(false);
		txtCrewLost.setColumns(10);
		txtCrewLost.setBorder(null);
		txtCrewLost.setBounds(324, 472, 238, 32);
		add(txtCrewLost);
		
		txtShipDamage = new JTextField();
		txtShipDamage.setText("Ship Damage:");
		txtShipDamage.setOpaque(false);
		txtShipDamage.setForeground(new Color(0, 255, 255));
		txtShipDamage.setFont(new Font("Slider", Font.PLAIN, 22));
		txtShipDamage.setEditable(false);
		txtShipDamage.setColumns(10);
		txtShipDamage.setBorder(null);
		txtShipDamage.setBounds(324, 515, 238, 32);
		add(txtShipDamage);
		
		txtResourcesRecovered = new JTextField();
		txtResourcesRecovered.setText("Resources Recovered:");
		txtResourcesRecovered.setOpaque(false);
		txtResourcesRecovered.setForeground(new Color(0, 255, 255));
		txtResourcesRecovered.setFont(new Font("Slider", Font.PLAIN, 22));
		txtResourcesRecovered.setEditable(false);
		txtResourcesRecovered.setColumns(10);
		txtResourcesRecovered.setBorder(null);
		txtResourcesRecovered.setBounds(324, 429, 238, 32);
		add(txtResourcesRecovered);
		
		usedField = new JTextField();
		usedField.setText("0");
		usedField.setOpaque(false);
		usedField.setForeground(Color.CYAN);
		usedField.setFont(new Font("Slider", Font.PLAIN, 22));
		usedField.setEditable(false);
		usedField.setColumns(10);
		usedField.setBorder(null);
		usedField.setBounds(635, 386, 238, 32);
		add(usedField);
		
		recoveredField = new JTextField();
		recoveredField.setText("0");
		recoveredField.setOpaque(false);
		recoveredField.setForeground(Color.CYAN);
		recoveredField.setFont(new Font("Slider", Font.PLAIN, 22));
		recoveredField.setEditable(false);
		recoveredField.setColumns(10);
		recoveredField.setBorder(null);
		recoveredField.setBounds(635, 429, 238, 32);
		add(recoveredField);
		
		crewLostField = new JTextField();
		crewLostField.setText("0");
		crewLostField.setOpaque(false);
		crewLostField.setForeground(Color.CYAN);
		crewLostField.setFont(new Font("Slider", Font.PLAIN, 22));
		crewLostField.setEditable(false);
		crewLostField.setColumns(10);
		crewLostField.setBorder(null);
		crewLostField.setBounds(635, 472, 238, 32);
		add(crewLostField);
		
		shipDamageField = new JTextField();
		shipDamageField.setText("0");
		shipDamageField.setOpaque(false);
		shipDamageField.setForeground(Color.CYAN);
		shipDamageField.setFont(new Font("Slider", Font.PLAIN, 22));
		shipDamageField.setEditable(false);
		shipDamageField.setColumns(10);
		shipDamageField.setBorder(null);
		shipDamageField.setBounds(635, 515, 238, 32);
		add(shipDamageField);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Continue = true;
				dataReady = true;
				setResolutionActive(false);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Slider", Font.PLAIN, 18));
		btnNewButton.setBounds(556, 585, 168, 50);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Summary:");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Slider", Font.PLAIN, 24));
		lblNewLabel.setBounds(575, 303, 125, 32);
		add(lblNewLabel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ResolutionPanel.class.getResource("/images/hud_bg_full.jpg")));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);

	}
	
	public boolean DisplayResolution(boolean Outcome, int resolution, int cost, String type ){
		Continue = false;
		dataReady = false;
		setResolutionActive(true);
		
		if(Outcome){
			ResultField.setForeground(Color.GREEN);
			ResultField.setText("Resolved!");
			usedField.setText(String.valueOf(cost)    +" "+ type);
			recoveredField.setText(String.valueOf(0)  +" "+ "n/a");
			crewLostField.setText(String.valueOf(0)   +" "+ "none");
			shipDamageField.setText(String.valueOf(0) +" "+ "sustained");
			
		}else{
			ResultField.setForeground(Color.RED);
			ResultField.setText("Unresolved!");
			usedField.setText(String.valueOf(0) 	  +" "+ type);
			recoveredField.setText(String.valueOf(0)  +" "+ "n/a");
			crewLostField.setText(String.valueOf(0)   +" "+ "none");
			shipDamageField.setText(String.valueOf(1) +" "+ "sustained");
			
		}
		//Panel configured can be displayed now
		setVisible(true);
		
		if(Continue) return true;
		else return false;
	}

	public boolean isResolutionActive() {
		return ResolutionActive;
	}

	public void setResolutionActive(boolean resolutionActive) {
		ResolutionActive = resolutionActive;
	}

	public boolean isDataReady() {
		return dataReady;
	}

	public void setDataReady(boolean dataReady) {
		this.dataReady = dataReady;
	}
	
	
}
