package gameExecution;

import java.awt.EventQueue;
import gameSound.CustomPlayer;
import gameWindow.*;
import sounds.SongPath;

public class GameDriver implements Runnable {

	boolean running = false;
	private boolean trackReset = false;

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
			
		player.setPath(sp.getPath(9));
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
						transferWindow.getGameData().setDifficulty(difficultyWindow.getDifficulty());
						supplyWindow.setResources(transferWindow.getGameData().getDifficulty());
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
						transferWindow.getGameData().Crew.addAll(selectCrewWindow.getCrew());
						selectCrewWindow.setVisible(false);
						//Next Window
						supplyWindow.setVisible(true);
						currentWindow = supplyWindow.getWindowId();
					}
					break;
				case 4:
					if (supplyWindow.checkButtons() == 1) {
						supplyWindow.setVisible(false);
						transferWindow.getGameData().setResources(supplyWindow.getFuel(),
											  supplyWindow.getFood(),
											  supplyWindow.getWater(),
											  supplyWindow.getParts());
						//Next Window
						transferWindow.ManagerSetup(transferWindow.getGameData());
						transferWindow.setVisible(true);
						currentWindow = transferWindow.getWindowId();
						player.pause();
						player.setPath(sp.getPath(18));
						if(player.play(-1)) System.out.println("Playing Transfer");
					}
					supplyWindow.updateProgress();
					break;
				case 5:
					transferWindow.TransferUpdate();
					transferWindow.updateManagerUI();
					if(transferWindow.getGameData().getCurrentDistance() > 130000000 && !trackReset){
						player.setPath(sp.getPath(3));
						if(player.play(-1)) System.out.println("Playing Second Track");
						else System.out.println("Exit");
						trackReset = true;
					}
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
