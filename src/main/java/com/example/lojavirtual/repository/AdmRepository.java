package com.example.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojavirtual.model.Adm;

public interface AdmRepository  extends JpaRepository<Adm, Integer>{
	List<Adm> findByLogin(String login);
	
	List<Adm> findBySenha(String senha);
	
	List<Adm> findById(int id);
}
