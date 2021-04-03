package com.jsyunsi.runday.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 王龙
 * @version 2020年8月20日 下午4:44:19
 *
 */
public class HelpFrame extends JFrame{

	public HelpFrame() {
		
		
		
		//创建面板对象，并添加到窗体上去
				HelpBack back=new HelpBack();
				this.add(back);
				this.setSize(599, 330);
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
				this.setUndecorated(false);
				//修改窗体的Logo图片
				this.setIconImage(new ImageIcon("image/115.png").getImage());
				//加载背景图片
				
				this.setVisible(true);
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		new HelpFrame();
//	}

		
	
	class HelpBack extends JPanel{
		//背景图片变量
		Image background;
		public HelpBack()  {
			try {
				background=ImageIO.read(new File("image/bzbg.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(background, 0, 0, null);
			
		}
	}

}
