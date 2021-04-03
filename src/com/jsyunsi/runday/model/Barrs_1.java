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
 * @version 2020年8月21日 上午9:15:06
 * 
 * 螃蟹障碍物类：
 *     图片数组，当前显示图片，图片显示宽高，初始位置坐标，用来切换坐标的参数变量
 *
 */
public class Barrs_1 {
	public static final int WIDTH=80;
	public static final int HEIGHT=90;
	private BufferedImage [] images;
	private BufferedImage  image;
	private int x,y;
	private int index;
	private int xSpeed;
	
	public Barrs_1() {
		// TODO Auto-generated constructor stub
		Random random=new Random();
		images= new BufferedImage[2];
		try {
			images[0]=ImageIO.read(new File("image/a2.png"));
			images[1]=ImageIO.read(new File("image/a4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image=images[0];
		index=0;
		xSpeed=2;
		x=GameFrame.WIDTH+WIDTH+random.nextInt(300);
	    y=430-HEIGHT;//落在桥上
	}
	public void step() {
		//图片切换
		image=images[index++/80%images.length];
		//坐标移动
		x-=xSpeed;
	}
	public void paintBarr_1(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	
	
	//判断当前障碍物是否越界
	public boolean isOutBounds() {
		return this.x<=-WIDTH;
		
	}
	
	
	
	
	
	public BufferedImage[] getImages() {
		return images;
	}
	public void setImages(BufferedImage[] images) {
		this.images = images;
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
