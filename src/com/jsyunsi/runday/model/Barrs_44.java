package com.jsyunsi.runday.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.jsyunsi.runday.view.GameFrame;

/**
 * @author 王龙
 * @version 2020年8月24日 上午10:26:53
 *
 */
public class Barrs_44 {
	public static final int WIDTH=36;
	public static final int HEIGHT=35;
	
	private BufferedImage  image;
	private int x,y;
	private int index;
	private int xSpeed;
	
	public Barrs_44() {
		// TODO Auto-generated constructor stub
		Random random=new Random();
		
		try {
			image=ImageIO.read(new File("image/"+(random.nextInt(6)+21)+".png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		index=0;
		xSpeed=2;
		x=GameFrame.WIDTH+WIDTH+random.nextInt(100);
	    y=100+random.nextInt(430-Barrs_1.HEIGHT-120);
	}
	public void step() {
		//图片切换
		
		//坐标移动
		x-=xSpeed;
	}
	public void paintBarr_44(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	
	
	//判断当前障碍物是否越界
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
