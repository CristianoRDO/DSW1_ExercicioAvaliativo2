package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import br.edu.ifsp.dsw1.model.entity.User;

class DatabaseUserDao implements UserDao {
	
	private static final String INSERT = "INSERT INTO tb_user (name, email, password) VALUES (?, ?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM tb_user WHERE email = ?";

	@Override
	public boolean insert(User user) {
		int rows = 0;
		if (user != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, user.getName());
				statement.setString(2, user.getEmail());
				statement.setString(3, user.getPassword());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
		try ( var connection = DatabaseConnection.getConnection();
			  var statement = connection.prepareStatement(SELECT_BY_EMAIL);
			  var pedidoStatement = connection.prepareStatement("SELECT * FROM tb_pedidos WHERE user = ?")) {
			
			statement.setString(1, email);
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
				
				pedidoStatement.setString(1, email);
	            var pedidoResultSet = pedidoStatement.executeQuery();

	            while (pedidoResultSet.next()) {
	                Pedido pedido = new Pedido(
	                		pedidoResultSet.getInt("id_pedido"),
	                		pedidoResultSet.getString("nome_cliente"),
	                		pedidoResultSet.getString("endereco"),
	                		pedidoResultSet.getString("descricao"),
	                		pedidoResultSet.getDouble("valor")
	                );
	                
	                user.getPedidos().add(pedido);
	            }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} 
		
		return user;
	}

}
