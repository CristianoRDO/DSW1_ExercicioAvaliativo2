package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;

public class DatabasePedidoDao implements PedidoDao{
	
	private static final String INSERT = "INSERT INTO tb_pedidos (name_cliente, endereco, valor, descricao, user) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE tb_pedidos SET name_cliente = ?, endereco = ?, valor = ?, descricao = ? WHERE id_pedido = ?";
	private static final String DELETE = "DELETE FROM tb_pedidos WHERE id_pedido = ?";
	
	private static final String SELECT_BY_NAME = "SELECT * FROM tb_pedidos WHERE name_cliente LIKE ? AND user = ? ORDER BY name_cliente";
	private static final String SELECT_ALL = "SELECT * FROM tb_pedidos WHERE user = ? ORDER BY name_cliente";
	

	@Override
	public boolean create(User user, Pedido pedido) {
		if (pedido != null) {
			int rows = -1;
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(INSERT)) {

				preparedStatement.setString(1, pedido.getNomeCliente());
				preparedStatement.setString(2, pedido.getEndereco());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				preparedStatement.setString(5, user.getEmail());
				rows = preparedStatement.executeUpdate();

				if (rows > 0) {
					user.addPedido(pedido);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return rows > 0;
		}
		return false;
	}

	@Override
	public boolean update(int id, Pedido updatedPedido) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public List<Pedido> retrieve(User user) {
		return null;
	}

	@Override
	public List<Pedido> retrieveFindByName(User user, String name) {
		return null;
	}

	@Override
	public Pedido findById(int id) {
		return null;
	}

}
