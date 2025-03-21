<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Page</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<style>
			body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-control {
            margin-bottom: 15px;
        }
        .btn {
            width: 100%;
        }
		</style>
	</head>
	<body>
	<div class="center">
	<h1>Registration Page</h1>
			<form action="registerVerify.jsp" method="post">
				<div class="mb-3">
                <input type="text" class="form-control" name="username" placeholder="Enter User Name" required>
            </div>
            <div class="mb-3">
                <input type="email" class="form-control" name="gmail" placeholder="Enter Mail Id" required>
            </div>
            <div class="mb-3">
                <input type="password" class="form-control" name="userpass" placeholder="Password" required>
            </div>
            <button type="submit" class="btn btn-dark">Submit</button>
            <button type="reset" class="btn btn-secondary mt-2">Reset</button>
			</form>
	</div>
	</body>
</html>