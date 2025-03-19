package practice;

import java.sql.*;

public class Practice5 {

	public static void main(String[] args) {
		String query="SELECT * FROM Users1;";
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Nethravarsha@1713");
			System.out.println("Connection established success...");
//			PreparedStatement ps = con.prepareStatement(query);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println(meta.getColumnCount());
			System.out.println(meta.getColumnName(1));
			System.out.println(meta.getColumnTypeName(1));
			System.out.println(meta.getTableName(1));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
