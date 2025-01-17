package br.edu.ifsp.dsw1.model.entity;

public class Pedido {
	
	private int idProduto;
	private String nomeCliente;
	private String endereco;
	private String descricao;
	private double valor;
	
	public Pedido(){}
	
	public Pedido(int idProduto, String nomeCliente, String endereco, String descricao, double valor) {
		this.idProduto = idProduto;
		this.nomeCliente = nomeCliente;
		this.endereco = endereco;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
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
