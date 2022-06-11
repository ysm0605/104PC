package manage_조오연_양수민;

import java.sql.ResultSet;
import java.sql.SQLException;

import networkanddb.*;
public class module {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB db = new DB();
		db.init();
		
		//db.excuteSql("insert into user(id, pw, name) values('gumci', 'gumci1213', '조오연')");
		
		
		
		//db.getResultSet("select * from user");
		//ResultSet rs = db.getResultSet("delete from user where id = ''");
		//try {
		//	while (rs.next()) {
		//		System.out.println(rs);
		//	}
		// } catch (SQLException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		// }
		
	}

}
