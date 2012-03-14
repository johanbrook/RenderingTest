package gui;
import gui.RendererV1.Colors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawableObject1 implements DrawableObject {
		
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
			
			this.i = Colors.getImages();
		}
		
		public void draw(Graphics g) {
			g.drawImage(this.i, x,y,width,height,null);
		}
	}