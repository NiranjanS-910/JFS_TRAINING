package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class Practice {

	
	public static void main(String[] args) {
		String query="SELECT gmail, pass FROM Users;";
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "root";
		String pass= "Nethravarsha@1713";
		
		try{
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection established successfully...");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
				
		while(rs.next()){
//			int id =rs.getInt("userId");
			String email= rs.getString("gmail");
			String password = rs.getString("pass");
			
			System.out.println(email + " "+ password);
		}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

}
