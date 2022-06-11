package manage_조오연_양수민;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Orders extends JFrame implements MouseListener {
	private Container c;
	private String slist[] = {"피씨번호","아이디"};
	private Object hlist[] = {"피씨번호","아이디","총 액","결제방법","목록"};
	private JComboBox<String> combo;
	private JTextField tf1;
	private JButton bt1;
	private JTable jt;
	private JScrollPane jscp;
	private DefaultTableModel model;

	public Orders() {
		setTitle("주문현황"); //타이틀 회원가입이므로
		setSize(1000,900); //크기 설정
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		//setResizable(false);//크기 변경불가능하게 함. 
		
		c = this.getContentPane();
		c.setFocusable(true);//★
		c.requestFocus();//★
		ObjectAdd();
		
		setVisible(true);
	}
	
	public void ObjectAdd() {
		combo = new JComboBox<String> (slist);
		tf1 = new JTextField(25);
		bt1 = new JButton("검색");
		
		//값 리스트 배열에 등록, 추후 수정
		Object clist[][] = {{"데이터1","데이터2","데이터3","데이터4","데이터5"}};
		
		model = new DefaultTableModel(clist,hlist) {						//★이게 뭔지 모르겠다.
			@Override public boolean isCellEditable(int row, int column) {
	            return false;
	        }
		};
		
		jt = new JTable(model); //제이테이블 생성
		jt.getColumn("피씨번호").setPreferredWidth(30);//셀의 크기 조절
		jt.getColumn("아이디").setPreferredWidth(120);//셀의 크기 조절
		jt.getColumn("총 액").setPreferredWidth(100);//셀의 크기 조절
		jt.getColumn("결제방법").setPreferredWidth(50);//셀의 크기 조절
		jt.getColumn("목록").setPreferredWidth(500);//셀의 크기 조절
		
		
		jt.addMouseListener(this);
		//jt.setEditable(false);
		
		//스크롤팬에 jtable추가
		jscp = new JScrollPane(jt); //내용이 많아지면 스크롤로 봐야하므로
		jscp.setPreferredSize(new Dimension(950,800));//★Dimension객체를 인자로 받으면서 해당 콤포넌트의 기본크기를 결정
		
		c.add(combo);
		c.add(tf1);
		c.add(bt1);
		c.add(jscp);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JTable t = (JTable)e.getSource();
		new Clear();
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

}

class Clear extends JFrame {
	public Clear() {
		setTitle("check"); //타이틀 회원가입이므로
		setSize(250,100); //크기 설정
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		//setResizable(false);//크기 변경불가능하게 함. 
		JLabel lb = new JLabel("고객님 상품을 드렸나요?");
		
		JButton btn = new JButton("완료");
		
		add(lb);
		add(btn);
		
		setVisible(true);
	}
}
