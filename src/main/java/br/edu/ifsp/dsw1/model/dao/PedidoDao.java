package br.edu.ifsp.dsw1.model.dao;

import java.util.List;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;

public interface PedidoDao {
	
	boolean create(User user, Pedido pedido);
	boolean update(int id, Pedido updatedPedido);
	boolean delete(int id);
	
	List<Pedido> retrieve(User user);
	List<Pedido> retrieveFindByName(User user, String name);
	Pedido findById(int id);
}
