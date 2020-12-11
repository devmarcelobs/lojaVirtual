package com.example.lojavirtual.controller;

import com.example.lojavirtual.model.Cliente;
import com.example.lojavirtual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente createCarrinho(Cliente novoCliente) throws Exception {
        if (exist(novoCliente.getCpf())) {
            throw new Exception("Já existe!");
        } else {
            return clienteRepository.save(novoCliente);
        }
    }

    @Transactional
    public Cliente updateCarrrinho(Cliente novoCliente) throws Exception {
        if (exist(novoCliente.getCpf())) {
            return clienteRepository.save(novoCliente);
        } else {
            throw new Exception("Não existe!");
        }
    }

    @Transactional
    public List<Cliente> retrieveCarrinho() {
        return clienteRepository.findAll();
    }

    @Transactional
    public void delete(Cliente novoCliente) {
        clienteRepository.delete(novoCliente);
    }

    @Transactional
    private boolean exist(String novoCliente) {
        return clienteRepository.existsById(novoCliente);
    }
}
