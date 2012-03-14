/**
*	FPSMeter.java
*
*	@author Johan
*/

package gui;

import java.util.List;
import java.util.LinkedList;

public class FPSMeter {
	
	private final double TICK_LIMIT = 1000000000.0;
	
	private String label;
	private double thisTime;
	private java.awt.Graphics screen;
	private List<Integer> fpsList;
	
	private double timeThisSecond;
	private int framesThisSecond;
	private int currentFPS;
	
	
	public FPSMeter(String label, java.awt.Graphics g) {
		this.label = label;
		this.screen = g;
		this.fpsList = new LinkedList<Integer>();
	}
	
	public FPSMeter(java.awt.Graphics g) {
		this("FPS", g);
	}

	public void tick(double timeLastFrame){
		this.thisTime = System.nanoTime();
		double dt = this.thisTime - timeLastFrame;
		timeLastFrame = this.thisTime;
		
		if (this.timeThisSecond > TICK_LIMIT) {
			this.currentFPS = this.framesThisSecond;
			this.framesThisSecond = 0;
			this.timeThisSecond = 0;
			this.fpsList.add(this.currentFPS);
			
		} else {
			this.timeThisSecond += dt;
			this.framesThisSecond++;
		}
	}
	
	public int getCurrentFPS(){
		return this.currentFPS;
	}
	
	public int getAverageFPS(){
		int sum = 0;
		for(Integer el : this.fpsList){
			sum += el.intValue();
		}
		
		return (int) sum/this.fpsList.size();
	}
	
	public void showCurrentFPS(){
		this.screen.setColor(java.awt.Color.WHITE);
		this.screen.fillRect(0, 0, 50, 20);
		
		if (this.timeThisSecond > TICK_LIMIT) {
			System.out.println(this.label + ": " +this.currentFPS);
		}
		this.screen.setColor(java.awt.Color.RED);
		this.screen.drawString(this.label+": "+this.currentFPS, 0, 15);
	}
	
	public double getTime(){
		return this.thisTime;
	}
}
