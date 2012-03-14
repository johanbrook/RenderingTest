package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Screen extends JFrame{
	
	private BufferedImage offScreen;
	private Graphics backgroundBuffer;

	public Screen(int width, int height)
	{
		this.getContentPane().setPreferredSize(new Dimension(width,height));
		
		this.getContentPane().setPreferredSize(new Dimension(width, height));
		
		this.offScreen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.backgroundBuffer = offScreen.getGraphics();
		
		this.pack();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public Graphics getBackgroundBuffer()
	{
		return this.backgroundBuffer;
	}
	public void render()
	{
		Graphics g = this.getContentPane().getGraphics(); 	
		g.drawImage(this.offScreen, 0, 0, this.getWidth(), this.getHeight(), null);
		
		this.backgroundBuffer.setColor(Color.WHITE);
		this.backgroundBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
