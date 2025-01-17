package br.edu.ifsp.dsw1.model.dao;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;

public class DatabasePedidoDao implements PedidoDao{

	@Override
	public boolean create(User user, Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Pedido updatedPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pedido> retrieve(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> retrieveFindByName(User user, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
