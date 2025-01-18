package br.edu.ifsp.dsw1.controller.command;

import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	
		var email = request.getParameter("textEmail");
		var passwd = request.getParameter("textPassword");
		
		var dao = new UserDaoFactory().factory();
		var user = dao.findByEmail(email);
		
		var autorized = User.autenticate(user, email, passwd);
		
		String view;
		
		if (autorized) {
			var session = request.getSession(true);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(24 * 60 * 60);
			view = "application.do?action=logged";
		} else {
			request.setAttribute("mensagem", "Usuário ou Senha inválido.");
			view = "front.do?action=error";
		}
		
		return view;
	}
}
