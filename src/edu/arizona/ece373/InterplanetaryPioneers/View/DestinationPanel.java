package edu.arizona.ece373.InterplanetaryPioneers.View;

import javax.swing.JPanel;

import edu.arizona.ece373.InterplanetaryPioneers.Controller.*;
import edu.arizona.ece373.InterplanetaryPioneers.Model.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DestinationPanel extends JPanel {
	
	private boolean DestinationActive = false;
	private boolean score = false;
	private JLabel lblDestination;

	/**
	 * Create the panel.
	 */
	public DestinationPanel() {
		setLayout(null);
		setBounds(0,0,1280,720);
		JLabel lblNewLabel = new JLabel("Destination Reached!");
		lblNewLabel.setFont(new Font("Slider", Font.PLAIN, 32));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(478, 11, 326, 48);
		add(lblNewLabel);
		
		lblDestination = new JLabel("");
		lblDestination.setIcon(new ImageIcon("lib/images/spacexEuropaFIT.jpg"));
		lblDestination.setBounds(138, 76, 1024, 527);
		add(lblDestination);
		
		JButton btnNewButton = new JButton("Score");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				setScore(true);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Slider", Font.PLAIN, 22));
		btnNewButton.setBounds(537, 608, 221, 48);
		add(btnNewButton);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon("lib/images/hud_bg_full.jpg"));
		lblBackground.setBounds(0, 0, 1280, 720);
		add(lblBackground);

	}
	
	public void displayDestination(){
		setScore(false);
		setDestinationActive(true);
		setVisible(true);
		
		if(Destination.getId() == Destination.MARS){
			if(GameData.spacecraft.getId() == Spaceship.ORION_CAPSULE){
				lblDestination.setIcon(new ImageIcon("lib/images/ColonistsMarsFIT.png"));
				lblDestination.setBounds(120, 70, 1084, 463);
			}else{
				lblDestination.setIcon(new ImageIcon("lib/images/SpaceXmarsFIT3.jpg"));
				lblDestination.setBounds(93, 51, 1120, 546);
			}
		}else{
			lblDestination.setIcon(new ImageIcon("lib/images/spacexEuropaFIT.jpg"));
			lblDestination.setBounds(138, 76, 1024, 527);
		}
		
	}

	public boolean isDestinationActive() {
		return DestinationActive;
	}

	public void setDestinationActive(boolean destinationActive) {
		DestinationActive = destinationActive;
	}

	public boolean isScore() {
		return score;
	}

	public void setScore(boolean score) {
		this.score = score;
	}
	
}
