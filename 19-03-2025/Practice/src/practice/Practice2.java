package practice;
import java.sql.*;
public class Practice2 {

	public static void main(String[] args) {
		String query="DELETE FROM Users1 WHERE userId=?;";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Nethravarsha@1713");
			System.out.println("Connection established success...");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,1008);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");		
	}
		catch (SQLException e){
			e.printStackTrace();
		}

}
}