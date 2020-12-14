package com.example.lojavirtual.repository;

import com.example.lojavirtual.model.Carrinho;
import com.example.lojavirtual.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

    Carrinho findById(int idCarrinho);

    void create(Carrinho carrinho);

    Carrinho update(Carrinho carrinho);

    void delete(int idCarrinho);

    boolean existsById(String carrinho);

    void delete(Cliente carrinho);

    void delete(String carrinho);
}