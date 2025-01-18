package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ListOrdersCommand;
import br.edu.ifsp.dsw1.controller.command.DeleteOrderCommand;
import br.edu.ifsp.dsw1.controller.command.UpdateOrderCommand;
import br.edu.ifsp.dsw1.controller.command.UpdateOrderFormCommand;
import br.edu.ifsp.dsw1.controller.command.RegisterOrderCommand;
import br.edu.ifsp.dsw1.controller.command.RegisterOrderFormCommand;
import br.edu.ifsp.dsw1.controller.command.RegisterUserCommand;
import br.edu.ifsp.dsw1.controller.command.RegisterUserFormCommand;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.LoggedCommand;
import br.edu.ifsp.dsw1.controller.command.LogoutCommand;


@WebServlet("/application.do")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Command command;
		
		if ("logged".equals(action) ) {
			command = new LoggedCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		} else if("getRegisterUserForm".equals(action)) {
			command = new RegisterUserFormCommand();
		} else if("getRegisterOrderForm".equals(action)) {
			command = new RegisterOrderFormCommand();
		} else if ("getUpdateOrderForm".equals(action)) {
			command = new UpdateOrderFormCommand();
		} else if("getListOrders".equals(action)) {
			command = new ListOrdersCommand();
		} else if("registerUser".equals(action)) {
			command = new RegisterUserCommand();
		} else if("registerOrder".equals(action)) {
			command = new RegisterOrderCommand();
		} else if ("deleteOrder".equals(action)) {
			command = new DeleteOrderCommand();
		} else if ("updateOrder".equals(action)) {
			command = new UpdateOrderCommand();
		} else{
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
