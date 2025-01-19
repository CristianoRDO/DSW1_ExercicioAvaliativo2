package br.edu.ifsp.dsw1.model.dao;

/**
 * Classe de fábrica responsável por criar instâncias de PedidoDao.
 * 
 * A implementação de PedidoDao requer um UserDao, pois a entidade Pedido agora 
 * possui uma relação direta com a entidade User. Essa dependência permite que 
 * o PedidoDao manipule objetos User associados a pedidos.
 * 
 * Para simplificar a inicialização do PedidoDao e evitar a necessidade de configurar 
 * manualmente o UserDao em outros lugares, a instância de UserDao é criada e injetada 
 * diretamente dentro deste factory, garantindo que o UserDao esteja sempre disponível quando um PedidoDao for criado.
 */

public class PedidoDaoFactory {

	public PedidoDao factory() {
		return new DatabasePedidoDao(new UserDaoFactory().factory());
	}
}
