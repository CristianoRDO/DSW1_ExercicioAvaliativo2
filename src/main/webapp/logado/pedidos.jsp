<%@page import="br.edu.ifsp.dsw1.model.entity.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html" />
<body>
	<jsp:include page="./includes/navBarLogado.jsp" />

	<%
	var pedidos = (List<Pedido>) request.getAttribute("pedidos");
	if (pedidos == null || pedidos.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/logado/index_logado.jsp");
	} else {
	%>
	<main class="container-sm flex-grow-1  justify-content-center">

		<%
		String msg = (String) request.getAttribute("errorMessage");
		if (msg != null ) {
			out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">");
			out.println(msg);
			out.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
		}
		%>

		<div class="card" style="margin-top: 24px;">
			<div class="card-body">
				<h5>Buscar Pedido</h5>
				<form action="contact.do?action=searchContact" method="post">
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="textName" placeholder="Nome do contato">
						<button class="btn btn-outline-warning" type="submit" id="button-addon2">Buscar</button>
					</div>
				</form>
			</div>
		</div>


		<h1 style="text-align: center; margin: 30px;">Contatos Cadastrados</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome do Cliente</th>
					<th scope="col">Endereço de Entrega</th>
					<th scope="col">Valor do Pedido</th>
					<th scope="col">Descrição</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<% 
			for (Pedido pedido : pedidos) { 
			%>
				<tr>
				    <th scope="row"><%= pedido.getIdPedido() %></th>
				    <td><%= pedido.getNomeCliente() %></td>
				    <td><%= pedido.getEndereco() %></td>
				    <td><%= pedido.getValor() %></td>
				    <td><%= pedido.getDescricao() %></td>
				    <td>
				        <a class="btn btn-outline-danger" 
				           onclick="return confirm('Confirma a exclusão?');" 
				           href="application.do?action=deleteOrder&id=<%= pedido.getIdPedido() %>">
				           Apagar
				        </a>
				    </td>
				    <td>
				        <a class="btn btn-outline-danger" 
				           href="#">
				           Editar
				        </a>
				    </td>
				</tr>
			<% 
			} 
			%>
			</tbody>
		</table>

	</main>
	<%} %>
	<jsp:include page="../includes/scripts.html" />
</body>
</html>