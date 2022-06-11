package manage_조오연_양수민;

import java.awt.Component;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import networkanddb.*;



public class addInventory extends JFrame implements ActionListener{

private Container c;
private String [] s = {"라면류","음료류","간식류"};
private JComboBox combox;
private JTextField name;
private JButton btn1;
private JButton btn2;
private JTextField volume;
private JTextField price;
private Inventory inventory;
private JLabel jlbl1;
private Component jlbl2;
private JLabel jlbl3;
private JLabel jlbl4;
private PreparedStatement pstmt;
private Connection conn;

public addInventory() {
	setTitle("재고 추가");
	setLocation(660,230);
	setSize(400, 210);
	setLayout(null);
	setResizable(false);
	
	this.inventory = inventory;
	
	
	c = this.getContentPane();
	
	jlbl1 = new JLabel("상품분류");
    jlbl1.setBounds(35, 20, 60, 20);
    
	combox = new JComboBox(s);
    combox.setBounds(30, 40, 70, 30);


	jlbl2 = new JLabel("상품명");
    jlbl2.setBounds(130, 20, 60, 20);
    
    name = new JTextField();
    name.setBounds(120, 40, 60, 30);
    

	jlbl3 = new JLabel("입고수량");
    jlbl3.setBounds(205, 20, 60, 20);
    
    volume = new JTextField();
    volume.setBounds(200, 40, 60, 30);

	jlbl4 = new JLabel("판매가격");
    jlbl4.setBounds(285, 20, 60, 20);
    
    price = new JTextField();
    price.setBounds(280, 40, 60, 30);
    
    btn1 = new JButton("확인");
    btn1.setBounds(120, 100, 60, 40);
    
    btn2 = new JButton("취소");
    btn2.setBounds(200, 100, 60, 40);
    
	btn1.addActionListener(this);
	btn2.addActionListener(this);

	
	add(combox);
	add(name);
	add(volume);
	add(btn1);
	add(btn2);
	add(price);
	add(jlbl1);
	add(jlbl2);
	add(jlbl3);
	add(jlbl4);
	
	c.setFocusable(true);
	c.requestFocus();
	setVisible(true);
	
	
	}



@Override
public void actionPerformed(ActionEvent e) {
	Object obj = e.getSource();
	if(obj==btn1) {
		String [] a = new String[2] ;
			a[0] = combox.getSelectedItem().toString();
			a[1] = name.getText();
		int [] b = new int[2];
			b[0] = Integer.parseInt(price.getText());
			b[1] = Integer.parseInt(volume.getText());
			//이벤트 적용법 1.Inventory클래스 ex백터로 넘겨서 ex벡터의 값을 데이터 베이스에 저장하기(2차원벡터로 수정해야함)
			//이벤트 적용법 2.아래 for문에 있는 내용을 지우고 바로 데이터베이스에 넣고 
			//inventory클래스의 새로고침 버튼을 통해 데이터베이스 값을 가져와서 넣기
			
			String sql = "insert into menu(name, price, sold, quantity)";
			sql += " values (?,?,?,?)";
			DB.init();
			DB.abc(sql,a[1],b[0], b[1]);
			Inventory.ref();
			dispose();
	}else if (obj == btn2) {
		dispose();
	}
		
	
	}
}