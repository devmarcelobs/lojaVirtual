package com.example.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojavirtual.model.Carrinho;

 Alineb-v
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

    void save();

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{
	List<Carrinho> findById(int id);
 main
}