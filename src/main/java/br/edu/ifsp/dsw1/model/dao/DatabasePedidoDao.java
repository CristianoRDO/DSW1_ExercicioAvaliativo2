package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;
import java.util.List;

import java.util.LinkedList;
import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;

public class DatabasePedidoDao implements PedidoDao{
	
	private static final String INSERT = "INSERT INTO tb_pedidos (name_cliente, endereco, valor, descricao, user) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE tb_pedidos SET name_cliente = ?, endereco = ?, valor = ?, descricao = ? WHERE id_pedido = ?";
	private static final String DELETE = "DELETE FROM tb_pedidos WHERE id_pedido = ?";
	
	private static final String SELECT_BY_NAME = "SELECT * FROM tb_pedidos WHERE name_cliente LIKE ? AND user = ? ORDER BY name_cliente";
	private static final String SELECT_ALL = "SELECT * FROM tb_pedidos ORDER BY id_pedido";
	private static final String SELECT_BY_ID = "SELECT * FROM tb_pedidos WHERE id_pedido = ?";
	

	@Override
	public boolean create(User user, Pedido pedido) {
		int rows = 0;
		
		if (pedido != null) {
			
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(INSERT)) {

				preparedStatement.setString(1, pedido.getNomeCliente());
				preparedStatement.setString(2, pedido.getEndereco());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				preparedStatement.setString(5, user.getEmail());
				rows = preparedStatement.executeUpdate();

				//if (rows > 0) user.addPedido(pedido);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows > 0;
	}

	@Override
	public boolean update(int id, Pedido updatedPedido) {
		int rows = 0;
		
		if (updatedPedido != null) {
			
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(UPDATE)){
				
				preparedStatement.setString(1, updatedPedido.getNomeCliente());
				preparedStatement.setString(2, updatedPedido.getEndereco());
				preparedStatement.setDouble(3, updatedPedido.getValor());
				preparedStatement.setString(4, updatedPedido.getDescricao());
				preparedStatement.setInt(5, id);

				rows = preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows > 0;
	}

	@Override
	public boolean delete(int id) {
		int rows = 0;
		
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(DELETE)) {
			
				preparedStatement.setInt(1, id);

				rows = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return rows > 0;
	}

	@Override
	public List<Pedido> retrieveAll() {
		List<Pedido> pedidos = new LinkedList<Pedido>();

		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(SELECT_ALL)){
					
			var result = preparedStatement.executeQuery();

			while (result.next()) {
				
				var pedido = new Pedido();
				pedido.setIdProduto(result.getInt("id_pedido"));
				pedido.setNomeCliente(result.getString("name_cliente"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setValor(result.getDouble("valor"));
				pedidos.add(pedido);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
	}

	@Override
	public List<Pedido> retrieveByName(User user, String name) {
		return null;
	}

	@Override
	public Pedido retrieveById(int id) {
		Pedido pedido = null;
		
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
						
			preparedStatement.setInt(1, id);
			var result = preparedStatement.executeQuery();

			if (result.next()) {
				pedido = new Pedido();
				pedido.setIdProduto(result.getInt("id_pedido"));
				pedido.setNomeCliente(result.getString("name_cliente"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setValor(result.getDouble("valor"));
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return pedido;
	}

}
