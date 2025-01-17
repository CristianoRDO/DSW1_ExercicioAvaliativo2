<%@page import="br.edu.ifsp.dsw1.model.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% var user = (User) session.getAttribute("user"); %>

<nav class="navbar navbar-expand-lg bg-warning">
	<div class="container-fluid">
		<a class="navbar-brand" href="<%= request.getContextPath() %>/application.do?action=logged">HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/application.do?action=getRegisterUserForm">Cadastrar Usuario</a></li>
				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/application.do?action=getRegisterOrderForm">Cadastrar Pedido</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Exibir Pedidos</a></li>
				<li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/application.do?action=logout">Logout</a></li>
				<li class="nav-item"><%= user.getName() %></li>
			</ul>
		</div>
	</div>
</nav>