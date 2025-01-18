package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.model.dao.PedidoDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListOrdersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//var user = (User) request.getSession(false).getAttribute("user");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		List<Pedido> pedidos = dao.retrieveAll();
		request.setAttribute("pedidos", pedidos);
		
		return "/logado/pedidos.jsp";
	}

}
