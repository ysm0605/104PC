package login_양수민_강현구;
//20220601 조오연추가

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;

import manage_조오연_양수민.ManageForm;
import networkanddb.*;
import userinterface_안지용.*;

public class login extends JFrame implements ActionListener {
	private JLabel jid;
	private JLabel jpw;
	private static TextField id;
	private TextField pw;
	private Container c;
	private JPanel p1;
	private JPanel p2;
	private JButton b_login;
	private JButton e_login;
	private JButton signup;
	private JButton find;
	private JButton restart;
	private Agree Singup;
	private ResultSet rs;
	private ImageIcon img1;
	private Image img;
	ImageIcon imgmap = new ImageIcon("loginimg/map.png");
	ImageIcon img104 = new ImageIcon("loginimg/104.png");
	ImageIcon imglogin = new ImageIcon("loginimg/loginimg.png");
	ImageIcon imgfind = new ImageIcon("loginimg/findimg.png");
	ImageIcon singuimg = new ImageIcon("loginimg/signupimg.png");
	ImageIcon logoimg = new ImageIcon("loginimg/logo.png");
	
	private JButton btnimg_map;
	private JButton btnimg_104;
	private JLabel titlellabel;
	private JLabel firelabel;
	private JButton btnimg_fire;
	private JLabel netlabel;
	private JLabel net1label;
	private JLabel net2label;
	private JLabel net3label;
	private JLabel firelabel1;
	private JLabel net4label;
	private JLabel net5label;
	private Container net6label;
	private JButton btnimg_logo;
	private JLabel sp;
	public maininterface mf;
	public login() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(260,130);
		setSize(1300, 800);
		setLayout(null);
		setResizable(false);
		
		
		c = this.getContentPane();
		ObjectAdd();
		c.setBackground(Color.gray);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
	}
	
	
	//로그인 화면 구성
	public void ObjectAdd() {
		titlellabel = new JLabel("104 PC");
		titlellabel.setBounds(800, 0, 500, 200);
		titlellabel.setFont(new Font("Serif",Font.BOLD,150));
		titlellabel.setForeground(Color.white);
		c.add(titlellabel);
		
		firelabel = new JLabel("※화재 시 대피할 곳은 운동장!!!");
		firelabel.setBounds(10, 650, 500, 200);
		firelabel.setFont(new Font("Serif",Font.BOLD,30));
		firelabel.setForeground(Color.RED);
		c.add(firelabel);
		
		firelabel1 = new JLabel("※위에 지도를 꼭 보시오.");
		firelabel1.setBounds(10, 750, 500, 200);
		firelabel1.setFont(new Font("Serif",Font.BOLD,30));
		firelabel1.setForeground(Color.RED);
		c.add(firelabel1);
		
		netlabel = new JLabel("104 PC는 다르다!");
		netlabel.setBounds(800, 200, 500, 200);
		netlabel.setFont(new Font("Serif",Font.BOLD,40));
		netlabel.setForeground(Color.white);
		c.add(netlabel);
		
		net1label = new JLabel("1.가장 빠른 인터넷!");
		net1label.setBounds(800, 270, 500, 200);
		net1label.setFont(new Font("Serif",Font.BOLD,30));
		net1label.setForeground(Color.white);
		c.add(net1label);
		
		net2label = new JLabel("2.인하공전에서 가까운 거리!");
		net2label.setBounds(800, 320, 500, 200);
		net2label.setFont(new Font("Serif",Font.BOLD,30));
		net2label.setForeground(Color.white);
		c.add(net2label);
		
		net3label = new JLabel("3.다른 PC방보다 좋은 사양의 컴퓨터!");
		net3label.setBounds(800, 370, 600, 200);
		net3label.setFont(new Font("Serif",Font.BOLD,30));
		net3label.setForeground(Color.white);
		c.add(net3label);
		
		net4label = new JLabel("4.다른 PC방보다 싼 가격!");
		net4label.setBounds(800, 420, 600, 200);
		net4label.setFont(new Font("Serif",Font.BOLD,30));
		net4label.setForeground(Color.white);
		c.add(net4label);
		
		net5label = new JLabel("5.인하공전 학생증 보여주면 공짜 1시간");
		net5label.setBounds(800, 470, 600, 200);
		net5label.setFont(new Font("Serif",Font.BOLD,30));
		net5label.setForeground(Color.white);
		c.add(net5label);
		
		net6label = new JLabel("6.코로나 걱정 NO 항상 소독");
		net6label.setBounds(800, 520, 600, 200);
		net6label.setFont(new Font("Serif",Font.BOLD,30));
		net6label.setForeground(Color.white);
		c.add(net6label);
		
		
		
		btnimg_map = new JButton(imgmap);
		btnimg_map.setBounds(10, 200, 750, 450);
		c.add(btnimg_map);
		
		btnimg_104 = new JButton(img104);
		btnimg_104.setBounds(1450, 200, 400, 650);
		c.add(btnimg_104);
		
		btnimg_logo = new JButton(logoimg);
		btnimg_logo.setBounds(10, 10, 150, 150);
		c.add(btnimg_logo);
		
		
		
		jid = new JLabel("아이디 : ");
		jid.setFont(new Font("Serif",Font.BOLD,20));
		jid.setBounds(810, 935, 90, 50);
		jid.setForeground(Color.white);
		c.add(jid);
		
		sp = new JLabel("___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		sp.setFont(new Font("Serif",Font.BOLD,20));
		
		sp.setBounds(0, 880, 2600, 50);
		sp.setForeground(Color.white);
		c.add(sp);
		
		id = new TextField();
		id.setBounds(900, 950, 150, 25);
		c.add(id);
		
		jpw = new JLabel("패스워드 : ");
		jpw.setBounds(800, 985, 100, 50);
		jpw.setForeground(Color.white);
		jpw.setFont(new Font("Serif",Font.BOLD,20));
		c.add(jpw);
		//350 150
		pw = new TextField();
		//비밀번호를 *모양으로 표시함
		pw.setEchoChar('*');
		pw.setBounds(900, 1000, 150, 25);
		pw.setFont(new Font("Serif",Font.BOLD,20));
		c.add(pw);
		
		
		b_login = new JButton(imglogin);
		b_login.setBounds(1060, 940, 80, 90);
		
		signup = new JButton(singuimg);
		signup.setBounds(1220, 940, 80, 90);
		
		find = new JButton(imgfind);
		find.setBounds(1140, 940, 80, 90);
		
		//restart = new JButton("새로고침");
		//restart.setBounds(1170, 660, 84, 30);
		
		img1 = new ImageIcon("button_image/종료.png");
        img = img1.getImage();
        img = img.getScaledInstance(30, 30, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
		e_login = new JButton(img1);  
		//버튼 외각선 제거
		e_login.setBorderPainted(false);
		//버튼 내용 안채움
		e_login.setContentAreaFilled(false);
        //마우스 커서 클릭가능으로 바꾸기
		e_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		e_login.setBounds(1800, 980, 75, 75);
		
		b_login.addActionListener(this);
		e_login.addActionListener(this);
		signup.addActionListener(this);
		find.addActionListener(this);
		
		c.add(b_login);
		c.add(e_login);
		c.add(find);
		c.add(signup);
		//c.add(restart);
	}

	public static String getId() {
		return id.getText();
	}

	

	public TextField getPw() {
		return pw;
	}
	
	public void showForm() {
		setVisible(true);
	}

	public void hideForm() {
		setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//로그인 이벤트 처리
		if (obj == b_login) {
			String a = id.getText();
			String b = pw.getText();
			int type = 1;
			int active = 1;
			DB db = new DB();
			String sql = "select type, active from user where pw='"+b+"'AND id ='"+a+"'";
			rs = DB.getResultSet(sql);
			
			try {
				if(rs.next()) {			
					//20220601 조오연 추가
					do {
						type = rs.getInt("type");
						active = rs.getInt("active");
					}while(rs.next());
					if (type == 0) {
						this.dispose();
						ManageForm mf = new ManageForm();
						mf.setserver();
					} else if(active == 0){
						JOptionPane.showMessageDialog(null, "회원탈퇴된 계정입니다.", "로그인 실패",JOptionPane.ERROR_MESSAGE);
					} else {
						DB.login_user();
						// 소켓 연결
						SocketClient client = new SocketClient(login.getId());
						client.start();
						id.setText("");
						pw.setText("");
						this.hideForm();
						new userinterface("104 PC방", this, client);
						mf = new maininterface("104");
					}
					//
				//메인 폼 추가하기
				}else {
					//로그인 실패시 메시지창 호출
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 확인하세요.", "로그인 실패",JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		//종료버튼
		} else if(obj == e_login) {
			System.exit(0);
		}
		//회원가입
		else if(obj == signup) {
			Singup = new Agree();
		}
		else if(obj == find) {
			JOptionPane.showMessageDialog(this, "카운터에게 문의하세요");
		}
	}
	
}