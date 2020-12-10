package com.example.lojavirtual.controller;

import com.example.lojavirtual.model.Cliente;
import com.example.lojavirtual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private boolean exist(String novoCliente) {
        return clienteRepository.existsById(novoCliente);
    }

    public Cliente save(Cliente novoCliente) throws Exception {
        if (exist(novoCliente.getCpf())) {
            throw new Exception("Já existe!");
        } else {
            return clienteRepository.save(novoCliente);
        }
    }

    public Cliente edit(Cliente novoCliente) throws Exception {
        if (exist(novoCliente.getCpf())) {
            return clienteRepository.save(novoCliente);
        } else {
            throw new Exception("Não existe!");
        }
    }

    public List<Cliente> ler() {
        return clienteRepository.findAll();
    }

    public void delete(Cliente novoCliente) {
        clienteRepository.delete(novoCliente);
    }

}
