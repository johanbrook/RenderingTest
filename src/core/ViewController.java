package core;

import java.awt.Color;

import gui.*;

public class ViewController implements Runnable{
	
	private final int FPS = 60;
	
	private Renderer renderer;
	private Screen screen;
	private FPSMeter fpsMeter;
	
	
	public ViewController(String[] args, int width, int height) {

		
		if (args[0].equals("m1")) {
			System.out.println("Method 1");
			this.renderer = new RendererV1(width, height);
			
		} else if (args[0].equals("m2")) {
			System.out.println("Method 2");
			this.renderer = new RendererV2(width, height);
			
		} if (args[0].equals("m3")) {
			System.out.println("Method 3");
		}
		
		this.screen = new Screen(width, height);
		
		// Initialize FPS meter
		this.fpsMeter = new FPSMeter();
		
		Thread t = new Thread(this);
		t.start();
		
	}

	private void gameLoop(int fps)
	{
//		this.renderer.render(this.screen.getBackgroundBuffer());
//		this.screen.getBackgroundBuffer().setColor(Color.RED);
//		this.screen.getBackgroundBuffer().drawString("FPS: "+this.currentFPS, 0, 15);
//		this.screen.render();
		
		this.renderer.render(this.screen.getContentPane().getGraphics());
		this.screen.getContentPane().getGraphics().setColor(Color.RED);
		this.screen.getContentPane().getGraphics().drawString("FPS: "+fps, 0, 15);
	}
	
	
	
	// Run method
	
	@Override
	public void run() {
		double timeLastFrame = System.nanoTime();
		int fps;
		
		while(!Thread.interrupted()) {
			try {
				Thread.sleep(1000/FPS);
				
				fps = fpsMeter.getCurrentFPS(timeLastFrame, true);
				this.gameLoop(fps);
				timeLastFrame = fpsMeter.getTime();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
