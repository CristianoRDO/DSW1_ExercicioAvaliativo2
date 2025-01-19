package br.edu.ifsp.dsw1.model.entity;

/**
 * Classe que representa a entidade Pedido, modelando os dados e comportamentos
 * relacionados a um pedido no sistema.
 * 
 * A entidade Pedido possui um relacionamento com a entidade User, que representa
 * o usuário associado ao pedido. Esse relacionamento é modelado por meio do atributo
 * "user", permitindo associar cada pedido a um usuário específico.
 * 
 * Construtores:
 * - Construtor vazio: utilizado para criar objetos de Pedido que serão usados em operações
 *   de atualização (update), onde não é necessário alterar atributos como `idPedido` ou `user`.
 * 
 * - Construtor sem ID: usado para criar instâncias de Pedido antes de cadastrá-las no banco de dados,
 *   pois o ID do pedido é gerado automaticamente pelo banco.
 * 
 * - Construtor completo: utilizado para criar objetos de Pedido com todos os atributos preenchidos,
 *   incluindo o ID. É utilizado para construir objetos retornados em consultas SQL.
 */

public class Pedido {
	
	private int idPedido;
	private String nomeCliente;
	private String endereco;
	private String descricao;
	private double valor;
	private User user;
	
	public Pedido(){}
	
	public Pedido(String nomeCliente, String endereco, String descricao, double valor, User user) {
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.descricao = descricao;
		this.valor = valor;
		this.user = user;
	}
	
	public Pedido(int idPedido, String nomeCliente, String endereco, String descricao, double valor, User user) {
		this(nomeCliente, endereco, descricao, valor, user);
		this.idPedido = idPedido;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
