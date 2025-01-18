package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.dao.PedidoDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var id = Integer.parseInt(request.getParameter("id"));
		var name = request.getParameter("name");
		var endereco = request.getParameter("endereco");
		var descricao = request.getParameter("descricao");
		var valor = Double.parseDouble(request.getParameter("valor"));
		
		var dao = new PedidoDaoFactory().factory();
		Pedido newPedido = new Pedido(name, endereco, descricao, valor);
		
		dao.update(id, newPedido);

		return "application.do?action=getListOrders";
	}

}
