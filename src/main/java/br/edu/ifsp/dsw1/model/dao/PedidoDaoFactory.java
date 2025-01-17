package br.edu.ifsp.dsw1.model.dao;

public class PedidoDaoFactory {

	public PedidoDao factory() {
		return new DatabasePedidoDao();
	}
}
