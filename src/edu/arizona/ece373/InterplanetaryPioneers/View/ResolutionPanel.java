package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.GameData;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Event;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ResolutionPanel extends JPanel {
	private JTextField ResultField;
	private JTextField txtResourcesUsed;
	private JTextField txtResourcesRecovered;
	private JTextField txtCrewInjury;
	private JTextField txtCrewLost;
	private JTextField txtShipDamage;
	
	private JTextField usedField;
	private JTextField recoveredField;
	private JTextField crewInjuryField;
	private JTextField crewLostField;
	private JTextField shipDamageField;
	
	private boolean Continue;
	private boolean ResolutionActive;
	private boolean dataReady;
	private boolean penaltyUpdated;
	private boolean updated = false;
	
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
		ResultField.setHorizontalAlignment(SwingConstants.CENTER);
		ResultField.setBorder(null);
		ResultField.setEditable(false);
		ResultField.setForeground(new Color(0, 255, 0));
		ResultField.setText("Resolved!");
		ResultField.setFont(new Font("Slider", Font.PLAIN, 36));
		ResultField.setOpaque(false);
		ResultField.setBounds(445, 137, 380, 96);
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
		txtResourcesUsed.setBounds(324, 353, 238, 32);
		add(txtResourcesUsed);
		
		txtCrewInjury = new JTextField();
		txtCrewInjury.setText("Crew Injury: ");
		txtCrewInjury.setOpaque(false);
		txtCrewInjury.setForeground(Color.CYAN);
		txtCrewInjury.setFont(new Font("Slider", Font.PLAIN, 22));
		txtCrewInjury.setEditable(false);
		txtCrewInjury.setColumns(10);
		txtCrewInjury.setBorder(null);
		txtCrewInjury.setBounds(324, 439, 238, 32);
		add(txtCrewInjury);
		
		txtCrewLost = new JTextField();
		txtCrewLost.setText("Crew Lost: ");
		txtCrewLost.setOpaque(false);
		txtCrewLost.setForeground(new Color(0, 255, 255));
		txtCrewLost.setFont(new Font("Slider", Font.PLAIN, 22));
		txtCrewLost.setEditable(false);
		txtCrewLost.setColumns(10);
		txtCrewLost.setBorder(null);
		txtCrewLost.setBounds(324, 482, 238, 32);
		add(txtCrewLost);
		
		txtShipDamage = new JTextField();
		txtShipDamage.setText("Ship Damage:");
		txtShipDamage.setOpaque(false);
		txtShipDamage.setForeground(new Color(0, 255, 255));
		txtShipDamage.setFont(new Font("Slider", Font.PLAIN, 22));
		txtShipDamage.setEditable(false);
		txtShipDamage.setColumns(10);
		txtShipDamage.setBorder(null);
		txtShipDamage.setBounds(324, 525, 238, 32);
		add(txtShipDamage);
		
		txtResourcesRecovered = new JTextField();
		txtResourcesRecovered.setText("Resources Recovered:");
		txtResourcesRecovered.setOpaque(false);
		txtResourcesRecovered.setForeground(new Color(0, 255, 255));
		txtResourcesRecovered.setFont(new Font("Slider", Font.PLAIN, 22));
		txtResourcesRecovered.setEditable(false);
		txtResourcesRecovered.setColumns(10);
		txtResourcesRecovered.setBorder(null);
		txtResourcesRecovered.setBounds(324, 396, 238, 32);
		add(txtResourcesRecovered);
		
		usedField = new JTextField();
		usedField.setText("0");
		usedField.setOpaque(false);
		usedField.setForeground(Color.CYAN);
		usedField.setFont(new Font("Slider", Font.PLAIN, 22));
		usedField.setEditable(false);
		usedField.setColumns(10);
		usedField.setBorder(null);
		usedField.setBounds(635, 353, 238, 32);
		add(usedField);
		
		recoveredField = new JTextField();
		recoveredField.setText("0");
		recoveredField.setOpaque(false);
		recoveredField.setForeground(Color.CYAN);
		recoveredField.setFont(new Font("Slider", Font.PLAIN, 22));
		recoveredField.setEditable(false);
		recoveredField.setColumns(10);
		recoveredField.setBorder(null);
		recoveredField.setBounds(635, 396, 238, 32);
		add(recoveredField);
		
		crewInjuryField = new JTextField();
		crewInjuryField.setText("0");
		crewInjuryField.setOpaque(false);
		crewInjuryField.setForeground(Color.CYAN);
		crewInjuryField.setFont(new Font("Slider", Font.PLAIN, 22));
		crewInjuryField.setEditable(false);
		crewInjuryField.setColumns(10);
		crewInjuryField.setBorder(null);
		crewInjuryField.setBounds(635, 439, 238, 32);
		add(crewInjuryField);
		
		crewLostField = new JTextField();
		crewLostField.setText("0");
		crewLostField.setOpaque(false);
		crewLostField.setForeground(Color.CYAN);
		crewLostField.setFont(new Font("Slider", Font.PLAIN, 22));
		crewLostField.setEditable(false);
		crewLostField.setColumns(10);
		crewLostField.setBorder(null);
		crewLostField.setBounds(635, 482, 238, 32);
		add(crewLostField);
		
		shipDamageField = new JTextField();
		shipDamageField.setText("0");
		shipDamageField.setOpaque(false);
		shipDamageField.setForeground(Color.CYAN);
		shipDamageField.setFont(new Font("Slider", Font.PLAIN, 22));
		shipDamageField.setEditable(false);
		shipDamageField.setColumns(10);
		shipDamageField.setBorder(null);
		shipDamageField.setBounds(635, 525, 238, 32);
		add(shipDamageField);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Continue = true;
				dataReady = true;
				setResolutionActive(false);
				setVisible(false);
				penaltyUpdated = false;
				updated = false;
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
		lblNewLabel.setBounds(576, 262, 125, 32);
		add(lblNewLabel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);

	}
	
	public boolean DisplayResolution(boolean Outcome, int resolution, int cost, Event event){
		Continue = false;
		dataReady = false;
		
		if(!updated){
			ResultField.setFont(new Font("Slider", Font.PLAIN, 42));
			if(Outcome){
				GameData.resolvedEvents += 1;
				ResultField.setForeground(Color.GREEN);
				ResultField.setText("Resolved!");

				if(event.isPenalty()){
					usedField.setText(cost    +" "+ Event.getTypeString(event.getPenaltyType()));
					recoveredField.setText(String.valueOf(0)  +" ");
				}else{
					usedField.setText(String.valueOf(0)    +" ");
					recoveredField.setText(cost  +" "+ Event.getTypeString(event.getPenaltyType()));
				}

				if(event.isWormHole()){
					ResultField.setFont(new Font("Slider", Font.PLAIN, 22));
					ResultField.setText("Wormhole jump: +10% Distance");
					System.out.println("Pre-Jump Distance: " +GameData.currentDistance + " Post-Jump: "+ (GameData.currentDistance + GameData.voyageDistance * 0.10));
					GameData.currentDistance = (GameData.currentDistance + GameData.voyageDistance * 0.10);
				}
				crewInjuryField.setText(String.valueOf(0)   +" "+ "none");
				crewLostField.setText(String.valueOf(0)   +" "+ "none");
				shipDamageField.setText(String.valueOf(0) +" "+ "sustained");
			}else if(!penaltyUpdated){
				penaltyUpdated = true;
				ResultField.setForeground(Color.RED);
				ResultField.setText("Unresolved!");
				usedField.setText(String.valueOf(0) +" "+ Event.getTypeString(event.getPenaltyType()));
				recoveredField.setText(String.valueOf(0) +" ");
				crewInjuryField.setText(String.valueOf(0) +" ");
				crewLostField.setText(String.valueOf(0)   +" "+ "none");
				shipDamageField.setText(String.valueOf(0) +" "+ "sustained");
				if(event.isInjury()){
					System.out.println("Crew Injury.");
					
					if(event.getSeverity() == Event.Low){
						if(GameData.updateCrewInjury(event)) 
							crewLostField.setText(String.valueOf(0) +" ");
						else{
							System.out.println("Crew member "+ event.getCrewInjuried() +" lost.");
							crewLostField.setText(String.valueOf(1) +" "+ GameData.crew.get(event.getCrewInjuried()).getName());
						}
						crewInjuryField.setText(String.valueOf(1) + " " + GameData.crew.get(event.getCrewInjuried()).getName());
					}else{
						System.out.println("Entire Crew Injured.");
						int alive = GameData.liveCrew();
						int killed = GameData.InjureAllCrew(1);
						
						if(killed == 0){ //no deaths
							crewLostField.setText(String.valueOf(0) +" ");
						}else{
							System.out.println("Crew lost "+ killed +" total.");
							crewLostField.setText(killed +" total");
						}
						crewInjuryField.setText(alive + " total");
					}
				}
				if(event.isDamage()){
					GameData.updateShipDamage(event.getSeverity()); //Ship damage scaled by event severity 1-3
					shipDamageField.setText(String.valueOf(event.getSeverity()) +" "+ "sustained");
					System.out.println("Ship Damaged");
				}
				if(event.isWormHole()){
					ResultField.setFont(new Font("Slider", Font.PLAIN, 22));
					if(event.Option4 != resolution){
						ResultField.setText("Wormhole jump: -10% Distance");
						System.out.println("Pre-Jump Distance: " +GameData.currentDistance + " Post-Jump: "+ (GameData.currentDistance - GameData.voyageDistance * 0.10));
						GameData.currentDistance = (GameData.currentDistance - GameData.voyageDistance * 0.10);
					}else{
						ResultField.setForeground(Color.CYAN);
						ResultField.setText("Wormhole Avoided!");
					}
				}
				System.out.println("Crew Alive: " + GameData.liveCrew() + "\nShip Integrity: " + GameData.spacecraft.getHull());
			}
		}
		
		//Panel configured can be displayed now
		setVisible(true);
		ResolutionActive = true;
		updated = true;
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

	public boolean isPenaltyUpdated() {
		return penaltyUpdated;
	}

	public void setPenaltyUpdated(boolean penaltyUpdated) {
		this.penaltyUpdated = penaltyUpdated;
	}
	
	public boolean isContinue(){
		return Continue;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
}
