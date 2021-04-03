package com.jsyunsi.runday.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.paint.Paint;

/**
 * @author 王龙
 * @version 2020年8月20日 上午11:33:29
 *玩家实体类：
 *   图片数组
 *   当前显示的图片
 *   图片宽高
 *   初始位置
 *   得分
 *   跑酷的距离
 *
 */
public class Person {
	//玩家坐标
	private int x,y;
	//玩家得分
	private int score;
	//玩家的宽高
	public static final int WIDTH=90;
	public static final int HEIGHT=90;
	public static final int DOGWIDTH=90;
	public static final int DOGHEIGHT=90;
	//人数图片数组
	private BufferedImage [] images= {};
	private BufferedImage [] dogimages= {};
	//当前显示图片
	private BufferedImage image;
	private BufferedImage dogimage;
	//玩家跑酷距离
	private int distance;
	//图片切换变量
	private int index;
	private int dogindex;
	
	public Person() {
		// TODO Auto-generated constructor stub
		
		score=0;
		index=0;
		dogindex=0;
		distance=0;
		x=70;
		y=315;
		images=new BufferedImage[9];//给数组创建空间
		for(int i=0;i<images.length;i++) {
			try {
				images[i]=ImageIO.read(new File("image/"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		image=images[0];
		dogimages=new BufferedImage[6];
		for(int i=0;i<dogimages.length;i++) {
			try {
				dogimages[i]=ImageIO.read(new File("image/d"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dogimage=dogimages[0];
	}
	public BufferedImage[] getDogimages() {
		return dogimages;
	}
	public void setDogimages(BufferedImage[] dogimages) {
		this.dogimages = dogimages;
	}
	public BufferedImage getDogimage() {
		return dogimage;
	}
	public void setDogimage(BufferedImage dogimage) {
		this.dogimage = dogimage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getDogindex() {
		return dogindex;
	}
	public void setDogindex(int dogindex) {
		this.dogindex = dogindex;
	}
	public static int getDogwidth() {
		return DOGWIDTH;
	}
	public static int getDogheight() {
		return DOGHEIGHT;
	}
	//玩家移动
	public void step() {
		//坐标移动(通过键盘事件来监听）
		
		//图片切换
		image=images[index++/40%images.length];
		dogimage=dogimages[dogindex++/80%dogimages.length];
	}
	//玩家自由落体运动
	public void drop() {
		y++;
		if(y>=315) {
			y=315;
		}
		
	}
	//绘制玩家方法
	public void paintPerson(Graphics g) {
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}
	public void paintDog(Graphics g) {
		g.drawImage(dogimage, x-70, 315, WIDTH, HEIGHT, null);
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	
	
	
	
	
	

}
