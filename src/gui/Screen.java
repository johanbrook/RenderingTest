package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Screen extends JFrame{

	private core.ViewController controller;
	private BufferedImage offScreen;
	private Graphics backgroundBuffer;

	public Screen(core.ViewController controller, int width, int height)
	{
		this.controller = controller;
		this.getContentPane().setPreferredSize(new Dimension(width,height));
		
		this.offScreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.backgroundBuffer = offScreen.getGraphics();
		
		this.pack();
		
		this.setVisible(true);
		this.addWindowListener(new ExitListener());
		
	}
	
	public Graphics getBackgroundBuffer()
	{
		return this.backgroundBuffer;
	}
	public void render()
	{
		Graphics g = this.getContentPane().getGraphics(); 	
		g.drawImage(this.offScreen, 0, 0, this.getWidth(), this.getHeight(), null);
		
		this.backgroundBuffer.setColor(java.awt.Color.WHITE);
		this.backgroundBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	private class ExitListener extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			controller.onShutdown(event);
			System.exit(0);
		}
	}
}
