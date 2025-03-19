package practice;

import java.sql.*;

public class Practice3 {

	public static void main(String[] args) {
		String query="UPDATE Users1 SET username = ?, gmail=?, userpass=? WHERE userId=?;";
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Nethravarsha@1713");
			System.out.println("Connection established success...");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,"niranjans");
			ps.setString(2,"niranjan.navsak@gmail.com");
			ps.setString(3,"niranjan@123");
			ps.setInt(4, 1000);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
