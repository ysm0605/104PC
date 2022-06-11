

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.modelmbean.ModelMBean;

// import Inventory.*;

public class DB {
	private static Connection conn;
	private static Statement stat ;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	//DB 연결 한번하면 됨
	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://ec2-3-39-194-110.ap-northeast-2.compute.amazonaws.com/104pc?useSSL=false", "gumci", "gumci1213");
			stat = conn.createStatement();
			
			System.out.println("DB 연결 OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB접속 오류 발생");
			e.printStackTrace();
		}
	}
	
	/* 조회용 (select)
	 * String sql = "select id, pw, name from user";
	 * ResultSet rs = db.getResultSet(sql);
	 * while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int grade = rs.getInt("name");
				System.out.println(id+"\t"+pw+"\t"+name+"\t");
			}
	 */
	public static ResultSet getResultSet(String sql) {
		try {
			Statement stat = conn.createStatement();
			return stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/* 수정용 (insert, update, delete)
	 * 
	 * insert문
	 * String sql = "insert into user(id, pw, name) values ('"+id변수+"','"+패스워드변수+"','"+name변수+"')";
	 * db.excuteSql(sql);
	 * 
	 *
	 * update 문
	 * String sql = "update user set id = '"+id변수+"', pw = '"+pw변수+"', name = '"+name변수"')";
	 * db.excuteSql(sql)
	 * 
	 */
	
	public static void excuteSql(String sql) {
		try {
			//stat.executeUpdate(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//메뉴 추가하기
	public static void abc(String sql,String b, int c, int d) {
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b);
				pstmt.setInt(2, c);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, d);
				

				pstmt.executeUpdate();
				System.out.println("성공");
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("실패");
			}
		
	}
	
	//새로고침
	public static void refresh(String sql) {
	
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int quantity = rs.getInt("quantity");
			int sold = rs.getInt("sold");
			//Inventory.model.addRow(new Object[] {false,"기타",name,quantity,sold,price});
			//System.out.println(name+"|"+price+"|"+quantity+"|"+sold);
		}
	} catch (SQLException e) {
		System.out.println("새로고침 실패");
		e.printStackTrace();
	}
	
	
	}
	
	
}