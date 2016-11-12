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
		
		GameData gameData = new GameData();

		// Instantiate Windows
		StartMenu startWindow = new StartMenu();
		DifficultySet difficultyWindow = new DifficultySet();
		PreparationStage preparationWindow = new PreparationStage();
		SelectCrew selectCrewWindow = new SelectCrew();
		SupplyStage supplyWindow = new SupplyStage();
		TransferStage transferWindow = new TransferStage();

		int currentWindow = startWindow.getWindowId();

		while (running) {
			try {
				//More efficient on computer resources to limit loop to 1 KHz
				Thread.sleep(1);
				
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
						gameData.setDifficulty(difficultyWindow.getDifficulty());
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
					break;
				case 4:
					if (supplyWindow.checkButtons() == 1) {
						supplyWindow.setVisible(false);
						transferWindow.setVisible(true);
						currentWindow = transferWindow.getWindowId();
					}
					supplyWindow.updateProgress();
					break;
				case 5:
					transferWindow.moveSpace();
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
