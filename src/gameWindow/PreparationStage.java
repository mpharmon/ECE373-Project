package gameWindow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreparationStage extends JFrame {

	private boolean proceedBtn;
	private JPanel contentPane;
	private final ButtonGroup Planet_buttonGroup = new ButtonGroup();
	private final ButtonGroup Spacecraft_buttonGroup = new ButtonGroup();
	private int windowId;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// PreparationStage frame = new PreparationStage();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

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
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Slider", Font.PLAIN, 34));
		lblTitle.setBounds(513, 11, 364, 42);
		contentPane.add(lblTitle);

		JLabel lblMarsimage = new JLabel("Mars");
		lblMarsimage.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/mars.jpg")));
		lblMarsimage.setBounds(25, 101, 225, 230);
		contentPane.add(lblMarsimage);

		JLabel lblEuropaimage = new JLabel("Europa");
		lblEuropaimage.setToolTipText("\r\n");
		lblEuropaimage.setLabelFor(lblEuropaimage);
		lblEuropaimage.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/Europa_2.jpg")));
		lblEuropaimage.setBounds(25, 368, 225, 216);
		contentPane.add(lblEuropaimage);

		JRadioButton rdbtnMars = new JRadioButton("Mars");
		rdbtnMars.setSelected(true);
		Planet_buttonGroup.add(rdbtnMars);
		rdbtnMars.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnMars.setBounds(89, 338, 109, 23);
		contentPane.add(rdbtnMars);

		JRadioButton rdbtnEuropa = new JRadioButton("Europa");
		rdbtnEuropa.setSelected(false);
		Planet_buttonGroup.add(rdbtnEuropa);
		rdbtnEuropa.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnEuropa.setBounds(89, 591, 109, 23);
		contentPane.add(rdbtnEuropa);

		JButton btnProceed = new JButton("Proceed");
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
		lblSelectSpacecraft.setForeground(new Color(255, 255, 255));
		lblSelectSpacecraft.setFont(new Font("Slider", Font.PLAIN, 22));
		lblSelectSpacecraft.setBounds(755, 104, 204, 31);
		contentPane.add(lblSelectSpacecraft);

		JLabel lblOrionImage = new JLabel("Orion");
		lblOrionImage.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/OrionInSpace_Small.png")));
		lblOrionImage.setBounds(517, 163, 299, 216);
		contentPane.add(lblOrionImage);

		JLabel lblShuttleImage = new JLabel("SpaceX Shuttle");
		lblShuttleImage
				.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/SpaceX_Shuttle_2_Small.jpg")));
		lblShuttleImage.setBounds(837, 166, 385, 216);
		contentPane.add(lblShuttleImage);

		JRadioButton rdbtnOrion = new JRadioButton("Orion Spacecraft");
		rdbtnOrion.setSelected(true);
		Spacecraft_buttonGroup.add(rdbtnOrion);
		rdbtnOrion.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnOrion.setForeground(new Color(0, 0, 0));
		rdbtnOrion.setBounds(593, 394, 171, 23);
		contentPane.add(rdbtnOrion);

		JRadioButton rdbtnSpaceX = new JRadioButton("SpaceX Shuttle");
		rdbtnSpaceX.setSelected(false);
		Spacecraft_buttonGroup.add(rdbtnSpaceX);
		rdbtnSpaceX.setFont(new Font("Slider", Font.PLAIN, 16));
		rdbtnSpaceX.setBounds(985, 394, 141, 23);
		contentPane.add(rdbtnSpaceX);
		btnProceed.setBounds(595, 604, 156, 42);
		contentPane.add(btnProceed);

		JLabel lblLaunchOfSpacecraft = new JLabel("Launch of spacecraft available once status bar is full. ");
		lblLaunchOfSpacecraft.setFont(new Font("Slider", Font.BOLD, 12));
		lblLaunchOfSpacecraft.setBounds(499, 657, 378, 14);
		contentPane.add(lblLaunchOfSpacecraft);

		JLabel lblSelectDestination = new JLabel("Select Destination:");
		lblSelectDestination.setForeground(new Color(255, 255, 255));
		lblSelectDestination.setFont(new Font("Slider", Font.PLAIN, 22));
		lblSelectDestination.setBounds(45, 52, 217, 38);
		contentPane.add(lblSelectDestination);

		JTextArea txtrEuropaInfo = new JTextArea();
		txtrEuropaInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		txtrEuropaInfo.setText(
				"Name: Europa\r\nClass: Moon\r\nType: Barren Ice world\r\nWater: Subterranean\r\nDistance from Sun: 483.8 M mi\r\n");
		txtrEuropaInfo.setBounds(260, 432, 217, 88);
		contentPane.add(txtrEuropaInfo);

		JTextArea textMarsInfo = new JTextArea();
		textMarsInfo.setText(
				"Name: Mars\r\nClass: Planet\r\nType: Arid world\r\nWater: Northern Ice Caps\r\nDistance from Sun: 141.6 M mi\r\n");
		textMarsInfo.setFont(new Font("Slider", Font.PLAIN, 14));
		textMarsInfo.setBounds(260, 166, 217, 88);
		contentPane.add(textMarsInfo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(new Color(255, 255, 255));
		lblBackground.setIcon(new ImageIcon(PreparationStage.class.getResource("/images/Space.jpg")));
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
}
