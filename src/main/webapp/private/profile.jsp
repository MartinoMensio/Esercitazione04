<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:attribute name="header">
      <%@include file="/components/navbar.jsp"%>
    </jsp:attribute>
	<jsp:attribute name="footer">
      <div id="pagefooter" class="row">
			<%@include file="../components/footer.jsp"%>
		</div>
    </jsp:attribute>
	<jsp:body>
	<div style="padding-top: 50px;">
		<h1>Profile</h1>
		<p> TODO Show the user profile</p>
		<p> TODO The user should also be able to modify the profile</p>
    </div>
    </jsp:body>
</t:template>