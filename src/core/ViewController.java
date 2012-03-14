package core;

import java.awt.Color;

import gui.Renderer;
import gui.RendererV1;
import gui.Screen;

public class ViewController implements Runnable{
	
	private final int FPS = 60;
	
	private Renderer renderer;
	private Screen screen;
	
	
	public ViewController(String[] args)
	{
		if (args[0].equals("m1")) {
			System.out.println("Method 1");
			this.renderer = new RendererV1();
		} else if (args[0].equals("m2")) {
			System.out.println("Method 2");
		} if (args[0].equals("m3")) {
			System.out.println("Method 3");
		}
		
		this.screen = new Screen(1000,700);
		
		Thread t = new Thread(this);
		t.start();
		
	}

	private void gameLoop(double dt)
	{
//		this.renderer.render(this.screen.getBackgroundBuffer());
//		this.screen.getBackgroundBuffer().setColor(Color.RED);
//		this.screen.getBackgroundBuffer().drawString("FPS: "+this.currentFPS, 0, 15);
//		this.screen.render();
		
		this.renderer.render(this.screen.getContentPane().getGraphics());
		this.screen.getContentPane().getGraphics().setColor(Color.RED);
		this.screen.getContentPane().getGraphics().drawString("FPS: "+this.currentFPS, 0, 15);
	}
	
	
	
	
	
	// FPS-meter
	double timeLastFrame;
	
	double timeThisSecond;
	int framesThisSecond;
	int currentFPS;
	
	
	// Run method
	
	@Override
	public void run() {
		this.timeLastFrame = System.nanoTime();
		while(!Thread.interrupted()) {
			try {
				Thread.sleep(1000/FPS);
				
				double thisTime = System.nanoTime();
				double dt = thisTime - this.timeLastFrame;
				this.timeLastFrame = thisTime;
				
				if (this.timeThisSecond > 1000000000.0) {
					this.currentFPS = this.framesThisSecond;
					this.framesThisSecond = 0;
					this.timeThisSecond = 0;
					System.out.println("FPS: "+this.currentFPS);
				} else {
					this.timeThisSecond += dt;
					this.framesThisSecond++;
				}
				
				this.gameLoop(dt);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
