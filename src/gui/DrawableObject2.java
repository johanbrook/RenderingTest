package gui;

import gui.RendererV1.Colors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
			
			this.i = Colors.getRandomImage();
		}
		
		public void draw(Graphics g) {
			g.drawImage(this.i, x,y,width,height,null);
		}
	}