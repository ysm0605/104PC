//강현구_SignUp
package login_양수민_강현구;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import networkanddb.DB;

public class SignUp extends JFrame implements ActionListener{
	
	private static Connection conn;
	private static Statement stat;
	private JLabel name;
	private JLabel id;
	private JLabel pw;
	private JLabel address;
	private JLabel address2;
	private JLabel phone;
	private JTextField namefield;
	private JTextField idfield;
	private JTextField addressfield;
	private JTextField addressfield2;
	private JTextField phonefield;
	private JButton savebtn;
	private JButton cancelbtn;
	private JButton overlapbtn;
	private JButton findbtn;
	private JPasswordField pwfield;
	private JPasswordField pwfield2;
	private JLabel pw2;
	private JButton pwbtn;
	private JLabel pwif;
	private ResultSet result;
	
	public SignUp() {
		setTitle("회원가입"); //타이틀 회원가입이므로
		setSize(500,450); //크기 설정
		setLocationRelativeTo(this);
		setLayout(null);
		setResizable(false);//크기 변경불가능하게 함. 
		
		name = new JLabel("이름");//이름
		id = new JLabel("아이디");//아이디
		pw = new JLabel("패스워드");//패스워드
		pw2 = new JLabel("패스워드 재입력");//패스워드 재입력
		address = new JLabel("주소");//주소
		address2 = new JLabel("상세주소");//상세주소
		phone = new JLabel("전화번호");//번호
		pwif = new JLabel("※영문,숫자,특수문자 섞어 8~20글자 사이");//패스워드 정보주기
		
		namefield = new JTextField();//이름 입력창
		idfield = new JTextField();//아이디 입력창
		pwfield = new JPasswordField();//패스워드 입력창 !!JPasswordField를 이용해서 비번을 숨긴다.
		pwfield2 = new JPasswordField();//패스워드 재입력창 !!JPasswordField를 이용해서 비번을 숨긴다.
		addressfield = new JTextField();//주소 입력창
		addressfield2 = new JTextField();//상세주소 입력창
		phonefield = new JTextField();//전화번호 입력창

		
		savebtn = new JButton("저장");//저장버튼
		cancelbtn = new JButton("취소");//취소버튼
		pwbtn = new JButton("확인");//확인하기 버튼
		overlapbtn = new JButton("중복확인");//중복확인버튼
		findbtn = new JButton("주소찾기");//주소찾기버튼
		
		add(name);
		add(id);
		add(pw);
		add(pw2);
		add(address);
		add(address2);
		add(phone);
		add(namefield);
		add(idfield);
		add(pwfield);
		add(pwfield2);
		add(addressfield);
		add(addressfield2);
		add(phonefield);
		add(savebtn);
		add(cancelbtn);
		add(overlapbtn);
		add(findbtn);
		add(pwbtn);
		add(pwif);
		
		name.setBounds(40, 10, 40, 40);//위치 설정
		id.setBounds(40, 50, 40, 40);//위치 설정
		pw.setBounds(40, 90, 50, 40);//위치 설정
		pw2.setBounds(40, 170, 100, 40);//위치 설정
		address.setBounds(40, 210, 40, 40);//위치 설정
		address2.setBounds(40, 250, 50, 40);//위치 설정
		phone.setBounds(40, 290, 50, 40);//위치 설정
		namefield.setBounds(140, 10, 200, 30);//위치 설정
		idfield.setBounds(140, 50, 200, 30);//위치 설정
		pwfield.setBounds(140, 90, 200, 30);//위치 설정
		pwfield2.setBounds(140, 170, 200, 30);//위치 설정
		addressfield.setBounds(140, 210, 200, 30);//위치 설정
		addressfield2.setBounds(140, 250, 200, 30);//위치 설정
		phonefield.setBounds(140, 290, 200, 30);//위치 설정
		savebtn.setBounds(125, 340, 80, 30);//위치 설정
		cancelbtn.setBounds(240, 340, 80, 30);//위치 설정
		overlapbtn.setBounds(360, 50, 100, 30);//위치 설정
		findbtn.setBounds(360, 210, 100, 30);//위치 설정
		pwbtn.setBounds(360, 170, 100, 30);//위치 설정
		pwif.setBounds(150, 130, 250, 30);//위치 설정
		
		overlapbtn.addActionListener(this);
		pwbtn.addActionListener(this);
		cancelbtn.addActionListener(this);
		savebtn.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj ==pwbtn) {
			String pwcheck = pwfield.getText();
			String pwcheck2 = pwfield2.getText();
			if(pwcheck.equals(pwcheck2)) {
				JOptionPane.showMessageDialog(this, "일치합니다!");
			}else {
				JOptionPane.showMessageDialog(this, "불일치합니다. 다시 확인해주세요.");
			}
		}
		if(obj == overlapbtn) {
			String idcheck = idfield.getText();
			String sql = "select * from user where id ='"+idcheck+"'";
			result = DB.getResultSet(sql);
			try {
				if(result.next()) {			
					JOptionPane.showMessageDialog(this, "중복된 아이디입니다.");
				}else {
					JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(obj == cancelbtn) {
			dispose();//한 frame만 끔
		}
		if(obj==savebtn) {
			String namefinal = namefield.getText();
			String idfinal = idfield.getText();
			String pwfinal = pwfield.getText();
			String addressfinal = addressfield.getText();
			String addressfinal2 = addressfield2.getText();
			String phonefinal = phonefield.getText();
			String sql = "insert into user(id, pw, name, phone, address1, address2,remaintime) values ('"+namefinal+"','"+pwfinal+"','"+namefinal+"','"+phonefinal+"','"+addressfinal+"','"+addressfinal2+"',0)";
			DB.excuteSql(sql);
			JOptionPane.showMessageDialog(this, "회원가입 성공");
			dispose();
		}
	}
	
}