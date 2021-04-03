package com.jsyunsi.runday.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jsyunsi.runday.model.Person;

import javafx.scene.text.Font;
import sun.applet.Main;

/**
 * @author 王龙
 * @version 2020年8月25日 上午10:28:48
 *
 */
public class EndFrame extends JFrame implements MouseListener{
	Person person;
	JLabel startBtn,helpBtn,exit;
	public static int Max[]= {0,0};
	
	

	public EndFrame(Person person) {
		// TODO Auto-generated constructor stub
		startBtn=new JLabel(new ImageIcon("image/hh5.png"));
		startBtn.setBounds(200, 150, 240, 100);
		startBtn.setEnabled(false);
		
		Max[1]=person.getScore()+person.getDistance();
		if(Max[0]<Max[1]) {
			Max[0]=Max[1];
		}
		//添加鼠标事件监听功能
		startBtn.addMouseListener(this);
		this.add(startBtn);
		//主界面
		helpBtn=new JLabel(new ImageIcon("image/hh6.png"));
		helpBtn.setBounds(200, 200, 240, 100);
		helpBtn.setEnabled(false);
		helpBtn.addMouseListener(this);
		this.add(helpBtn);
		
		exit=new JLabel(new ImageIcon("image/hh3.png"));
		exit.setBounds(280,300,75,20);
		exit.setEnabled(false);
		exit.addMouseListener(this);
		this.add(exit);
		
		EndBack back=new EndBack(person);
		this.add(back);
		this.setSize(605, 388);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setTitle("天天跑酷");
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		this.setVisible(true);
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(startBtn)) {
			//关闭当前界面
			dispose();
			//跳转下一界面
			new WindowFrame().Start();

			
		}
		else if (e.getSource().equals(exit)) {
			System.exit(0);
		}
		else if (e.getSource().equals(helpBtn)) {
			dispose();
			new MenuFrame();
		}
			
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
class EndBack extends JPanel{
	//背景图片变量
	Image background;
	Person person;
	public EndBack(Person person)
	{
		this.person=person;
		try
		{
			background=ImageIO.read(new File("image/chou.png"));//报错时点第二个
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
  		super.paint(g);
 		g.drawImage(background, 0, 0, null);
 		//g.setFont(new Font("宋体",Font.BOLD,18));
 		g.setColor(Color.ORANGE);
 		g.drawString((person.getScore()+person.getDistance())+"", 440, 210);
 		g.drawString(person.getScore()+"", 440, 305);
 		g.drawString(person.getDistance()+"", 440, 258);
 		g.drawString("历史最高纪录:"+EndFrame.Max[0], 10, 10);
 	}
	
}