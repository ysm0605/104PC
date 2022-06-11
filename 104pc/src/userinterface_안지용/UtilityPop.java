package userinterface_안지용;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UtilityPop extends JFrame
{
	private ImageIcon img1;
	private Image img;

	public UtilityPop(String title)
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
		
		Runtime rt = Runtime.getRuntime();
		Font labelfont = new Font("맑은 고딕", Font.BOLD, 14);
		
		
		JButton iex = new JButton();
		JLabel iexlabel = new JLabel("인터넷");
		iexlabel.setFont(labelfont);
		img1 = new ImageIcon("Utility_image/익스플로러.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        iex.setIcon(img1);
        iex.setBounds(25, 5, 100, 100);
        iexlabel.setBounds(50,105,50,30);
		iex.setBorderPainted(false);
		iex.setContentAreaFilled(false);
		iex.setFocusPainted(false);
		iex.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Process p = null;
				String[] iexEx = new String[]
						{
								"C:\\Program Files\\Internet Explorer\\iexplore.exe"
						};
				try
				{
					p = new ProcessBuilder(iexEx).start();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JButton chrome = new JButton();
		JLabel chromelabel = new JLabel("Chrome");
		chromelabel.setFont(labelfont);
		img1 = new ImageIcon("Utility_image/크롬.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        chrome.setIcon(img1);
        chrome.setBounds(160, 5, 100, 100);
        chromelabel.setBounds(181,105,150,30);
        chrome.setBorderPainted(false);
        chrome.setContentAreaFilled(false);
        chrome.setFocusPainted(false);
		chrome.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Process p = null;
				String[] chromeEx = new String[]
						{
								"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
						};
				try
				{
					p = new ProcessBuilder(chromeEx).start();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		JButton firefox = new JButton();
		JLabel firefoxlabel = new JLabel("파이어 폭스");
		firefoxlabel.setFont(labelfont);
		img1 = new ImageIcon("Utility_image/파이어폭스.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        firefox.setIcon(img1);
        firefox.setBounds(285, 5, 100, 100);
        firefoxlabel.setBounds(297,105,150,30);
        firefox.setBorderPainted(false);
        firefox.setContentAreaFilled(false);
        firefox.setFocusPainted(false);
		firefox.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Process p = null;
				String[] firefoxEx = new String[]
						{
								"C:\\Program Files\\Mozilla FireFox\\firefox.exe"
						};
				try
				{
					p = new ProcessBuilder(firefoxEx).start();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		c.add(iex);
		c.add(iexlabel);
		c.add(chrome);
		c.add(chromelabel);
		c.add(firefox);
		c.add(firefoxlabel);
		
		setVisible(true);
	}
}