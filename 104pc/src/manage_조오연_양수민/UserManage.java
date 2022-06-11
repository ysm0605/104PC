package manage_조오연_양수민;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import networkanddb.*;
public class UserManage extends JFrame {
	private JLabel number;
	private JLabel name;
	private JLabel id;
	private JLabel pw;
	private JLabel address;
	private JLabel address2;
	private JLabel phone;
	private JLabel signdate;
	private JTextField numberfield;
	private JTextField namefield;
	private JTextField idfield;
	private JTextField addressfield;
	private JTextField address2field;
	private JTextField phonefield;
	private JTextField signdatefield;
	private JButton savebtn;
	private JButton cancelbtn;
	private JPasswordField pwfield;
	private JLabel remaintime;
	private JTextField remaintimefield;
	private DB db = new DB();

	public UserManage(String id) {
		setTitle("사용자 관리"); //타이틀 회원가입이므로
		setSize(420,350); //크기 설정
		setLocationRelativeTo(this);
		setLayout(null);
		setResizable(false);//크기 변경불가능하게 함. 
		
		ObjectAdd();
		userinfo(id);

		setVisible(true);
	}
	
	public void ObjectAdd() {
		//회원가입 레이블
		number = new JLabel("회원번호");
		name = new JLabel("이름");//이름
		id = new JLabel("아이디");//아이디
		pw = new JLabel("패스워드");//패스워드
		address = new JLabel("주소");//주소
		address2 = new JLabel("상세주소");//상세주소
		phone = new JLabel("전화번호");//번호
		signdate = new JLabel("가입일");
		remaintime = new JLabel("남은시간");
		
		
		//텍스트필드
		numberfield = new JTextField();
		namefield = new JTextField();//이름 입력창
		idfield = new JTextField();//아이디 입력창
		pwfield = new JPasswordField();//패스워드 입력창 !!JPasswordField를 이용해서 비번을 숨긴다.
		addressfield = new JTextField();//주소 입력창
		address2field = new JTextField();//상세주소 입력창
		phonefield = new JTextField();//전화번호 입력창
		signdatefield = new JTextField();//전화번호 입력창
		remaintimefield = new JTextField();

		//버튼
		savebtn = new JButton("저장");//저장버튼
		cancelbtn = new JButton("취소");//취소버튼

	
		add(number);
		add(numberfield);
		add(name);
		add(id);
		add(pw);
		add(address);
		add(address2);
		add(phone);
		add(namefield);
		add(idfield);
		add(pwfield);
		add(addressfield);
		add(address2field);
		add(phonefield);
		add(savebtn);
		add(cancelbtn);
		add(signdate);
		add(signdatefield);
		
		add(remaintime);
		add(remaintimefield);

		number.setBounds(40, 10, 60, 40);
		numberfield.setBounds(120, 10, 60, 30);
		numberfield.setHorizontalAlignment(JTextField.CENTER);
		
		signdate.setBounds(190, 10, 40, 40);//위치 설정
		signdatefield.setBounds(240, 10, 120, 30);//위치 설정
		signdatefield.setHorizontalAlignment(JTextField.CENTER);
		
		name.setBounds(40, 50, 40, 40);//위치 설정
		namefield.setBounds(120, 50, 80, 30);//위치 설정
		namefield.setHorizontalAlignment(JTextField.CENTER);
		
		id.setBounds(210, 50, 40, 40);
		idfield.setBounds(260, 50, 100, 30);
		idfield.setHorizontalAlignment(JTextField.CENTER);
		
		pw.setBounds(40, 90, 50, 40);//위치 설정
		pwfield.setBounds(120, 90, 240, 30);//위치 설정
		
		
		phone.setBounds(40, 130, 50, 40);//위치 설정정
		phonefield.setBounds(120, 130, 100, 30);//위치 설정
		phonefield.setHorizontalAlignment(JTextField.CENTER);
		
		remaintime.setBounds(230, 130, 60, 40);
		remaintimefield.setBounds(290, 130, 70, 30);
		remaintimefield.setHorizontalAlignment(JTextField.CENTER);

		address.setBounds(40, 170, 40, 40);//위치 설정
		addressfield.setBounds(120, 170, 240, 30);//위치 설정
		address2.setBounds(40, 210, 50, 40);//위치 설정
		address2field.setBounds(120, 210, 240, 30);//위치 설정
		
		savebtn.setBounds(100, 250, 80, 30);//위치 설정
		cancelbtn.setBounds(240, 250, 80, 30);//위치 설정
		
	}
	
	public void userinfo(String id) {
		String sql = "select number, id, name, pw, phone, address1, address2, regdate, remaintime from user where id = '"+id+"'";
		ResultSet rs = db.getResultSet(sql);
		System.out.println(rs);
		try {
			while (rs.next()) {
				numberfield.setText(String.valueOf(rs.getInt("number")));
				idfield.setText(rs.getString("id"));
				namefield.setText(rs.getString("name"));
				pwfield.setText(rs.getString("pw"));
				phonefield.setText(String.valueOf(rs.getInt("phone")));
				addressfield.setText(rs.getString("address1"));
				address2field.setText(rs.getString("address2"));
				signdatefield.setText(rs.getString("regdate"));
				remaintimefield.setText(String.valueOf(rs.getInt("remaintime")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
