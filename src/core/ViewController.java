package core;

import gui.*;

public class ViewController implements Runnable{
	
	private final int FPS = 60;
	
	private Renderer renderer;
	private Screen screen;
	private FPSMeter fpsMeter;
	
	private long start;
	
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
		
		this.screen = new Screen(this, width, height);
		
		// Initialize FPS meter
		this.fpsMeter = new FPSMeter(this.screen.getContentPane().getGraphics());
		
		Thread t = new Thread(this);
		t.start();
		
		this.start = System.currentTimeMillis();
		
	}

	private void gameLoop()
	{
//		this.renderer.render(this.screen.getBackgroundBuffer());
//		this.screen.render();
		
		this.renderer.render(this.screen.getContentPane().getGraphics());
	}
	
	
	public void onShutdown(java.awt.event.WindowEvent evt){
		long end = System.currentTimeMillis();
		double totalTime = (end - start)/1000.0;
		
		System.out.println("**** " +fpsMeter.getAverageFPS() + " FPS on average during " + totalTime +" s ****");
		System.out.println("Exiting ...");
	}
	
	
	// Run method
	
	@Override
	public void run() {
		double timeLastFrame = System.nanoTime();
		
		while(!Thread.interrupted()) {
			try {
				Thread.sleep(1000/FPS);
				
				this.gameLoop();
				fpsMeter.tick(timeLastFrame);
				fpsMeter.showCurrentFPS();
				timeLastFrame = fpsMeter.getTime();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
