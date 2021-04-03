package com.jsyunsi.runday.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author 王龙
 * @version 2020年8月18日 下午3:19:14
 * 登陆界面：用户名   用户名输入框    密码   密码输入框   登录   取消   按钮    背景颜色
 *
 */
public class LoginFrame extends JFrame{
	
	
	//用户名 密码 
		JLabel userLabel;
		JLabel pwdLabel;
		//用户名输入框
		JTextField userText;
		JPasswordField pwdText;
		JButton loginBtn;
		JButton cancelBtn;
		//用户名输入框的内容和密码输入框的内容
		String userName;
		String password;
		
		
	public LoginFrame() {
		//创建用户名对象
		userLabel=new JLabel("用户名:");
		//绝对定位布局
		userLabel.setBounds(30, 160, 150, 30);
		this.add(userLabel);
		
		//创建用户名输入框
		userText=new JTextField();
		//布局
		userText.setBounds(80, 160, 125, 25);
		//设置输入框边框凹陷效果
		userText.setBorder(BorderFactory.createLoweredBevelBorder());
		//设置背景透明
		userText.setOpaque(false);
		
		this.add(userText);

		pwdLabel=new JLabel("密    码:");
		//绝对定位布局
		pwdLabel.setBounds(30, 220, 150, 30);
		this.add(pwdLabel);
		
		//创建密码输入框
		pwdText=new JPasswordField();
		//布局
		pwdText.setBounds(80, 220, 125, 25);
		//设置输入框边框凹陷效果
		pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
		//设置背景透明
		pwdText.setOpaque(false);
		
		this.add(pwdText);
		
		
		//创建  登录按钮  和   取消按钮对象
		loginBtn =new JButton("登录");
		loginBtn.setBounds( 60 ,250,60,30);
		//设置前景色   背景色
	    loginBtn.setForeground(Color.orange);
	    loginBtn.setBackground(Color.WHITE);
	    //设置边框颜色
	    loginBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    //添加登录按钮监听事件
	    loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 获取输入框的用户名和密码
				userName=userText.getText();
				password=pwdText.getText();
				//登录正确的情况下
				if("王龙".equals(userName)&&"1".equals(password)) {
					//登录成功
					JOptionPane.showMessageDialog(null, "欢迎"+userName+"来到天天酷跑！");
					//跳转到下一界面
					new MenuFrame();
					//关闭当前界面
					dispose();
				}
				else if(userName.length()==0||password.length()==0) {
					/**登录失败的情况(空*/
				    JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
				}else{
					/**登录失败的情况*/
				        JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			    }
		    }
	    });
	    
		this.add(loginBtn);
		
		cancelBtn=new JButton("取消");
		cancelBtn.setBounds(140 ,250,60,30);
		cancelBtn.setForeground(Color.orange);
		cancelBtn.setBackground(Color.white);
		cancelBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//添加取消按钮的监听事件
		cancelBtn.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 窗口提示
				JOptionPane.showMessageDialog(null, "确定离开？");
				//关闭当前界面
				dispose();//或者System.exit(0);所有相关页面全部关闭
			}
		});
			
		this.add(cancelBtn);
		
		
		
		
		
		//创建面板对象，并添加到窗体上去
		LoginBack back=new LoginBack();
		this.add(back);
		this.setSize(599, 330);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setUndecorated(true);
		//修改窗体的Logo图片
		this.setIconImage(new ImageIcon("image/115.png").getImage());
		//加载背景图片
		
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new LoginFrame();

	}

}
//登录界面面板类
class LoginBack extends JPanel{
	//背景图片变量
	Image background;
	public LoginBack()  {
		try {
			background=ImageIO.read(new File("image/login.jpg"));
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







