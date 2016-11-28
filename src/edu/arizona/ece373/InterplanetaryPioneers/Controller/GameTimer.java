package edu.arizona.ece373.InterplanetaryPioneers.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameTimer extends JApplet {
	
	private Timer timer;
	private int delay;
	private boolean update;
	
	public GameTimer(){
		delay = 10;
		update = false;
		initTimer();
	}
	
	public GameTimer(int delay){
		this.delay = delay;
		update = false;
		initTimer();
	}
	
	
	public void initTimer(){
		// Create a Timer object and register an ActionListener.
		timer = new Timer(delay, new TimerListener());
		// Start the timer.
		timer.start();
	}
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{	 
			update = true;
		}
	}
   
	public Timer getTimer(){
		return timer;
	}
   
	public void setTimer(int delay){
		timer.setDelay(delay);
	}

	public boolean isUpdate() {
		return update;
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
	}
}
