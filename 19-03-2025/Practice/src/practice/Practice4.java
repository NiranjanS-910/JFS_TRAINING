package practice;

import java.sql.*;

public class Practice4 {

	public static void main(String[] args) {
		String query="SELECT * FROM Users1;";
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Nethravarsha@1713");
			System.out.println("Connection established success...");
			PreparedStatement ps = con.prepareStatement(query);

			
			ResultSet rs= ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getInt("userId") + " " +
				rs.getString("username") + " " +
				rs.getString("gmail") + " " +
				rs.getString("userpass"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
