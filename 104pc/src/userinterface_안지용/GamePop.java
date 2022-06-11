package userinterface_안지용;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GamePop extends JFrame
{
	private ImageIcon img1;
	private Image img;

	public GamePop(String title)
	{
		setTitle(title);
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((res.width / 2) - 900, (res.height / 2) - 450);
		setSize(1200, 600);
		setResizable(false);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		Font labelfont = new Font("맑은 고딕", Font.BOLD, 14);

		//c.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton lostark = new JButton();
		JLabel lostarklabel = new JLabel("로스트 아크");
		lostarklabel.setFont(labelfont);
		img1 = new ImageIcon("game_image/로스트아크.jpg");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
		lostark.setIcon(img1);
		lostark.setBounds(25, 25, 100, 100);
		lostarklabel.setBounds(38,115,150,30);
		lostark.setBorderPainted(false);
		lostark.setContentAreaFilled(false);
		lostark.setFocusPainted(true);
		lostark.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String laURL = "https://lostark.game.onstove.com/Main";
					Desktop.getDesktop().browse(new URI(laURL));
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예기치 않은 오류 발생");
				}
				catch (URISyntaxException e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예기치 않은 오류 발생");
				}
			}
		});
		
		JButton maplestory = new JButton();
		JLabel maplelabel = new JLabel("메이플스토리");
		img1 = new ImageIcon("game_image/메이플.png");
        img = img1.getImage();
        img = img.getScaledInstance(75,75, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
		maplestory.setIcon(img1);
		maplestory.setBounds(150, 25, 100, 100);
		maplelabel.setBounds(158,115,150,30);
		maplelabel.setFont(labelfont);
		maplestory.setBorderPainted(false);
		maplestory.setContentAreaFilled(false);
		maplestory.setFocusPainted(false);
		maplestory.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String msURL = "https://maplestory.nexon.com/Home/Main";
					Desktop.getDesktop().browse(new URI(msURL));
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예기치 않은 오류 발생");
				}
				catch (URISyntaxException e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "예기치 않은 오류 발생");
				}
			}
		});
		
		c.add(lostark);
		c.add(lostarklabel);
		c.add(maplestory);
		c.add(maplelabel);
		
		setVisible(true);
	}
}