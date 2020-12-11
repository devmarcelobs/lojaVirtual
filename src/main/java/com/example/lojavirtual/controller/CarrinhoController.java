package com.example.lojavirtual.controller;

import com.example.lojavirtual.model.Carrinho;
import com.example.lojavirtual.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Transactional(readOnly = false)
    public Carrinho createCarrinho(Carrinho carrinho) throws Exception {
        if (existCarrinho(carrinho.getId())) {
            throw new Exception("Este carrinho já existe.");
        } else
            return carrinhoRepository.save(carrinho);
    }

    @Transactional(readOnly = false)
    public Carrinho updateCarrinho(Carrinho carrinho) throws Exception {
        if (existCarrinho(carrinho.getId())) {
            return carrinhoRepository.update(carrinho);
        } else {
            throw new Exception("Este carrinho não existe!");
        }
    }
    @Transactional
    private boolean existCarrinho(int carrinho) {
        return carrinhoRepository.existsById(carrinho);
    }

    public List<Carrinho> retrieveCarrinho() {
        return carrinhoRepository.findAll();
    }

    public void delete(Carrinho carrinho) {
        carrinhoRepository.delete(carrinho);
    }
}

