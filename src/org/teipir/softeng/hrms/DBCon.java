package org.teipir.softeng.hrms;
import java.lang.*;
import java.sql.*;

public class DBCon {
	Connection cn1;
	Statement st1;
	ResultSet rs1;
	PreparedStatement pst1;

	DBCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn1 = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
			st1 = cn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Connection Completed");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

	public static void main(String args[]) throws Exception {
		DBCon con = new DBCon();
	}
}