package com.jsyunsi.runday.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.jsyunsi.runday.control.GamePanel;
import com.jsyunsi.runday.view.GameFrame;

/**
 * @author 王龙
 * @version 2020年8月21日 上午11:32:32
 *
 *  云梯
 */
public class Barrs_2 {
	public static final int WIDTH=200;
	public static final int HEIGHT=37;
	private BufferedImage  image;
	private int x,y;
	private int xSpeed;
	
	

	
	
	
	public Barrs_2() {
		try {
			image=ImageIO.read(new File("image/hhh.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		xSpeed=2;
		Random random=new Random();
		x=GameFrame.WIDTH+WIDTH+random.nextInt(300);
		
		y=250;
		
	}
	public void step() {
		//坐标移动
		x-=xSpeed;
		
	}
	public void paintBarr_2(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}
	public boolean isOutBounds() {
		return this.x<=-WIDTH;
		
	}
	
	
	
	
	
	
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getxSpeed() {
		return xSpeed;
	}
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	
}
