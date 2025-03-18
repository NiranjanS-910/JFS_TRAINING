package Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			Connection con = DriverManager.getConnection(url, "root", "Nethravarsha@1713");
			System.out.println("Connection Established Successfully...");
			System.out.print("Enter the Mail : ");
			String mail = sc.next();
			String query="SELECT * FROM Users WHERE gmail ='"+mail+"';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				System.out.println("User Found!!");
//				String pass = rs.getString("pass");
//				
//				System.out.print("Enter the Password : ");
//				String password = sc.next();
//				
//				if(password.equals(pass)) {
//					System.out.println("Welcome back " + rs.getInt("userId"));
				}
				
			else {
				System.out.println("Enter the Password : ");
				String pass = sc.next();
				String query1 = "INSERT INTO Users (gmail,pass) VALUES ('"+mail+"','"+pass+"');";
				int rowAffect = st.executeUpdate(query1);
				if(rowAffect>0){
					System.out.println("Created.. ");
				}
				else{
					System.out.println("Failed");
				}
			}
			con.close();
			rs.close();
			st.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
