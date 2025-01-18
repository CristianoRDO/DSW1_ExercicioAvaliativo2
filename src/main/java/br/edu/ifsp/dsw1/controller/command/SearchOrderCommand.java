package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var name = request.getParameter("name");
		var dao = new PedidoDaoFactory().factory();
			
		List<Pedido> pedidos = dao.retrieveByName(name);
			
		if (pedidos.isEmpty()) {
			pedidos = dao.retrieveAll();
			request.setAttribute("mensagem", "Nenhum Pedido Registrado Para " + name);
		}
			
		request.setAttribute("pedidos", pedidos);
			
		return "/logado/pedidos.jsp";
	}
}

