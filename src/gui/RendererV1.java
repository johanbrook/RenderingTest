package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RendererV1 implements Renderer{
	
	private DrawableObject2[] drawables;
	
	public RendererV1()
	{
		
		int width = 100;
		int height = 70;
		int tileWidth = 1000/width;
		int tileHeight = 700/height;
		
		this.drawables = new DrawableObject2[width*height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				drawables[i*height+j] = new DrawableObject2(i*tileWidth, j*tileHeight, tileWidth, tileHeight);
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		
		for (DrawableObject2 dO : this.drawables) {
			dO.draw(g);
		}
	}
	
	public class DrawableObject1 {
		
		private BufferedImage i;
		
		public int x;
		public int y;
		public int width;
		public int height;
		
		public DrawableObject1(int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
			this.i = Colors.getRandomImage();
		}
		
		public void draw(Graphics g) {
			g.drawImage(this.i, x,y,width,height,null);
		}
	}
	public class DrawableObject2 {
		
		private BufferedImage i;
		
		public int x;
		public int y;
		public int width;
		public int height;
		
		public DrawableObject2(int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
			this.i = Colors.getImages();
		}
		
		public void draw(Graphics g) {
			g.drawImage(this.i, x,y,width,height,null);
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
					
					bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
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