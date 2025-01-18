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
		} else if("getRegisterUserForm".equals(action)) {
			command = new RegisterUserFormCommand();
		} else if("getRegisterOrderForm".equals(action)) {
			command = new RegisterOrderFormCommand();
		} else if("getListOrders".equals(action)) {
			command = new ListOrdersCommand();
		} else if("registerUser".equals(action)) {
			command = new RegisterUserCommand();
		} else if("registerOrder".equals(action)) {
			command = new RegisterOrderCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		}else if ("deleteOrder".equals(action)) {
			command = new DeleteOrderCommand();
		}/* else if ("newContact".equals(action)) {
			command = new SaveContactCommand();
		} else if ("getForm".equals(action)) {
			command = new FormContactCommand();
		}else if ("getFormUpdateContact".equals(action)) {
				command = new FormUpdateContactCommand();
		}else if ("delete".equals(action)) {
			command = new DeleteContactCommand();
		}else if ("update".equals(action)) {
			command = new UpdateContactCommand();
		}else if("searchContact".equals(action)) {
			command = new SearchContactCommand();
		} else if ("changeTheme".equals(action)) { 
			command = new ChangeThemeCommand();
		} else if("userPerfil".equals(action)) {
			command = new UserPerfilCommand();
		} else if("deleteUser".equals(action)) {
			command = new DeleteUserCommand();
		} else if("updateUser".equals(action)) {
			command = new UpdateUserCommand();
		} */else{
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
