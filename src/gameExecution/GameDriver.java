package gameExecution;

import java.awt.EventQueue;
import gameSound.CustomPlayer;
import gameWindow.*;
import sounds.SongPath;

public class GameDriver implements Runnable {

	public GameData gameData = new GameData();
	
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
		TransferStage transferWindow = new TransferStage();
		
		SongPath sp = new SongPath();
		CustomPlayer player = new CustomPlayer();
			
		player.setPath(sp.getPath(10));
		if(player.play(-1)) System.out.println("Playing Intro");
		else System.out.println("Exit");
		

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
						//Next Window
						difficultyWindow.setVisible(true);
						currentWindow = difficultyWindow.getWindowId();
					}
					break;
				case 1:
					if (difficultyWindow.checkButtons() == 1) {
						gameData.setDifficulty(difficultyWindow.getDifficulty());
						supplyWindow.setResources(gameData.getDifficulty());
						difficultyWindow.setVisible(false);
						//Next Window
						preparationWindow.setVisible(true);
						currentWindow = preparationWindow.getWindowId();
					}
					break;
				case 2:
					if (preparationWindow.checkButtons() == 1) {
						preparationWindow.setVisible(false);
						//Next Window
						selectCrewWindow.setVisible(true);
						currentWindow = selectCrewWindow.getWindowId();
					}
					break;
				case 3:
					if (selectCrewWindow.checkButtons() == 1) {
						gameData.Crew.addAll(selectCrewWindow.getCrew());
						selectCrewWindow.setVisible(false);
						//Next Window
						supplyWindow.setVisible(true);
						currentWindow = supplyWindow.getWindowId();
					}
					break;
				case 4:
					if (supplyWindow.checkButtons() == 1) {
						supplyWindow.setVisible(false);
						gameData.setResources(supplyWindow.getFuel(),
											  supplyWindow.getFood(),
											  supplyWindow.getWater(),
											  supplyWindow.getParts());
						//Next Window
						transferWindow.ManagerSetup(gameData);
						transferWindow.setVisible(true);
						currentWindow = transferWindow.getWindowId();
						player.pause();
						player.setPath(sp.getPath(18));
						if(player.play(-1)) System.out.println("Playing Transfer");
					}
					supplyWindow.updateProgress();
					break;
				case 5:
					gameData.dataUpdate(transferWindow.TransferUpdate(String.format(java.util.Locale.US, "%.0f" , gameData.getCurrentDistance())), 
									    transferWindow.getEventPanel().isEventActive(), transferWindow.getResultPanel().isResolutionActive());
					
					transferWindow.updateManagerUI(gameData);
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
