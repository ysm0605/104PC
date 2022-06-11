package manage_조오연_양수민;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import networkanddb.DB;
import networkanddb.*;

public class tttt extends JFrame implements ActionListener {
	
	private JLabel rsphone;
	private JTextField rstimetf;
	private JTextField rsphonetf;
	private JLabel rstime;
	private JButton modifypwbtn;
	private JTextField rspwtf;
	private JLabel rspw;
	private JTextField rsidtf;
	private JLabel rsid;
	private JTextField rsnametf;
	private JLabel rsname;
	private JLabel lb1;
	private JButton findbtn;
	private JTextField findphtf;
	private JTextField findnametf;
	private JLabel findph;
	private JLabel findname;
	private ResultSet rs;
	private JButton plus1btn;
	private JButton plus2btn;
	private JButton plus4btn;
	private JButton plus6btn;
	public tttt() {
		setTitle("고객 정보"); //타이틀
		setSize(500,450); //크기 설정
		setLocationRelativeTo(this);
		setLayout(null);
		setResizable(false);//크기 변경불가능하게 함. 
		
		findname = new JLabel("이름");
		findname.setBounds(10, 10, 50, 50);
		add(findname);
		
		findph = new JLabel("전화번호");
		findph.setBounds(10, 30, 50, 50);
		add(findph);
		
		findnametf = new JTextField();
		findnametf.setBounds(70, 25, 100, 20);
		add(findnametf);
		
		findphtf = new JTextField();
		findphtf.setBounds(70, 50, 100, 20);
		add(findphtf);
		
		//고객정보 찾기 버튼
		findbtn = new JButton("찾기");
		findbtn.setBounds(170, 25, 60, 45);
		findbtn.addActionListener(this);
		add(findbtn);
		
		lb1 = new JLabel("고객정보");
		lb1.setBounds(10, 70, 80, 80);
		add(lb1);
		
		//고객이름
		rsname = new JLabel("이름");
		rsname.setBounds(10, 110, 50, 50);
		add(rsname);
		rsnametf = new JTextField();
		rsnametf.setBounds(70, 125, 100, 20);
		add(rsnametf);
		
		//고객id
		rsid = new JLabel("id");
		rsid.setBounds(10, 140, 50, 50);
		add(rsid);
		rsidtf = new JTextField();
		rsidtf.setBounds(70, 155, 100, 20);
		add(rsidtf);
		
		//고객 pw
		rspw = new JLabel("pw");
		rspw.setBounds(10, 170, 50, 50);
		add(rspw);
		rspwtf = new JTextField();
		rspwtf.setBounds(70, 185, 100, 20);
		add(rspwtf);
		
		//고객 pw 변경버튼
		modifypwbtn = new JButton("초기화");
		modifypwbtn.setBounds(170, 180, 80, 30);
		modifypwbtn.addActionListener(this);
		add(modifypwbtn);
		
		//고객 남은 시간
		rstime = new JLabel("시간");
		rstime.setBounds(10, 200, 50, 50);
		add(rstime);
		rstimetf = new JTextField();
		rstimetf.setBounds(70, 215, 100, 20);
		add(rstimetf);
		
		//고객 핸드폰번호
		rsphone = new JLabel("핸드폰");
		rsphone.setBounds(10, 230, 50, 50);
		add(rsphone);
		rsphonetf = new JTextField();
		rsphonetf.setBounds(70, 245, 100, 20);
		add(rsphonetf);
		
		//시간추가버튼
		 plus1btn = new JButton("1시간 추가하기");
		 plus2btn = new JButton("2시간 추가하기");
		 plus4btn = new JButton("4시간 추가하기");
		 plus6btn = new JButton("6시간 추가하기");
		
		plus1btn.addActionListener(this);
		plus2btn.addActionListener(this);
		plus4btn.addActionListener(this);
		plus6btn.addActionListener(this);
		
		plus1btn.setBounds(300, 20, 150, 50);
		add(plus1btn);
		plus2btn.setBounds(300, 80, 150, 50);
		add(plus2btn);
		plus4btn.setBounds(300, 140, 150, 50);
		add(plus4btn);
		plus6btn.setBounds(300, 200, 150, 50);
		add(plus6btn);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == findbtn) {
			String findnamestr = findnametf.getText();
			String findphstr = findphtf.getText();
			String sqlname = "select name, id, pw, remaintime, phone from user where name = '"+findnamestr+"' and phone = '"+findphstr+"'";
			ResultSet rs = DB.getResultSet(sqlname);
			try {
				while (rs.next()) {
					String id = rs.getString("id");
					rsidtf.setText(id);
					String pw = rs.getString("pw");
					rspwtf.setText(pw);
					String name = rs.getString("name");
					rsnametf.setText(name);
					String phone = rs.getString("phone");
					rsphonetf.setText(phone);
					int time = rs.getInt("remaintime");
					String timestr = Integer.toString(time);
					rstimetf.setText(timestr);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
		}
		if(obj == plus1btn) {
			String checkingid = rsidtf.getText();
			String sql2 = "update user set remaintime = remaintime + 3600 where id = '"+checkingid+"'";
			DB.excuteSql(sql2);
			System.out.println("몇번?");
		}
		if(obj == plus2btn) {
			String checkingid = rsidtf.getText();
			String sql3 = "update user set remaintime = remaintime + 7200 where id = '"+checkingid+"'";
			DB.excuteSql(sql3);
			System.out.println("몇번?");
		}
		if(obj == plus4btn) {
			String checkingid = rsidtf.getText();
			String sql4 = "update user set remaintime = remaintime + 14400 where id = '"+checkingid+"'";
			DB.excuteSql(sql4);
			System.out.println("몇번?");
		}
		if(obj == plus6btn) {
			String checkingid = rsidtf.getText();
			String sql5 = "update user set remaintime = remaintime + 21600 where id = '"+checkingid+"'";
			DB.excuteSql(sql5);
			System.out.println("몇번?");
		}
		if(obj == modifypwbtn) {
			String checkingid = rsidtf.getText();
			String sql1 = "update user set pw = '123456789a' where id = '"+checkingid+"'";
			DB.excuteSql(sql1);
			JOptionPane.showMessageDialog(this, "변경완료");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB.init();
		tttt  t1 = new tttt();
	}
}
