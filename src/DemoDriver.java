import java.util.Random;
import edu.arizona.ece373.InterplanetaryPioneers.Controller.*;
import edu.arizona.ece373.InterplanetaryPioneers.Model.Destination;
import edu.arizona.ece373.InterplanetaryPioneers.View.*;

public class DemoDriver implements Runnable {

	boolean running = false;
	private int track;
	private Random rand = new Random();
	private static int RESET = 8;

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void run() {
		
		GameData.initialize();
		
		// Instantiate Windows
		StartMenu startWindow = new StartMenu();
		DifficultySet difficultyWindow = new DifficultySet();
		PreparationStage preparationWindow = new PreparationStage();
		SelectCrew selectCrewWindow = new SelectCrew();
		SupplyStage supplyWindow = new SupplyStage();
		TransferStage transferWindow = new TransferStage(true);
		EndGameStage endGameWindow = new EndGameStage();
		
		CustomPlayer player = new CustomPlayer();
			
		player.setPath(SongPath.getPath(9));
		if(player.play(-1)) System.out.println("Playing Intro");
		else System.out.println("Exit");
		
		int currentWindow = startWindow.getWindowId();
		
		while (running) {
			try {
				//More efficient on computer resources to limit loop to 1 KHz
				Thread.sleep(TransferStage.DRIVER_FACTOR);
				
				switch (currentWindow) {
				case 0:
					if (startWindow.checkButtons() == 1) {
						startWindow.getHighScorePanel().autoLoad();
						startWindow.setVisible(false);
						//Next Window
						difficultyWindow.setVisible(true);
						currentWindow = difficultyWindow.getWindowId();
					}else if (startWindow.checkButtons() == 3) {
						running = false;
					}
					break;
				case 1:
					if (difficultyWindow.checkButtons() == 1) {
						GameData.difficulty = difficultyWindow.getDifficulty();
						GameData.UserScore.setDifficulty(GameData.difficulty);
						supplyWindow.setResources();
						difficultyWindow.setVisible(false);
						//Next Window
						preparationWindow.setVisible(true);
						currentWindow = preparationWindow.getWindowId();
					}
					break;
				case 2:
					if (preparationWindow.checkButtons() == 1) {
						preparationWindow.updateGameData();
						preparationWindow.setVisible(false);
						//Next Window
						selectCrewWindow.checkGameData();
						selectCrewWindow.setVisible(true);
						currentWindow = selectCrewWindow.getWindowId();
					}
					break;
				case 3:
					if (selectCrewWindow.checkButtons() == 1) {
						GameData.UserScore.setDestID(Destination.getId());
						GameData.crew.addAll(selectCrewWindow.getCrew());
						GameData.vipID = selectCrewWindow.getSelectedVIP();
						selectCrewWindow.setVisible(false);
						//Next Window
						supplyWindow.setVisible(true);
						currentWindow = supplyWindow.getWindowId();
					}
					break;
				case 4:
					if (supplyWindow.checkButtons() == 1) {
						supplyWindow.setVisible(false);
						GameData.setResources(supplyWindow.getFuel(),
											  supplyWindow.getFood(),
											  supplyWindow.getWater(),
											  supplyWindow.getParts());
						//Next Window
						transferWindow.startup();
						currentWindow = transferWindow.getWindowId();
						player.pause();
						track = rand.nextInt(7);
						player.setPath(SongPath.getPath(track));
						if(player.play(-1)) System.out.println("Playing Transfer track: "+ track);
						System.out.println("Live crew: " + GameData.liveCrew());
						
					}
					supplyWindow.updateProgress(GameData.vipID);
					break;
				case 5:
					if(transferWindow.TransferUpdate()){ //Returns true if destination reached
						transferWindow.setVisible(false);
						endGameWindow.setVisible(true);
						currentWindow = endGameWindow.getWindowId();
					}
					if(player.isOver()){
						track = rand.nextInt(18);
						player.setPath(SongPath.getPath(track));
						player.play(-1);
					}
					if(transferWindow.getGameOverPanel().isGameOver()){
						currentWindow = RESET;
						player.pause();
						player.setPath(SongPath.getPath(23));
						if(player.play(-1)) System.out.println("Playing Game Over");
						else System.out.println("Exit");
					}
					break;
				case 6:
					if(endGameWindow.updateEndGame()){
						endGameWindow.setVisible(false);
						currentWindow = RESET;
					}
					break;
				case 8:
					// Reset/Instantiate Windows
					if(transferWindow.getGameOverPanel().isContinue() || endGameWindow.getScorePanel().isContinue()){
						transferWindow.dispose();
						startWindow.restart();
						//startWindow = new StartMenu();
						difficultyWindow = new DifficultySet();
						preparationWindow = new PreparationStage();
						selectCrewWindow = new SelectCrew();
						supplyWindow = new SupplyStage();
						transferWindow = new TransferStage(true);
						endGameWindow = new EndGameStage();
						player.pause();
						player = new CustomPlayer();
						player.setPath(SongPath.getPath(9));
						currentWindow = startWindow.getWindowId();
						if(player.play(-1)) System.out.println("Playing Intro");
						else System.out.println("Exit");
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
		new DemoDriver().start();
	}

}
