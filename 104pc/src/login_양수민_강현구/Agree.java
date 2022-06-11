	package login_양수민_강현구;

import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;


public class Agree extends JFrame implements ActionListener, ItemListener {
	

	private Container c;
	public JCheckBox jcb1;
	private JLabel jl1;
	private JTextField jtf1;
	public JCheckBox jcb2;
	private JTextField jtf2;
	private JLabel jl2;
	private JButton jbtn1;
	private JButton jbtn2;
	private SignUp test;
	public int i = 0;
	public int j = 0;
	public int k = 0;

	public Agree() {
		setTitle("약관 동의");
		setLocation(560,130);
		setSize(800, 850);
		setLayout(null);
		setResizable(false);
		
        Font myFont1 = new Font("굴림체", Font.BOLD, 24);
		
		c = this.getContentPane();
		
		jl1 = new JLabel("서비스 약관 동의");
		jl1.setBounds(150, 130, 200, 50);
		jl1.setFont(myFont1);
		
		
		jcb1 = new JCheckBox();
		jcb1.setBounds(130, 140, 25, 25);
		
		jtf1 = new JTextField();
		jtf1.setBounds(130, 170, 500, 200);
		
		jl2 = new JLabel("개인정보 수집 및 이용 동의");
		jl2.setBounds(150, 430, 400, 50);
		jl2.setFont(myFont1);
		
		
		jcb2 = new JCheckBox();
		jcb2.setBounds(130, 440, 25, 25);
		
		jtf2 = new JTextField();
		jtf2.setBounds(130, 470, 500, 200);
		
		jbtn1 = new JButton("계속하기");
		jbtn1.setBounds(330, 710, 100, 50);
		jbtn1.setEnabled(false);

		jbtn2 = new JButton("닫기");
		jbtn2.setBounds(700, 760, 59, 40);

		
		
		c.add(jl1);
		c.add(jcb1);
		c.add(jtf1);
		c.add(jl2);
		c.add(jcb2);
		c.add(jtf2);
		c.add(jbtn1);
		c.add(jbtn2);

		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		
		
		
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		
		
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//닫기
		if (obj == jbtn2) {
			dispose();
		}//회원가입 창 띄우기
		else if(obj == jbtn1) {		
			test = new SignUp();
			dispose();

		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		//체크박스 선택 유무 확인
		
		if(e.getStateChange()== ItemEvent.SELECTED) {
			k = 1;
		}else {
			k=0;
		}
		//체크박스 둘다 선택시 버튼 보임
		if(e.getItem()==jcb1&&k==1) {
			i = 1;
			if(2==i+j)
			jbtn1.setEnabled(true);
		}else if(e.getItem()==jcb2&&k==1) {
			j = 1;
			if(2==i+j) 			
			jbtn1.setEnabled(true);
			
		}else if(e.getItem()==jcb1&&k==0) {
			i=0;
			jbtn1.setEnabled(false);
		}else if(e.getItem()==jcb2&&k==0) {
			j=0;
			jbtn1.setEnabled(false);
		}
		}
}



