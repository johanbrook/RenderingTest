package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RendererV1 implements Renderer{
	
	private DrawableObject[] drawables;
	
	public RendererV1(int width, int height)
	{
		
		int numWidth = 100;
		int numHeight = 70;
		
		int tileWidth = width/numWidth;
		int tileHeight = height/numHeight;
		
		this.drawables = new DrawableObject[numWidth*numHeight];
		for (int i = 0; i < numWidth; i++) {
			for (int j = 0; j < numHeight; j++) {
				drawables[i*numHeight+j] = new DrawableObject2(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		
		for (DrawableObject dO : this.drawables) {
			dO.draw(g);
		}
	}
	
	
	
	public static class Colors{
		
		private static BufferedImage bi;
		private static BufferedImage[] images;
		private static Random r;
		
		public static BufferedImage getRandomImage()
		{
			bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
			Graphics g = bi.getGraphics();

			Random r = new Random();
			g.setColor(new Color(r.nextInt(200), r.nextInt(200), r.nextInt(200)));
			g.fillRect(0, 0, 10, 10);
			return bi;
		}
		
		public static BufferedImage getImages()
		{
			int numberOfImages = 10;
			
			if (images == null) {
				
				r = new Random();
				images = new BufferedImage[numberOfImages];
				
				for (int i = 0; i < numberOfImages; i++) {

					bi = new BufferedImage(10, 10, BufferedImage.TYPE_3BYTE_BGR);
					Graphics g = bi.getGraphics();

					Random r = new Random();
					g.setColor(new Color(r.nextInt(200), r.nextInt(200), r.nextInt(200)));
					g.fillRect(0, 0, 10, 10);

					images[i] = bi;
				}
			}

			return images[r.nextInt(numberOfImages)];
		}
	}
}