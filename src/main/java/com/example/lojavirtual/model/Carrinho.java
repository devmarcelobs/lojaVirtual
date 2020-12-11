package com.example.lojavirtual.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

//como fazer o uso de um objeto na coluna do JPA
@Entity
public class Carrinho {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	//existe alguma coutra tag q da para usar?
	@Type(type = "serializable")
	@Column(name="produto", nullable=false)
	//@Transient
	//@Embedded
	private Produto produtos;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "cpf")
	private Cliente cliente;


	@Column(name="quantidade", nullable=false)
	private int quantidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void add(Carrinho carrinho) {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
