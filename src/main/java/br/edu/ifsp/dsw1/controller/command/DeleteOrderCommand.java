package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidoDao;
import br.edu.ifsp.dsw1.model.dao.PedidoDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt((request.getParameter("id"))); 
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		dao.delete(id);
		
		return "application.do?action=getListOrders";
	}

}
