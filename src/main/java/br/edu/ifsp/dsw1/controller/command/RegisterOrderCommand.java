package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var name = request.getParameter("name");
		var endereco = request.getParameter("endereco");
		var descricao = request.getParameter("descricao");
		var valor = request.getParameter("valor");
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		Pedido pedido = new Pedido(name, fone, email);
		boolean saved = dao.create(user, pedido);
		
		String mensagem;
		if (saved) {
			mensagem = "Pedido Registrado com Sucesso!";
		} else {
			mensagem = "Erro ao Registrar Pedido. Verifique as Informações";
		}
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("saved", saved);
		
		return "/loggedin/contact_form.jsp";
	}

}
