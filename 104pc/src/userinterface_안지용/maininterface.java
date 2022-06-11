package userinterface_안지용;

import java.awt.Color;
import login_양수민_강현구.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class maininterface extends JFrame
{

	
	public maininterface(String title)
	{
		setTitle(title);
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	// 현재 화면 크기 값 얻음
		setLocation((res.width / 2) - 450, res.height - 200);
		setSize(900, 100);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setUndecorated(true);
		
		Container ct = getContentPane();
		ct.setBackground(Color.DARK_GRAY);
		ct.setLayout(new GridLayout());
		
		JButton gameButton = new JButton("게임");		//	이미지 버튼으로 교체?
		gameButton.setFont(new Font("이태릭", Font.ITALIC ,30));
		gameButton.setFocusPainted(false);
		gameButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new GamePop("게임");
			}
		});
		
		JButton utilityButton = new JButton("유틸리티 & 인터넷");
		utilityButton.setFont(new Font("이태릭", Font.ITALIC, 30));
		utilityButton.setFocusPainted(false);
		utilityButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new UtilityPop("유틸리티 & 인터넷");
			}
		});
		
		JButton mesProg = new JButton("메신저 프로그램");
		mesProg.setFont(new Font("이태릭", Font.ITALIC, 30));
		mesProg.setFocusPainted(false);
		mesProg.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new msgPop("메신저 프로그램");
			}
		});
		
		
		ct.add(gameButton);
		ct.add(utilityButton);
		ct.add(mesProg);
		
		
		
		
		
		setVisible(true);
	}

	public void close(maininterface a) {
		this.dispose();
	}



}

	
