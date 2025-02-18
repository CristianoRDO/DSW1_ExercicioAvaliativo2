<%@page import="br.edu.ifsp.dsw1.model.entity.Pedido"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html" />
<body>
	<jsp:include page="./includes/navBarLogado.jsp" />

	<main class="container-sm flex-grow-1  justify-content-center">
		<h1 style="text-align: center; margin: 30px;">Atualizar Pedido</h1>
		
		<%
		Pedido pedido = (Pedido) request.getAttribute("pedido");
		    
		if (pedido == null) {
			response.sendRedirect(request.getContextPath() + "/application.do?action=getListOrders");
		} else {
		%>
	        <form class="bg-white p-4 rounded-3 shadow" action="application.do?action=updateOrder" method="post">
	            <div class="mb-3">
	                <label for="name" class="form-label">Nome do Cliente:</label> 
	                <input type="text" class="form-control" id="name" name="name"
	                    placeholder="Digite Nome Completo do Cliente." required="required" value="<%= pedido.getNomeCliente() %>">
	            </div>
	
	            <div class="mb-3">
	                <label for="endereco" class="form-label">Endereço de Entrega:</label> 
	                <input type="text" class="form-control" id="endereco" name="endereco"
	                    placeholder="Digite o Endereço de Entrega do Cliente." required="required" value="<%= pedido.getEndereco() %>">
	            </div>
	
	            <div class="mb-3">
	                <label for="descricao" class="form-label">Descrição:</label> 
	                <input type="text" class="form-control" id="descricao" name="descricao" 
	                    placeholder="Digite a descrição do Produto." required="required" value="<%= pedido.getDescricao() %>">
	            </div>
	
	            <div class="mb-3">
	                <label for="valor" class="form-label">Valor:</label> 
	                <input type="number" class="form-control" id="valor" name="valor"
	                    placeholder="Digite o Valor do Produto." required="required" value="<%= pedido.getValor() %>" step="0.01">
	            </div>
	
	            <input type="hidden" id="id" name="id" value="<%= pedido.getIdPedido() %>">
	
	            <button type="submit" class="btn btn-dark" style="text-align: center;">Salvar Pedido</button>
	        </form>
		<% 
		}
		%>
	</main>

	<jsp:include page="../includes/scripts.html" />
</body>
</html>