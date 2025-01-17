package br.edu.ifsp.dsw1.model.entity;

public class Pedido {
	
	private int idPedido;
	private String nomeCliente;
	private String endereco;
	private String descricao;
	private double valor;
	
	public Pedido(){}
	
	public Pedido(String nomeCliente, String endereco, String descricao, double valor) {
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	// Permitir a criação de Objetos do Tipo pedido antes de armazenalos no banco (id gerado automaticamente durante a inserção).
	public Pedido(int idPedido, String nomeCliente, String endereco, String descricao, double valor) {
		this(nomeCliente, endereco, descricao, valor);
		this.idPedido = idPedido;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdProduto(int idPedido) {
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
	
	
	
	
	
	
}
