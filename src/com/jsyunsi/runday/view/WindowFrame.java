package com.jsyunsi.runday.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * @author 王龙
 * @version 2020年8月20日 上午9:14:45
 * 窗体加载界面:进度条加载功能
 * 
 * 窗体568*340
 *
 */
public class WindowFrame extends JFrame implements Runnable{
	//2.1 声明背景图片变量
	JLabel backImage;
	
	//2.3声明进度条变量
	JProgressBar jdt;
	public  WindowFrame(){
		//2.2 创建图片变量
		backImage=new JLabel(new ImageIcon("image/hbg.jpg"));
		//布局         BorderLayout布局
		this.add(backImage,BorderLayout.NORTH);
		
		//2.4创建进度条变量
		jdt=new JProgressBar();
		jdt.setStringPainted(true);//设置进度条加载以字符串形式
		jdt.setBackground(Color.ORANGE);
		this.add(jdt,BorderLayout.SOUTH);
		
		
		this.setSize(568,340);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);
	}
	
	
	//创建线程并执行
	public void Start() {
		WindowFrame window= new WindowFrame();
		//创建当前窗体为线程
		Thread t=new Thread(window);
		//启动当前线程,(启动线程后，自动执行run方法）
		t.start();
		dispose();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowFrame().Start();

	}






	@Override
	public void run() {
		// 线程（不断）执行的方法
		//2.4  进度条的值
		int [] progressValue= {0,10,20,30,40,50,60,70,80,90,100};
		for(int i=0;i<progressValue.length;i++) {
			//线程休眠500ms
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将数组元素依次赋值给进度条
			jdt.setValue(progressValue[i]);
		}
		//关闭当前界面
		dispose();
		
		//跳转到主界面
		new GameFrame();
		
		
	}

}
