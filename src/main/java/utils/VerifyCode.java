package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode {
	private int w = 70;
	private int h = 35;
 	private Random r = new Random();
	private String[] fontNames  = {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"};
	private String codes  = "0123456789";
	private Color bgColor  = new Color(240, 240, 240);
	private String text ;
	
	
	private Color randomColor () {
		int red = r.nextInt(256);
		int green = r.nextInt(256);
		int blue = r.nextInt(256);
		return new Color(red, green, blue);
	}
	
	private Font randomFont () {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 30; 
		return new Font(fontName, style, size);
	}
	
	private void drawLine (BufferedImage image) {
		int num  = 5;
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		for(int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h); 
			g2.setStroke(new BasicStroke(1.5F)); 
			g2.setColor(Color.BLUE); 
			g2.drawLine(x1, y1, x2, y2);
		}
	}
	
	private char randomChar () {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	private BufferedImage createImage () {
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); 
		Graphics2D g2 = (Graphics2D)image.getGraphics(); 
		g2.setColor(this.bgColor);
		g2.fillRect(0, 0, w, h);
 		return image;
	}
	
	public BufferedImage getImage () {
		BufferedImage image = createImage(); 
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		StringBuilder sb = new StringBuilder();
		// 向图片中画4个字符
		for(int i = 0; i < 4; i++)  {
			String s = randomChar() + ""; 
			sb.append(s); 
			float x = i * 1.0F * w / 4; 
			g2.setFont(randomFont()); 
			g2.setColor(randomColor()); 
			g2.drawString(s, x, h); 
		}
		this.text = sb.toString(); 
		//干扰线
//		drawLine(image); 
		return image;
	}
	
	public String getText () {
		return text;
	}
	
	public static void output (BufferedImage image, OutputStream out) 
				throws Exception {
		ImageIO.write(image, "JPEG", out);
		out.flush();
	}
}
