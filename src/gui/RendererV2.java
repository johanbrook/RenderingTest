package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.util.Random;

public class RendererV2 implements Renderer{

	private BufferedImage image;
	private int width;
	private int height;
	
	public RendererV2(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.initImage();
	}
	
	private void initImage()
	{
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_3BYTE_BGR);
		
		WritableRaster raster = (WritableRaster) this.image.getRaster();
		Random r = new Random();
		
		if (raster.getDataBuffer().getDataType() == DataBuffer.TYPE_BYTE) {
			
			for (int i = 0; i < raster.getWidth(); i++) {
				for (int j = 0; j < raster.getHeight(); j++) {
					int[] pixels = {r.nextInt(255),r.nextInt(255),r.nextInt(255)};
					raster.setPixel(i, j, pixels);
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
//		this.initImage();
		g.drawImage(image, 0, 0, width, height, null);
	}

	
}
