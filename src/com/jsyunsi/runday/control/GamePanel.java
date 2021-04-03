package com.jsyunsi.runday.control;

import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jsyunsi.runday.model.Barrs_1;
import com.jsyunsi.runday.model.Barrs_2;

import com.jsyunsi.runday.model.Barrs_33;

import com.jsyunsi.runday.model.Barrs_44;
import com.jsyunsi.runday.model.Barrs_5;
import com.jsyunsi.runday.model.Person;
import com.jsyunsi.runday.view.EndFrame;
import com.jsyunsi.runday.view.GameFrame;
import com.jsyunsi.runday.view.MenuFrame;
import com.sun.javafx.embed.swing.Disposer;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author 王龙
 * @version 2020年8月20日 上午10:36:56
 *核心逻辑类：
 *绘制玩家对象，并实现键盘事件
 *绘制五种障碍物、并实现障碍物的字移动功能
 *实现碰撞逻辑
 *实现暂停，继续功能
 *实现结束逻辑
 *
 *1.实现背景图片的滚动效果功能
 *  1.1加载静态背景图片
 *   1.2
 *  2.玩家对象
 *     2.1创建玩家对象
 *     
 *     
 *     
 *  螃蟹障碍物出现的逻辑
 *    1.创建实体类BArrs——1.java
 *    2.在GamePanel中创建数组对象barrs1
 *    3.在enteredAction添加螃蟹的逻辑代码
 *    
 *    
 *    
 */
public class GamePanel extends JPanel implements KeyListener{
//1.1背景图片变量
	
	private Image background;
	//2.1.1声明玩家对象
	Person person;
	//3.1声明螃蟹障碍物数组
	Barrs_1 [] barrs1 = {};
	Barrs_2 [] barrs2 = {};
	Barrs_5 [] barrs5 = {};
	Barrs_44 [] barrs44 = {};
	Barrs_33 [] barrs33 = {};
	
