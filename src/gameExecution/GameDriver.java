package gameExecution;

import java.awt.EventQueue;
import gameWindow.*;

public class GameDriver implements Runnable {

	boolean running = false;

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void run() {

		// Instantiate Windows
		StartMenu startWindow = new StartMenu();
		DifficultySet difficultyWindow = new DifficultySet();
		PreparationStage preparationWindow = new PreparationStage();
		SelectCrew selectCrewWindow = new SelectCrew();
		SupplyStage supplyWindow = new SupplyStage();

		int currentWindow = startWindow.getWindowId();

		while (running) {
			try {
				//Thread.sleep(500);
				// System.out.println("test");

				switch (currentWindow) {
				case 0:
					if (startWindow.checkButtons() == 0) {
						startWindow.setVisible(true);
					} else if (startWindow.checkButtons() == 3) {
						running = false;
					} else if (startWindow.checkButtons() == 1) {
						startWindow.setVisible(false);
						difficultyWindow.setVisible(true);
						currentWindow = difficultyWindow.getWindowId();
					}
					break;
				case 1:
					if (difficultyWindow.checkButtons() == 1) {
						difficultyWindow.setVisible(false);
						preparationWindow.setVisible(true);
						currentWindow = preparationWindow.getWindowId();
					}
					break;
				case 2:
					if (preparationWindow.checkButtons() == 1) {
						preparationWindow.setVisible(false);
						selectCrewWindow.setVisible(true);
						currentWindow = selectCrewWindow.getWindowId();
					}
					break;
				case 3:
					if (selectCrewWindow.checkButtons() == 1) {
						selectCrewWindow.setVisible(false);
						supplyWindow.setVisible(true);
						currentWindow = supplyWindow.getWindowId();
					}
					supplyWindow.updateProgress();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public static void main(String[] args) {

		new GameDriver().start();
	}

}
