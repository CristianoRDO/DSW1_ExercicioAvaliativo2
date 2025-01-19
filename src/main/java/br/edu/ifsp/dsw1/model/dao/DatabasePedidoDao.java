package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;
import java.util.List;

import java.util.LinkedList;
import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;

/**
 * Implementação do DAO para a entidade Pedido, responsável por realizar as operações
 * de CRUD (Create, Read, Update e Delete) no banco de dados para a tabela "tb_pedidos".
 * 
 * Esta classe utiliza o UserDao como dependência, pois a entidade Pedido possui um relacionamento
 * com a entidade User, sendo necessário obter informações de um usuário associado a um pedido.
 * 
 * A dependência do UserDao é injetada via construtor para garantir que a lógica de manipulação
 * de usuários associados a pedidos seja gerenciada adequadamente. Isso permite buscar os
 * dados completos do usuário ao recuperar ou manipular pedidos.
 * */

public class DatabasePedidoDao implements PedidoDao{
	
	private static final String INSERT = "INSERT INTO tb_pedidos (name_cliente, endereco, valor, descricao, user) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE tb_pedidos SET name_cliente = ?, endereco = ?, valor = ?, descricao = ? WHERE id_pedido = ?";
	private static final String DELETE = "DELETE FROM tb_pedidos WHERE id_pedido = ?";
	
	private static final String SELECT_BY_NAME = "SELECT * FROM tb_pedidos WHERE name_cliente LIKE ? ORDER BY name_cliente";
	private static final String SELECT_ALL = "SELECT * FROM tb_pedidos ORDER BY id_pedido";
	private static final String SELECT_BY_ID = "SELECT * FROM tb_pedidos WHERE id_pedido = ?";
	
	private UserDao dao;
	
	public DatabasePedidoDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean create(Pedido pedido) {
		int rows = 0;
		
		if (pedido != null) {
			
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(INSERT)) {

				preparedStatement.setString(1, pedido.getNomeCliente());
				preparedStatement.setString(2, pedido.getEndereco());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				preparedStatement.setString(5, pedido.getUser().getEmail());
				rows = preparedStatement.executeUpdate();
				
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
				pedido.setIdPedido(result.getInt("id_pedido"));
				pedido.setNomeCliente(result.getString("name_cliente"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setValor(result.getDouble("valor"));
				
				// Buscar o usuário atrelado aquele pedido e adicioná-lo no objeto.
				var user = dao.findByEmail(result.getString("user"));
				pedido.setUser(user);
				
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
	}

	@Override
	public List<Pedido> retrieveByName(String name) {
		List<Pedido> pedidos = new LinkedList<Pedido>();

		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(SELECT_BY_NAME)){
			
			name = "%" + name + "%";		
			preparedStatement.setString(1, name);
			var result = preparedStatement.executeQuery();

			while (result.next()) {
				
				var pedido = new Pedido();
				pedido.setIdPedido(result.getInt("id_pedido"));
				pedido.setNomeCliente(result.getString("name_cliente"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setValor(result.getDouble("valor"));
				
				// Buscar o usuário atrelado aquele pedido e adicioná-lo no objeto.
				var user = dao.findByEmail(result.getString("user"));
				pedido.setUser(user);
				
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
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
				pedido.setIdPedido(result.getInt("id_pedido"));
				pedido.setNomeCliente(result.getString("name_cliente"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setDescricao(result.getString("descricao"));
				pedido.setValor(result.getDouble("valor"));
				
				// Buscar o usuário atrelado aquele pedido e adicioná-lo no objeto.
				var user = dao.findByEmail(result.getString("user"));
				pedido.setUser(user);
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return pedido;
	}

}
