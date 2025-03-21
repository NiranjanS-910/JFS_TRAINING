<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import =  "java.sql.* " %>
<% 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/projectdb";
		Connection con = DriverManager.getConnection(url, "root", "Nethravarsha@1713");

		String usermail = request.getParameter("usermail");
		String userpass = request.getParameter("userpass");

		// Query to check login details and fetch role
		String query = "SELECT * FROM Users1 WHERE gmail = ? AND userpass = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, usermail);
		ps.setString(2, userpass);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			// Fetch user details
			int userId = rs.getInt("userId");
			String username = rs.getString("username");
			String role = rs.getString("roles"); // Fetch role from DB

			// Store in session
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			session.setAttribute("usermail", usermail);
			session.setAttribute("roles", role);

			// Redirect based on role
			if ("admin".equalsIgnoreCase(role)) {
				response.sendRedirect("admin.jsp");
			} else {
				response.sendRedirect("success.jsp");
			}
		} else {
			out.println("User not found!");
			out.println("<a href='index.jsp'>Login Again</a>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
	