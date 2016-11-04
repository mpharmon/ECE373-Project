package gameExecution;

import java.awt.EventQueue;
import gameWindow.*;

public class GameDriver implements Runnable {
	
	boolean running = false;
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	
	public void run() {
		
		StartMenu frame_1 = new StartMenu();
		DifficultySet frame_2 = new DifficultySet();
		
		while (running){
			try {
				//Thread.sleep(1000);
				//System.out.println("test");
				
				if(frame_1.checkButtons() == 0){
					frame_1.setVisible(true);
				}else if(frame_1.checkButtons() == 3){
					running = false;
				}else if(frame_1.checkButtons() == 1){
					frame_1.setVisible(false);
					frame_2.setVisible(true);
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
