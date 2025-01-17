package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUserCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var passwd = request.getParameter("password");
		
		var dao = new UserDaoFactory().factory();
		var user = new User(name, email, passwd);
		var saved = dao.insert(user);
		
		String mensagem;
		
		if (saved) {
			mensagem = "Novo Usuário Cadastrado com Sucesso.";
		}else
		{
			mensagem = "Erro ao Cadastrar o Usuário.";
		}
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("saved", saved);
		
		return "/logado/new_user_form.jsp";
	}

}
