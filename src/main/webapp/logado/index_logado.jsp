<%@page import="br.edu.ifsp.dsw1.model.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html" />
<body>
	<jsp:include page="./includes/navBarLogado.jsp" />

	<% var user = (User) session.getAttribute("user"); %>
	
	<main class="container-sm flex-grow-1  justify-content-center">
		<h1 style="text-align: center; margin: 30px;">Bem-Vindo, <%= user.getName() %>!</h1>
	</main>

	<jsp:include page="../includes/scripts.html" />
</body>
</html>