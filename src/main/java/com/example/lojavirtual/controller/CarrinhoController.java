package com.example.lojavirtual.controller;

import com.example.lojavirtual.model.Carrinho;
import com.example.lojavirtual.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Transactional(readOnly = false)
    public Carrinho save(Carrinho novoCarrinho) throws Exception {
        carrinhoRepository.save(novoCarrinho);
        if (existe(novoCarrinho.getId())) {
            throw new Exception("Já existe!");
        } else {
            return carrinhoRepository.save(novoCarrinho);
        }
    }

    private boolean existe(Integer id) {
        return carrinhoRepository.existsById(id);
    }
    @Transactional (readOnly = false)
    public Carrinho edit(Carrinho novoCarrinho) throws Exception {
        if (existe(novoCarrinho.getId())) {
            return carrinhoRepository.save(novoCarrinho);
        } else {
            throw new Exception("Não existe!");
        }
    }
    @Transactional (readOnly = true)
    public List<Carrinho> ler() {
        return carrinhoRepository.findAll();
    }
    @Transactional (readOnly = false)
    public void delete(Carrinho novoCarrinho) {
        carrinhoRepository.delete(novoCarrinho);
    }
}









