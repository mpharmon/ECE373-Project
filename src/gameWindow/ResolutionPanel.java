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
	
	
	private JTextField usedField1;
	private JTextField recoveredField2;
	private JTextField crewLostField3;
	private JTextField shipDamageField4;
	
	protected boolean Continue;
	private boolean ResolutionActive;

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
		ResultField.setBounds(545, 137, 240, 96);
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
		
		usedField1 = new JTextField();
		usedField1.setText("0");
		usedField1.setOpaque(false);
		usedField1.setForeground(Color.CYAN);
		usedField1.setFont(new Font("Slider", Font.PLAIN, 22));
		usedField1.setEditable(false);
		usedField1.setColumns(10);
		usedField1.setBorder(null);
		usedField1.setBounds(635, 386, 238, 32);
		add(usedField1);
		
		recoveredField2 = new JTextField();
		recoveredField2.setText("0");
		recoveredField2.setOpaque(false);
		recoveredField2.setForeground(Color.CYAN);
		recoveredField2.setFont(new Font("Slider", Font.PLAIN, 22));
		recoveredField2.setEditable(false);
		recoveredField2.setColumns(10);
		recoveredField2.setBorder(null);
		recoveredField2.setBounds(635, 429, 238, 32);
		add(recoveredField2);
		
		crewLostField3 = new JTextField();
		crewLostField3.setText("0");
		crewLostField3.setOpaque(false);
		crewLostField3.setForeground(Color.CYAN);
		crewLostField3.setFont(new Font("Slider", Font.PLAIN, 22));
		crewLostField3.setEditable(false);
		crewLostField3.setColumns(10);
		crewLostField3.setBorder(null);
		crewLostField3.setBounds(635, 472, 238, 32);
		add(crewLostField3);
		
		shipDamageField4 = new JTextField();
		shipDamageField4.setText("0");
		shipDamageField4.setOpaque(false);
		shipDamageField4.setForeground(Color.CYAN);
		shipDamageField4.setFont(new Font("Slider", Font.PLAIN, 22));
		shipDamageField4.setEditable(false);
		shipDamageField4.setColumns(10);
		shipDamageField4.setBorder(null);
		shipDamageField4.setBounds(635, 515, 238, 32);
		add(shipDamageField4);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Continue = true;
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
		setResolutionActive(true);
		
		if(Outcome){
			ResultField.setForeground(Color.GREEN);
			ResultField.setText("Resolved!");
			usedField1.setText(String.valueOf(cost) +" "+type);
			
		}else{
			ResultField.setForeground(Color.RED);
			ResultField.setText("Unresolved!");
			usedField1.setText(String.valueOf(cost) +" "+type);
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
	
	
}
