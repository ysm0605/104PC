package userinterface_안지용;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import networkanddb.DB;
import networkanddb.SocketClient;
import login_양수민_강현구.login;

public class userinterface extends JFrame implements ActionListener
{
	private static String user;
	private login login;
	private JButton pcOff;
	private SocketClient socket;
	
	public userinterface(String title, login login, SocketClient socket)
	{
		this.login = login;
		this.socket = socket;
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	// 현재 화면 크기 값 얻음
		setLocation(res.width - 440, 60);
		setSize(380, 350);
		setUndecorated(true);
		
		Container ctp = getContentPane();
		ctp.setBackground(Color.GRAY);
		

		ctp.setLayout(null);
		setResizable(false);
		
		Font userFont = new Font("맑은 고딕", Font.BOLD, 18);
		
		JLabel baeksalogo = new JLabel("104 PC");	// 104글자 or 이미지버튼으로 교체
		baeksalogo.setSize(100, 60);
		baeksalogo.setLocation(30, 10);
		baeksalogo.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		
		JButton timeAdd = new JButton("시간 추가");
		timeAdd.setSize(80, 30);
		timeAdd.setLocation(280, 10);
		timeAdd.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		timeAdd.setFocusPainted(false);
		
		JLabel tmleft = new JLabel("남은 시간 : ");
		tmleft.setSize(100, 40);
		tmleft.setLocation(250, 40);
		
		
		JLabel userid = new JLabel(user, JLabel.CENTER);		// 사용자 명
		userid.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		userid.setSize(125, 60);
		userid.setLocation(20, 80);
		userid.setFont(userFont);
		
		JLabel welcome = new JLabel("님 환영합니다!");
		welcome.setSize(150, 60);
		welcome.setLocation(150, 80);
		welcome.setFont(userFont);
		
		pcOff = new JButton("종료");	// 종료 아이콘 쓰기?, 팝업창?
		pcOff.setSize(60, 60);
		pcOff.setLocation(300, 80);
		pcOff.addActionListener(this);
		
		JLabel timeleft = new JLabel("00:00");	// 남은 시간
		timeleft.setSize(100, 40);
		timeleft.setLocation(320, 40);	// 패널 맨오른쪽 위
		
		JTextArea noticeArea  = new JTextArea("으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으으후루꾸꾸루후으");	//	공지 및 안내, 서버쪽에서 긁어오기? 
		noticeArea.setBackground(Color.WHITE);
		noticeArea.setEditable(false);
		noticeArea.setLineWrap(true);	// 자동 줄바꿈
		
		JScrollPane jscrollP = new JScrollPane(noticeArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jscrollP.setBorder(new EtchedBorder (EtchedBorder.RAISED));
		jscrollP.setSize(340, 80);
		jscrollP.setLocation(20, 170);
		jscrollP.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		JButton orderF = new JButton("주문");
		orderF.setSize(100, 70);
		orderF.setLocation(20, 260);
		orderF.setFocusPainted(false);
		
		JButton chatManage = new JButton("카운터 채팅");
		chatManage.setSize(100, 70);
		chatManage.setLocation(140, 260);
		chatManage.setFocusPainted(false);
		
		JButton moveSeat = new JButton("자리 이동");
		moveSeat.setSize(100, 70);
		moveSeat.setLocation(260, 260);
		moveSeat.setFocusPainted(false);
		
		ctp.add(baeksalogo);
		ctp.add(timeAdd);
		ctp.add(tmleft);
		ctp.add(userid);
		ctp.add(welcome);
		ctp.add(pcOff);
		ctp.add(timeleft);
		ctp.add(jscrollP);
		ctp.add(orderF);
		ctp.add(chatManage);
		ctp.add(moveSeat);

		setVisible(true);
		
		
	}
	public static void setUser(String a) {
		user = a;
		System.out.println(user);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if (obj == pcOff) {
			
			//socket.logout();
			this.dispose();
			login.mf.dispose();
			login.showForm();
		}
	}
}