package userinterface_안지용;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class msgPop extends JFrame
{
	private ImageIcon img1;
	private Image img;

	public msgPop(String title)
	{
		setTitle(title);
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((res.width / 2) - 900, (res.height / 2) - 450);
		setSize(1200, 600);
		setResizable(false);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		//c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.setLayout(null);
		
		Font labelfont = new Font("맑은 고딕", Font.BOLD, 14);

		JButton kakaotalk = new JButton();
		JLabel kakaolabel = new JLabel("카카오톡");
		kakaolabel.setFont(labelfont);
		img1 = new ImageIcon("msg_image/카카오톡.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        kakaotalk.setIcon(img1);
        kakaotalk.setBounds(25, 5, 100, 100);
		kakaolabel.setBounds(47,110,150,30);
		kakaotalk.setBorderPainted(false);
		kakaotalk.setContentAreaFilled(false);
		kakaotalk.setFocusPainted(false);
		kakaotalk.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Process p = null;
				String[] kakaoTEx = new String[]
						{
							"C:\\Program Files (x86)\\KakaoTalk\\KakaoTalk.exe"	
						};
				try
				{
					p = new ProcessBuilder(kakaoTEx).start();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		JButton discord = new JButton();
		JLabel discordlabel = new JLabel("디스코드");
		discordlabel.setFont(labelfont);
		img1 = new ImageIcon("msg_image/discord.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        discord.setIcon(img1);
        discord.setBounds(160, 10, 100, 100);
        discordlabel.setBounds(183,110,150,30);
		discord.setBorderPainted(false);
		discord.setContentAreaFilled(false);
		discord.setFocusPainted(false);
		discord.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Process p = null;
				String[] kakaoTEx = new String[]
						{
							"C:\\Program Files (x86)\\Discord\\Discord.exe"	
						};
				try
				{
					p = new ProcessBuilder(kakaoTEx).start();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		c.add(kakaotalk);
		c.add(kakaolabel);
		c.add(discord);
		c.add(discordlabel);
		
		setVisible(true);
	}
}