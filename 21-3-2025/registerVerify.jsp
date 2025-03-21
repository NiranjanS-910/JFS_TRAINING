<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>

<%
try{
String url="jdbc:mysql://localhost:3306/projectdb";
String name="root";
String pass="Nethravarsha@1713";

String driver="com.mysql.jdbc.Driver";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url,name,pass);
out.println("Success");

String username=request.getParameter("username");
String gmail=request.getParameter("gmail");
String userpass=request.getParameter("userpass");

String query1="SELECT * FROM Users1 WHERE gmail=?;";
PreparedStatement ps= con.prepareStatement(query1);
ps.setString(1,gmail);

ResultSet rs = ps.executeQuery();
if(rs.next()){
	%>
	<h3>User Already Exists</h3>
	<a href="index.jsp">Login</a>
	<% 
}
else{
	String query2="INSERT INTO Users1 (username,gmail,userpass) VALUES (?,?,?);";
	ps= con.prepareStatement(query2);
	ps.setString(1,username);
	ps.setString(2,gmail);
	ps.setString(3,userpass);
	
	int rows =ps.executeUpdate();
	if(rows>0){
		%>
		<h3>User Added Successfully</h3>
		<a href="index.jsp">Login</a>
		<% 
	}
	else{
		%>
		<h3>Failed to Add user</h3>
		<a href="index.jsp">Login</a>
		<% 
	}
	
}
}
catch (SQLException e){
	e.printStackTrace();
}
%>
