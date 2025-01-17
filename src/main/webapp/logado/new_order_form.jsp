<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../includes/head.html" />
<body>
	<jsp:include page="./includes/navBarLogado.jsp" />

	<main class="container-sm flex-grow-1  justify-content-center">
		<h1 style="text-align: center; margin: 30px;">Cadastrar Pedido</h1>
		

		<form class="bg-white p-4 rounded-3 shadow" action="front.do?action=newUser" method="post">
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
					placeholder="Digite a senha segura." required="required">
			</div>

			<button type="submit" class="btn btn-warning"
				style="text-align: center;">Salvar Pedido</button>
		</form>
	</main>

	<jsp:include page="../includes/scripts.html" />
</body>
</html>