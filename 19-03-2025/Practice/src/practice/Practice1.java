package practice;

import java.sql.*;

public class Practice1 {

	public static void main(String[] args) {
		String query = "INSERT INTO Users1 (username, gmail, userpass) VALUES (?, ?, ?);";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Nethravarsha@1713");
			System.out.println("Connection established success...");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,"niranjan");
			ps.setString(2,"niranjan.navsak@gmail.com");
			ps.setString(3,"niranjan@123");
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
