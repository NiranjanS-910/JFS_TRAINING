<%
session.setAttribute("userId",null);
session.setAttribute("username",null);
session.setAttribute("usermail",null);
session.setAttribute("userpass",null);
session.invalidate();
response.sendRedirect("index.jsp");
%>