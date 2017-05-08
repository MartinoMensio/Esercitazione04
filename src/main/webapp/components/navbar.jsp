<jsp:useBean id="loginService"
	class="it.polito.ai.businesslogic.LoginServiceImpl" scope="session"></jsp:useBean>

<div class="navbar-header">
	<a class="navbar-brand" href="#">WebSiteName</a>
</div>
<ul class="nav navbar-nav">
	<li><a href="index.jsp">Home</a></li>
	<li><a href="shop.jsp">Shop</a></li>
	<li><a href="cart.jsp">Cart</a></li>
	<%
		if (loginService.isLoggedIn()) {
	%>
	<li><a href="private/profile.jsp"><%=loginService.getUsername()%></a></li>
	<li>
		<form action="logout" class="navbar-form" method="post">
			<input class="btn" type="submit" value="Logout">
		</form>
	</li>
	<%
		} else {
	%>
	<li><a href="login.jsp">Login</a></li>
	<li><a href="register.jsp">Register</a></li>
	<%
		}
	%>
</ul>