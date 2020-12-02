package com.example.lojavirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="produto", nullable=false)
	private Produto produto;
	
	@Column(name="quantidade", nullable=false)
	private int quantidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidaded() {
		return quantidade;
	}

	public void setQuantidaded(int quantidade) {
		this.quantidade = quantidade;
	}
}
