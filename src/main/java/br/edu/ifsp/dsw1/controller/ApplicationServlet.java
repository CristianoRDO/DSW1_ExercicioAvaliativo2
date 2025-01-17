package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.FormRegisterUserCommand;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.LoggedCommand;
import br.edu.ifsp.dsw1.controller.command.LogoutCommand;

/*import br.edu.ednilsonrossi.controller.command.ChangeThemeCommand;
import br.edu.ednilsonrossi.controller.command.Command;
import br.edu.ednilsonrossi.controller.command.DeleteContactCommand;
import br.edu.ednilsonrossi.controller.command.DeleteUserCommand;
import br.edu.ednilsonrossi.controller.command.ErrorCommand;
import br.edu.ednilsonrossi.controller.command.FormContactCommand;
import br.edu.ednilsonrossi.controller.command.FormUpdateContactCommand;
import br.edu.ednilsonrossi.controller.command.ListContactsCommand;
import br.edu.ednilsonrossi.controller.command.LoggedCommand;
import br.edu.ednilsonrossi.controller.command.LogoffCommand;
import br.edu.ednilsonrossi.controller.command.SaveContactCommand;
import br.edu.ednilsonrossi.controller.command.SearchContactCommand;
import br.edu.ednilsonrossi.controller.command.UpdateContactCommand;
import br.edu.ednilsonrossi.controller.command.UpdateUserCommand;
import br.edu.ednilsonrossi.controller.command.UserPerfilCommand;*/


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
		}else if("getNewUserForm".equals(action)) {
			command = new FormRegisterUserCommand();
		} else if ("logoff".equals(action)) {
			command = new LogoutCommand();
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
