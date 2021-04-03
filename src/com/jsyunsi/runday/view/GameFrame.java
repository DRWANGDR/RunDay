package com.jsyunsi.runday.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.function.ObjDoubleConsumer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jsyunsi.runday.control.GamePanel;

/**
 * @author 王龙
 * @version 2020年8月20日 上午10:27:16
 *游戏主界面
 *
 */
public class GameFrame extends JFrame{
	//设置窗体宽高
	public static final int WIDTH=1000;
	public static final int HEIGTH=550;
	
	GamePanel panel;
	
	public GameFrame() {
	
		panel=new GamePanel();
		
		
		
		
		panel.action();
		this.addKeyListener(panel);
		this.add(panel);
		
		
		//设置窗体基本属性
		this.setSize(WIDTH, HEIGTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setTitle("天天跑酷");
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);
		
		
		while(true) {
			if(panel.isGameOver) {
				dispose();
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
//	public static void main(String[] args) {
//		new GameFrame();
//		
//	}

}
