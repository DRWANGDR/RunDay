package com.jsyunsi.runday.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Background;

/**
 * @author 王龙
 * @version 2020年8月19日 上午10:23:28
 * 菜单栏：开始游戏 帮助 退出
 * 窗体宽度1000*600
 *
 */
public class MenuFrame extends JFrame implements MouseListener {
	
	JLabel startBtn,helpBtn,exit;

	
	public MenuFrame() {
		//开始
		startBtn=new JLabel(new ImageIcon("image/hh1.png"));
		startBtn.setBounds(300, 250, 150, 40);
		startBtn.setEnabled(false);
		
		//添加鼠标事件监听功能
		startBtn.addMouseListener(this);
		this.add(startBtn);
		//帮助
		helpBtn=new JLabel(new ImageIcon("image/hh2.png"));
		helpBtn.setBounds(300, 300, 150, 40);
		helpBtn.setEnabled(false);
		helpBtn.addMouseListener(this);
		this.add(helpBtn);
		
		
		//离开
		exit=new JLabel(new ImageIcon("image/hh3.png"));
		exit.setBounds(300,350,150,40);
		exit.setEnabled(false);
		exit.addMouseListener(this);
		this.add(exit);
		
		
		
		
		MenuBack back=new MenuBack();
		this.add(back);
		
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setUndecorated(true);
		this.setVisible(true);


		
		
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		new MenuFrame();
//		
//		
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub点击
		if(e.getSource().equals(startBtn)) {
			//跳转下一界面
			new WindowFrame().Start();

			//关闭当前界面
			dispose();
		}
		else if (e.getSource().equals(exit)) {
			System.exit(0);
		}
		else if (e.getSource().equals(helpBtn)) {
			//跳转帮助界面
			new HelpFrame();
			
			
			
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// 移入
		if(e.getSource().equals(startBtn)) {
			startBtn.setEnabled(true);
		}
		if(e.getSource().equals(helpBtn)) {
			helpBtn.setEnabled(true);
		}
		if(e.getSource().equals(exit)) {
			exit.setEnabled(true);
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// 移出
		if(e.getSource().equals(startBtn)) {
			startBtn.setEnabled(false);
		}
		if(e.getSource().equals(helpBtn)) {
			helpBtn.setEnabled(false);
		}
		if(e.getSource().equals(exit)) {
			exit.setEnabled(false);
		}
		
	}

	class MenuBack extends JPanel{
		Image background;
		public MenuBack()  {
			try {
				background=ImageIO.read(new File("image/main.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
		g.drawImage(background, 0, 0,1000,600, null);
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	}

