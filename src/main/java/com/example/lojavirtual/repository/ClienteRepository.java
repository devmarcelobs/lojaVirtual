package com.example.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojavirtual.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
