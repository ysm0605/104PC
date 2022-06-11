package manage_조오연_양수민;

import java.awt.Color;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import networkanddb.*;

public class Inventory extends JFrame implements ActionListener {

	private Container c;
	private Object [] title = {"선택","상품분류", "상품명","남은재고","판매개수","판매가격"};
	private JTable table;
	private JScrollPane sp;
	private JButton jbt1;
	private Vector vc;
	private JLabel lbl1;
	private JLabel lbl2;
	private JButton jbt2;
	public static DefaultTableModel model;
	private ImageIcon img1;
	private Image img;
	private ImageIcon img2;
	private JButton jbt3;
	private JCheckBox q;
	private JCheckBox box;
	private JCheckBox ch;
	private JButton jbt4;
	private DefaultTableCellRenderer celAlignCenter;
	private DefaultTableCellRenderer celAlignRight;
	private JTextField tf;
	private JButton jbt5;
	private Color Color;
	private int count = 0;
	public static String co = "aa";
	
	public static Vector<String> ex;
	
	public Inventory() {
		setTitle("상품 관리");
		setLocation(560,130);
		setSize(800, 850);
		setLayout(null);
		setResizable(false);
		
		

		c = this.getContentPane();
		
		
		vc = new Vector<String>();
		vc.add("선택");
		vc.add("상품분류");
		vc.add("상품명");
		vc.add("남은재고");
		vc.add("판매개수");
		vc.add("판매가격");

		
		//표 테이블 생성
		box = new JCheckBox();
		model = new DefaultTableModel(null, title);
		table = new JTable(model){
			//체크박스
		      public Class getColumnClass(int column) {
		          //return Boolean.class
		          return getValueAt(0, column).getClass(); 
		        }
		      };
		
		model.addRow(title);
		
		
		
		//새로고침	
		ref();
        
		//오른쪽 정렬
		celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumn("남은재고").setCellRenderer(celAlignRight);
		table.getColumn("판매개수").setCellRenderer(celAlignRight);
		table.getColumn("판매가격").setCellRenderer(celAlignRight);

		//table.getColumn("선택").setCellEditor(new DefaultCellEditor(true));
		
		
		

		//테이블 수정 불가능
		//table.setEnabled(false);
		sp = new JScrollPane(table);
        sp.setBounds(30, 160, 300, 100);
        
        sp.setSize(700,500);
        
        
        
        
        //폰트 변경
        Font myFont1 = new Font("맑은 고딕", Font.BOLD, 34);
        
        lbl1 = new JLabel("재고 관리");
        lbl1.setBounds(35, 30, 160, 50);
        lbl1.setFont(myFont1);
        
        lbl2 = new JLabel("상품명 검색");
        lbl2.setBounds(30, 95, 160, 20);
        myFont1 = new Font("맑은 고딕", Font.PLAIN, 18);
        lbl2.setFont(myFont1);

        //표 타이틀 너비 지정
        table.getColumn("판매가격").setPreferredWidth(15);
        table.getColumn("판매개수").setPreferredWidth(10);
        table.getColumn("남은재고").setPreferredWidth(10);
        table.getColumn("상품분류").setPreferredWidth(10);
        table.getColumn("상품명").setPreferredWidth(150);
        

        //추가하기 버튼
        img1 = new ImageIcon("button_image/추가하기.png");
        img = img1.getImage();
        img = img.getScaledInstance(50, 50, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        
        jbt1 = new JButton(img1);        
        jbt1.setBounds(490,100, 50, 50);
        //jbt1.setBorderPainted(false);
        //버튼 내용 안채움
        jbt1.setContentAreaFilled(false);
        //마우스 커서 클릭가능으로 바꾸기
        jbt1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //새로고침 버튼
        img1 = new ImageIcon("button_image/새로고침.png");
        img = img1.getImage();
        img = img.getScaledInstance(50, 50, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        jbt2 = new JButton(img1);        
        jbt2.setBounds(550,100, 50, 50);
        jbt2.setContentAreaFilled(false);
        jbt2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //지우기 버튼
        img1 = new ImageIcon("button_image/지우기.png");
        img = img1.getImage();
        img = img.getScaledInstance(50, 50, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        jbt3 = new JButton(img1);        
        jbt3.setBounds(670,100, 50, 50);
        jbt3.setContentAreaFilled(false);
        jbt3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //수정 버튼
        img1 = new ImageIcon("button_image/수정.png");
        img = img1.getImage();
        img = img.getScaledInstance(50, 50, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        jbt4 = new JButton(img1);        
        jbt4.setBounds(610,100, 50, 50);
        jbt4.setContentAreaFilled(false);
        jbt4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //검색바
        tf = new JTextField(30);
        tf.setBounds(30,120,322,30);
        
        //검색 버튼
        img1 = new ImageIcon("button_image/검색.png");
        img = img1.getImage();
        img = img.getScaledInstance(30, 30, img.SCALE_SMOOTH);
        img1 = new ImageIcon(img);
        jbt5 = new JButton(img1);        
        jbt5.setBounds(350,120, 30, 30);
       
        jbt5.setContentAreaFilled(false);
        jbt5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Color = new Color(000000);
        jbt5.setBackground(Color);
        
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);
        jbt3.addActionListener(this);
        jbt4.addActionListener(this);
        jbt5.addActionListener(this);

        
        
        add(lbl1);
        add(lbl2);
		add(sp);
		add(jbt1);
		add(jbt2);
		add(jbt3);
		add(jbt4);
		add(jbt5);
		add(tf);
		
		//sp.updateUI();
		//table.updateUI();
		
		
		c.setFocusable(true);
		c.requestFocus();
		setVisible(true);
		
		
	}
	private void getColumn(int i) {
		// TODO Auto-generated method stub
		
	}
	//새로고침 매서드
	public static void ref() {
		String sql = "SELECT name, price, quantity, sold FROM menu";			
		DB.init();
		model.setNumRows(0);
        DB.refresh(sql);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbt1) {
			//추가하기 버튼
			addInventory ad = new addInventory();
		}else if (obj ==jbt2) {
			//새로고침 버튼
			ref();
	        table.updateUI();
		}else if (obj == jbt5) {
			//검색하기 버튼
			String sear = tf.getText();		
			String sql = "SELECT * FROM menu where name LIKE '%"+sear+"%'";			

			DB.init();
			model.setNumRows(0);
	        DB.refresh(sql);
		}else if(obj == jbt3) {
			//삭제 버튼
			for (int j = 0; j < table.getRowCount(); j++) {

				Boolean ck = Boolean.valueOf((boolean) table.getValueAt(j, 0));
				String col = table.getValueAt(j, 2).toString();
				
			if(ck) {
				//System.out.println(col);
				//JOptionPane.showMessageDialog(null, col);
				String sql =  "DELETE FROM menu where name ='"+col+"'";
				DB.init();
				DB.excuteSql(sql);
				ref();
			}}
		}else if(obj == jbt4) {
			//수정 버튼
			


			for (int j = 0; j < table.getRowCount(); j++) {

			Boolean ck = Boolean.valueOf((boolean) table.getValueAt(j, 0));
			
			
			if(ck) {
				co = table.getValueAt(j, 2).toString();
				//System.out.println(col);
				//JOptionPane.showMessageDialog(null, col);
				editInventory ad = new editInventory();
				//String sql = "UPDATE menu SET NAME = ?, PRICE = ? WHERE name = '"+co+"'";
				//DB.init();
				//DB.excuteSql(sql);
				//ref();
			}
			
		}
	}
		}
}