package manage_조오연_양수민;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import garbage.SocketServer;
import garbage.ThreadServer;
import login_양수민_강현구.main;
import networkanddb.Server;

public class ManageForm extends JFrame implements ActionListener{
	
	private Container cp;
	private JButton[] btn;
	private Image image;
	private Image changeimage;
	private ImageIcon changeIcon;
	private JPanel leftArea, rightArea;
	private JPanel seat1, seat2, seat3, seat4, seat5, seat6;
	private JPanel option;
	private BufferedImage img;
	private ImageIcon icon;
	private Dimension res;
	private JButton[] seatbutton = new JButton[60];
	private List<String> iplist = new ArrayList<>() {
		{
			add("127.0.0.1");
			add("125.240.111.10");
			add("122.44.255.167");
		}
		};
		
	private Socket socket = null;
	private ServerSocket server_socket = null;
	private BufferedReader in = null;
	private ServerSocket server;
	private ArrayList<ThreadServer> list;
		
	public ManageForm() {
		//폼 세팅
		setTitle("관리자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLocation(this.getX() - 1800 / 2,this.getY() - 1000 / 2);
		setSize(1800, 1000);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setResizable(false);
		
		System.out.println("폼세팅");
		
		//배경화면 바꾸기
		icon = new ImageIcon("ciber_image/4.jpg");
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0 , 0, getWidth(), getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		System.out.println("배경화면 바꾸기");
		
		//바꾼 배경화면으로 컨탠트팬 변경
		setContentPane(background);
		cp = this.getContentPane();
		cp.setLayout(null);
		
		AddPanel();
		AddButton();
		
		cp.setFocusable(true);
		cp.requestFocus();
		
		
		setVisible(true);
	}

	
	private void AddButton() { // 버튼 추가 메소드
		//이미지 아이콘 세팅
		ImageIcon[] imgIcon = {
				new ImageIcon("button_image/회원관리.png"),
				new ImageIcon("button_image/주문목록.png"),
				new ImageIcon("button_image/매출관리.png"),
				new ImageIcon("button_image/재고관리.png")};
		
		//버튼 배열 생성
		btn = new JButton[4];
		//버튼 추가
		for (int i = 0; i < btn.length; i++) {
			//이미지 아이콘 크기 변환
			image = imgIcon[i].getImage();
			changeimage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			changeIcon = new ImageIcon(changeimage);
			
			//이미지 아이콘 추가
			btn[i] = new JButton(changeIcon);
			btn[i].setIcon(changeIcon);
			//btn[i].setBorderPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			btn[i].addActionListener(this);
			
			//각 버튼 위치 설정
			btn[i].setBounds(option.getSize().width / 2, 100 * (i+2), 150, 150);
			option.add(btn[i]);
		}		
	}
	
	//좌석 panel 및 버튼 추가
	private void AddPanel() {
		
		
		res = Toolkit.getDefaultToolkit().getScreenSize();
		
		leftArea = new JPanel();
		leftArea.setLayout(null);
		leftArea.setOpaque(false);
		leftArea.setBounds(0, 0, res.width / 3 * 1, res.height);
		
		seat1 = new JPanel();
		seat1.setBounds(40, 100, 560, 200);
		seat1.setLayout(new GridLayout(2,5,1,1));
		seat1.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i] = new JButton(i+1+"");
			seatbutton[i].setEnabled(false);
			seatbutton[i].addActionListener(this);
			seat1.add(seatbutton[i]);
			}
		leftArea.add(seat1);
		
		seat2 = new JPanel();
		seat2.setBounds(40, 360, 560, 200);
		seat2.setLayout(new GridLayout(2,5,1,1));
		seat2.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i+10] = new JButton(i+10+"");
			seatbutton[i+10].setEnabled(false);
			seatbutton[i+10].addActionListener(this);
			seat2.add(seatbutton[i+10]);
			}
		leftArea.add(seat2);
		
		seat3 = new JPanel();
		seat3.setBounds(40, 620, 560, 200);
		seat3.setLayout(new GridLayout(2,5,1,1));
		seat3.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i+20] = new JButton(i+20+"");
			seatbutton[i+20].setEnabled(false);
			seatbutton[i+20].addActionListener(this);
			seat3.add(seatbutton[i+20]);			
			}
		leftArea.add(seat3);
		
		rightArea = new JPanel();
		rightArea.setLayout(null);
		rightArea.setOpaque(false);
		rightArea.setBounds(res.width / 3 * 1, 0, res.width / 3 * 1, res.height);
		
		seat4 = new JPanel();
		seat4.setBounds(40, 100, 560, 200);
		seat4.setLayout(new GridLayout(2,5,1,1));
		seat4.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i+30] = new JButton(i+31+"");
			seatbutton[i+30].setEnabled(false);
			seatbutton[i+30].addActionListener(this);
			seat4.add(seatbutton[i+30]);
			}
		rightArea.add(seat4);
		
		seat5 = new JPanel();
		seat5.setBounds(40, 360, 560, 200);
		seat5.setLayout(new GridLayout(2,5,1,1));
		seat5.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i+40] = new JButton(i+41+"");
			seatbutton[i+40].setEnabled(false);
			seatbutton[i+40].addActionListener(this);
			seat5.add(seatbutton[i+40]);
			}
		rightArea.add(seat5);
		
		seat6 = new JPanel();
		seat6.setBounds(40, 620, 560, 200);
		seat6.setLayout(new GridLayout(2,5,1,1));
		seat6.setOpaque(false);
		for (int i = 0; i < 10; i++) {
			seatbutton[i+50] = new JButton(i+51+"");
			seatbutton[i+50].setEnabled(false);
			seatbutton[i+50].addActionListener(this);
			seat6.add(seatbutton[i+50]);
			}
		rightArea.add(seat6);
		
		cp.add(leftArea);
		cp.add(rightArea);
		
		option = new JPanel();
		option.setLayout(null);
		option.setOpaque(false);
		option.setBounds(res.width / 3 * 2, 0, res.width - (res.width / 3 * 2), res.height);
		cp.add(option);
		
		
		
	}
	
	public void setlogin(String ip, String user) {
		seatbutton[iplist.indexOf(ip)].setEnabled(true);
		seatbutton[iplist.indexOf(ip)].setText(user + "\n" + "으악");
	}
	
	public void setlogout(String ip) {
		seatbutton[iplist.indexOf(ip)].setEnabled(false);
		seatbutton[iplist.indexOf(ip)].setText(iplist.indexOf(ip) + 1 + "");
	}

	//서버 네트워크 세팅
	public void setserver() {
		
		//ThreadServer thread = new ThreadServer(this);
		//thread.start();
		Server server = new Server(this);
		server.start();

    }

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == btn[0]) {
			UserManageForm umf = new UserManageForm();
		}else if(obj == btn[1]) {
			Orders orders = new Orders();
		}else if(obj == btn[3]) {
			Inventory iv = new Inventory();
		}//else {
			//System.out.println(obj.toString().substring(
				//	obj.toString().lastIndexOf(",text")+6,obj.toString().lastIndexOf(",defaultCapable=")));
		//}
		
	}
}
