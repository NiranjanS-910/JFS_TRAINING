<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .center {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .table-container {
            width: 60%;
        }
    </style>
</head>
<body class="container mt-5">
    <div class="center">
        <h3 class="text-center mb-4">All Users</h3>

        <%@page import="java.sql.*" %>

        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Nethravarsha@1713");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Users1");
        %>

        <div class="table-container">
            <table class="table table-bordered text-center">
                <thead class="table-dark">
                    <tr>
                        <th>User Name</th>
                        <th>User Email</th>
                        <th>User Password</th>
                    </tr>
                </thead>
                <tbody>
                    <% while(rs.next()){ %>
                        <tr>
                            <td><%= rs.getString("username") %></td>
                            <td><%= rs.getString("gmail") %></td>
                            <td><%= rs.getString("userpass") %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <%
            } catch (Exception e) {
                e.getStackTrace();
            }
        %>
    </div>
</body>
</html>