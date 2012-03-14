/**
*	FPSMeter.java
*
*	@author Johan
*/

package gui;

public class FPSMeter {
	
	private final double TICK_LIMIT = 1000000000.0;
	
	private String label;
	private double thisTime;
	private java.awt.Graphics screen;
	
	private double timeThisSecond;
	private int framesThisSecond;
	private int currentFPS;
	
	
	public FPSMeter(String label, java.awt.Graphics g) {
		this.label = label;
		this.screen = g;
	}
	
	public FPSMeter(java.awt.Graphics g) {
		this("FPS", g);
	}

	
	public int getCurrentFPS(double timeLastFrame){
		this.thisTime = System.nanoTime();
		double dt = this.thisTime - timeLastFrame;
		timeLastFrame = this.thisTime;
		
		if (this.timeThisSecond > TICK_LIMIT) {
			this.currentFPS = this.framesThisSecond;
			this.framesThisSecond = 0;
			this.timeThisSecond = 0;
			
		} else {
			this.timeThisSecond += dt;
			this.framesThisSecond++;
		}
		
		return this.currentFPS;
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
