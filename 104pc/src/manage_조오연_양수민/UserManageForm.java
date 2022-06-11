package manage_조오연_양수민;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.protocol.Resultset;

import networkanddb.*;

public class UserManageForm extends JFrame implements MouseListener, ActionListener {
	private Container c;
	private String slist[] = {"이름","아이디"};
	private Object hlist[] = {"회원번호","아이디","이름"};
	private JComboBox<String> combo;
	private JTextField tf1;
	private JButton bt1;
	private JTable jt;
	private JScrollPane jscp;
	private DefaultTableModel model;
	Object clist[][] = {};
	
	private DB db = new DB();

	public UserManageForm() {
		setTitle("검색"); //타이틀 회원가입이므로
		setSize(400,400); //크기 설정
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		//setResizable(false);//크기 변경불가능하게 함. 
		
		c = this.getContentPane();
		c.setFocusable(true);
		c.requestFocus();
		ObjectAdd();
		
		setVisible(true);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			
			int row = jt.getSelectedRow();
			
			Object value= model.getValueAt(row, 1);
			
			System.out.println(value);
			UserManage user = new UserManage(value.toString());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//검색기능
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == bt1) {
			
			if (combo.getSelectedIndex() == 0) { 
				String sql = "select number,id,name from user where name like '%"+tf1.getText()+"%'"; 
				ResultSet rs = db.getResultSet(sql);
				tableadd(rs);
			}else {
				String sql = "select number,id,name from user where id like '%"+tf1.getText()+"%'";
				ResultSet rs = db.getResultSet(sql);
				tableadd(rs);
			}
		}
	}
	
	// 조회한 값에 대한 정보를 담는 메소드
	public void tableadd(ResultSet rs) {
		try {
			model.setNumRows(0);
			int number;
			String id, name;
			
			while (rs.next()) {
				number = rs.getInt("number");
				id = rs.getString("id");
				name = rs.getString("name");
				model.addRow(new Object[] {number, id, name});
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//폼 오브젝트 추가
	public void ObjectAdd() {
		combo = new JComboBox<String> (slist);
		tf1 = new JTextField(15);
		bt1 = new JButton("검색");
		bt1.addActionListener(this);
	
		
		//값 리스트 배열에 등록, 추후 수정
		
		model = new DefaultTableModel(hlist,0) {
			@Override public boolean isCellEditable(int row, int column) {
	            return false;
	        }
		};
		
		jt = new JTable(model);
		jt.getColumn("회원번호").setPreferredWidth(30);
		jt.getColumn("이름").setPreferredWidth(50);
		
		jt.addMouseListener(this);
		//jt.setEditable(false);
		
		//스크롤팬에 jtable추가
		jscp = new JScrollPane(jt);
		jscp.setPreferredSize(new Dimension(350,300));
		
		c.add(combo);
		c.add(tf1);
		c.add(bt1);
		c.add(jscp);
	}
	
	

}
