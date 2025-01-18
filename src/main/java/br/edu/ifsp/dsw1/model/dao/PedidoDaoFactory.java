package br.edu.ifsp.dsw1.model.dao;

import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;

public class PedidoDaoFactory {

	public PedidoDao factory() {
		return new DatabasePedidoDao(new UserDaoFactory().factory());
	}
}
