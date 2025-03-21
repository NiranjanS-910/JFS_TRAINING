<%
if(session.getAttribute("username")==null){
	out.println("Session expired..!!");	
	
}
else{
	out.println("Welcome Back !! "+ session.getAttribute("username"));
}

%>
<a href='logout.jsp'>Log Outk</a> 