	Barrs_1 barrs_1;
	Barrs_2 barrs_2;
	Barrs_5 barrs_5;
	Barrs_44 barrs_44;
	Barrs_33 barrs_33;
	JLabel helpBtn,exit;
	public GamePanel() {
		//2.2声明玩家对象person
		person=new Person();
		
		try {
			background=ImageIO.read(new File("image/cc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	int x=0;
	@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
		    x--;
			super.paint(g);
			//1.1.3绘制第一张静态背景图片
			g.drawImage(background, x, 0, GameFrame.WIDTH, GameFrame.HEIGTH, null);
		    //1.2.1 绘制第二张背景图片
			g.drawImage(background,x+GameFrame.WIDTH,0, GameFrame.WIDTH, GameFrame.HEIGTH, null);
	        //1.2.2实现图片连续滚动
			if(x<=-GameFrame.WIDTH) {
				x=0;
			}
		
			
			
			
			//2.1.3 调用Person中的绘制方法
			person.paintPerson(g);
			person.paintDog(g);
			//3.4绘制螃蟹障碍物
			for(int i=0;i<barrs1.length;i++) {
				barrs1[i].paintBarr_1(g);
			}
			for(int i=0;i<barrs2.length;i++) {
				barrs2[i].paintBarr_2(g);
			}
			for(int i=0;i<barrs5.length;i++) {
				barrs5[i].paintBarr_5(g);
			}
			for(int i=0;i<barrs44.length;i++) {
				barrs44[i].paintBarr_44(g);
			}
			for(int i=0;i<barrs33.length;i++) {
				barrs33[i].paintBarr_33(g);
			}
			
			//绘制玩家得分
			g.setFont(new Font("宋体",Font.BOLD,20));
			g.setColor(Color.ORANGE);
			g.drawString("玩家得分为："+person.getScore(), 100, 50);
			//跑酷距离
			g.setFont(new Font("宋体",Font.BOLD,20));
			g.setColor(Color.ORANGE);
			g.drawString("玩家跑酷距离为："+person.getDistance(), 300, 50);
	}
	//3.2生成障碍物的方法
	int index=0;
	public void enteredAction() {
		index++;
		if(index%800==0) {

			Barrs_1 b1=new Barrs_1();//生成一个螃蟹
			Barrs_2 b2=new Barrs_2();
			Barrs_5 b5=new Barrs_5();
			
			Barrs_33 b33= new Barrs_33();
			barrs1=Arrays.copyOf(barrs1,barrs1.length+1);//螃蟹数组扩容
			barrs1[barrs1.length-1]=b1;
			barrs2=Arrays.copyOf(barrs2,barrs2.length+1);
			barrs2[barrs2.length-1]=b2;
			barrs5=Arrays.copyOf(barrs5,barrs5.length+1);
			barrs5[barrs5.length-1]=b5;			
			
			barrs33=Arrays.copyOf(barrs33,barrs33.length+1);
			barrs33[barrs33.length-1]=b33;
		}
		if(index%200==0) {

			
			Barrs_44 b44=new Barrs_44();
					
			barrs44=Arrays.copyOf(barrs44,barrs44.length+1);
			barrs44[barrs44.length-1]=b44;
			
		}
	}
	//3.3障碍物移动方法
	public void stepAction() {
		person.step();//玩家移动
		person.drop();
	
		//螃蟹障碍物移动
		
	    for(int i=0;i<barrs1.length;i++){
	    	barrs1[i].step();
	    	
	    	if(barrs1[i].isOutBounds()) {
	    		barrs1[i]=barrs1[barrs1.length-1];
	    		barrs1=Arrays.copyOf(barrs1, barrs1.length-1);
	    	}
	    }

	    for(int i=0;i<barrs2.length;i++){
	    	barrs2[i].step();
	    	
	    	if(barrs2[i].isOutBounds()) {
	    		barrs2[i]=barrs2[barrs2.length-1];
	    		barrs2=Arrays.copyOf(barrs2, barrs2.length-1);
	    	}
	    }

	    for(int i=0;i<barrs5.length;i++){
	    	barrs5[i].step();
	    	
	    	if(barrs5[i].isOutBounds()) {
	    		barrs5[i]=barrs5[barrs5.length-1];
	    		barrs5=Arrays.copyOf(barrs5, barrs5.length-1);
	    	}
	    }
	    for(int i=0;i<barrs44.length;i++){
	    	barrs44[i].step();
	    	
	    	if(barrs44[i].isOutBounds()) {
	    		barrs44[i]=barrs44[barrs44.length-1];
	    		barrs44=Arrays.copyOf(barrs44, barrs44.length-1);
	    		
	    	}
	    }
	    for(int i=0;i<barrs33.length;i++){
	    	barrs33[i].step();
	    
	    	if(barrs33[i].isOutBounds()) {
	    		barrs33[i]=barrs33[barrs33.length-1];
	    		barrs33=Arrays.copyOf(barrs33, barrs33.length-1);
	    		
	    	}
	    }
	   
	    	
	    
		
		
	
	}
	//玩家和障碍物碰撞的方法逻辑
	
	
	public void pengAction() {
		//角色和金币的		

			for(int i=0;i<barrs44.length;i++) {
				if((person.getX()+Person.WIDTH>barrs44[i].getX()&&
					person.getX()<barrs44[i].getX()+Barrs_44.WIDTH&&
					person.getY()+Person.HEIGHT>barrs44[i].getY()&&
					person.getY()<barrs44[i].getY()+Barrs_44.HEIGHT)||
					(person.getX()+Person.WIDTH-Person.DOGWIDTH>barrs44[i].getX()&&
					person.getX()-person.DOGWIDTH<barrs44[i].getX()+Barrs_44.WIDTH&&
					315<barrs44[i].getY()+Barrs_44.HEIGHT&&
					315+person.DOGHEIGHT>barrs44[i].getY())) {
					
					//已经碰撞，玩家加分，金币消失
					person.setScore(person.getScore()+10);
					barrs44[i]=barrs44[barrs44.length-1];
					barrs44=Arrays.copyOf(barrs44, barrs44.length-1);
				}
			}
			//和螃蟹障碍物的碰撞
			for(int i=0;i<barrs1.length;i++)
			{
				if(person.getX()+Person.WIDTH>barrs1[i].getX()&&
				person.getX()<barrs1[i].getX()+Barrs_1.WIDTH&&
				person.getY()+Person.HEIGHT>barrs1[i].getY()&&
				person.getY()<barrs1[i].getY()+Barrs_1.HEIGHT) {
					if(person.getX()+Person.WIDTH <barrs1[i].getX()+Barrs_1.WIDTH/2) {
						person.setX(barrs1[i].getX()-Person.WIDTH);
					}
					else {
						person.setX(barrs1[i].getX()+Person.WIDTH);
					}
			   }
			}
			//和最上面障碍物的碰撞
			
			for(int i=0;i<barrs33.length;i++)
			{
					if(person.getX()+Person.WIDTH>barrs33[i].getX()&&
					person.getX()<barrs33[i].getX()+Barrs_33.WIDTH&&
					person.getY()+Person.HEIGHT>barrs33[i].getY()&&
					person.getY()<barrs33[i].getY()+Barrs_33.HEIGHT) {
						if(person.getX()+Person.WIDTH <barrs33[i].getX()+Barrs_33.WIDTH/2) {
							person.setX(barrs33[i].getX()-Person.WIDTH);
						}
						else {
							person.setX(barrs33[i].getX()+Person.WIDTH);
						}
				    }
					
		     }
			//和云梯的碰撞
			for(int i=0;i<barrs2.length;i++)
			{
				if(person.getX()+Person.WIDTH>=barrs2[i].getX()&&
					person.getX()<=barrs2[i].getX()+Barrs_2.WIDTH&&
					person.getY()+Person.HEIGHT>=barrs2[i].getY()&&
					person.getY()<=barrs2[i].getY()+Barrs_2.HEIGHT) {
//					if(person.getX()+Person.WIDTH >barrs2[i].getX()
//				       &&person.getY()<barrs2[i].getY()+barrs2[i].HEIGHT
//				       &&person.getY()+person.HEIGHT>barrs2[i].getY()) {
//						person.setX(barrs2[i].getX()-Person.WIDTH);
//					}
					if(person.getY()+Person.HEIGHT <= barrs2[i].getY()+barrs2[i].HEIGHT/2) {
						person.setY(barrs2[i].getY()-Person.HEIGHT);
					}
					if(person.getY()>= barrs2[i].getY()+barrs2[i].HEIGHT/2) {
						person.setY(barrs2[i].getY()+barrs2[i].HEIGHT);
					}
				}
				
				
				 
				
				   
				
				
				
				
					
		     }
			// 和导弹碰撞
			for(int i=0;i<barrs5.length;i++)
			{
				if(person.getX()+Person.WIDTH>barrs5[i].getX()&&
					person.getX()<barrs5[i].getX()+Barrs_5.WIDTH&&
					person.getY()+Person.HEIGHT>barrs5[i].getY()&&
					person.getY()<barrs5[i].getY()+Barrs_5.HEIGHT) {
						if(person.getX()+Person.WIDTH <barrs5[i].getX()+Barrs_5.WIDTH) {
							
							isGameOver = true;
							new EndFrame(person);
							person =new Person();
							barrs1=new Barrs_1[0];
							barrs2=new Barrs_2[0];
							barrs33=new Barrs_33[0];
							barrs44=new Barrs_44[0];
							barrs5=new Barrs_5[0];
							
						}
						
				    }
				
				
				
				
					
		     }
			
		
	}
	
	
	//跑酷距离数
	
	public void distnce() {
		
		person.setDistance(person.getDistance()+1);
		
	}
	//程序结束逻辑方法
	public  boolean isGameOver=false;
	public void gameOverAction() {
		if(person.getX()<=0-Person.WIDTH) {
			isGameOver = true;
			//跳转到结束界面
			
			new EndFrame(person);
			//清空当前界面数据
			person =new Person();
			barrs1=new Barrs_1[0];
			barrs2=new Barrs_2[0];
			barrs33=new Barrs_33[0];
			barrs44=new Barrs_44[0];
			barrs5=new Barrs_5[0];
		}
	}
	//1.2.3程序执行的方法（通过线程操作）
	boolean flag=true;
	
	public void action() {
		new Thread() {
			public void run() {
				
				while(!isGameOver) {
					
					if(flag) {
						enteredAction();
						stepAction();
						pengAction();
						gameOverAction();
						//1.2.4  重绘
					    repaint();
						
					}
					
					
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
		}.start();//创建一个线程，并启动
		new Thread() {
			public void run() {
				
				while(!isGameOver) {
					
					if(flag) {
						
						distnce();
						
				    	
					}
					
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
		}.start();//创建一个线程，并启动
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//  暂停/继续功能
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {//按空格暂停
			flag=!flag;		
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {//按空格暂停
			System.exit(0);	
		}
		
		// 按键盘时执行的方法
				//获取玩家当前位置
				int x= person.getX();
				int y=person.getY();
				//玩家跳跃，按  上建        y减小
				if((e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)&&y>=200) {
					person.setY(y-120);
				}
				if(person.getY()<=10) {
					person.setY(y);
				}
				
				if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D) {
					person.setX(x+20);
				}
				if(person.getX()>=900) {
					person.setX(x);
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A) {
					person.setX(x-20);
				}
				if(person.getX()<=10) {
					person.setX(x);
				}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
