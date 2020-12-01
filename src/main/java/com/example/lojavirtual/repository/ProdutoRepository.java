package com.example.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojavirtual.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
