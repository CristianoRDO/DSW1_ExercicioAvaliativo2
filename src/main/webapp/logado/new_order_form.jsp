<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html" />
<body>
	<jsp:include page="./includes/navBarLogado.jsp" />

	<main class="container-sm flex-grow-1  justify-content-center">
		<h1 style="text-align: center; margin: 30px;">Cadastrar Pedido</h1>
		
		<%
			String msg = (String) request.getAttribute("mensagem");
		
			if (msg != null ) {
				boolean success = (Boolean) request.getAttribute("saved");
				
				if (success) {
					out.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">");
				} else {
					out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">");
				}
				out.println(msg);
				out.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button></div>");
			}
		%>
		
		<form class="bg-white p-4 rounded-3 shadow" action="application.do?action=registerOrder" method="post">
			<div class="mb-3">
				<label for="name" class="form-label">Nome do Cliente:</label> 
				<input type="text"
					class="form-control" id="name" name="name"
					placeholder="Digite Nome Completo do Cliente." required="required">
			</div>
			
			<div class="mb-3">
				<label for="email" class="form-label">Endereço de Entrega:</label> 
				<input type="text" class="form-control" id="endereco" name="endereco"
					placeholder="Digite o Endereço de Entrega do Cliente." required="required">
			</div>
			
			<div class="mb-3">
				<label for="email" class="form-label">Descrição:</label> 
				<input type="text" class="form-control" id="descricao" name="descricao" 
					placeholder="Digite a descrição do Produto." required="required">
			</div>
			
			<div class="mb-3">
				<label for="password" class="form-label">Valor:</label> 
				<input
					type="number" class="form-control" id="valor" name="valor"
					placeholder="Digite o Valor do Produto." required="required" step = "0.01">
			</div>

			<button type="submit" class="btn btn-dark"
				style="text-align: center;">Salvar Pedido</button>
		</form>
	</main>

	<jsp:include page="../includes/scripts.html" />
</body>
</html>