<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		
	</head>
	<body>
			<h1>Login Page</h1>
			<form action="loginreg.jsp" method="post">
				<input type="email" name="usermail" placeholder="Enter Mail Id" required><br>
				<input type="password" name="userpass" placeholder="Password" required><br>
				<button type="submit" class="btn btn-dark">Submit</button>
				<button type="reset" class="btn btn-dark">reset</button>
			</form>
			<a href="register.jsp">Register Here</a>
	</body>
</html>