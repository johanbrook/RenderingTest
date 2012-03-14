/**
*	FPSMeter.java
*
*	@author Johan
*/

package gui;

public class FPSMeter {
	
	private String label;
	private double thisTime;
	
	private double timeThisSecond;
	private int framesThisSecond;
	private int currentFPS;
	
	
	public FPSMeter(String label) {
		this.label = label;
	}
	
	public FPSMeter() {
		this("FPS");
	}

	
	public int getCurrentFPS(double timeLastFrame, boolean tick){
		this.thisTime = System.nanoTime();
		double dt = this.thisTime - timeLastFrame;
		timeLastFrame = this.thisTime;
		
		if (this.timeThisSecond > 1000000000.0) {
			this.currentFPS = this.framesThisSecond;
			this.framesThisSecond = 0;
			this.timeThisSecond = 0;
			
			if(tick){
				System.out.println(this.label + ": " +this.currentFPS);
			}
				
			
			return this.currentFPS;
			
		} else {
			this.timeThisSecond += dt;
			this.framesThisSecond++;
		}
		
		return 0;
	}
	
	public double getTime(){
		return this.thisTime;
	}
}
