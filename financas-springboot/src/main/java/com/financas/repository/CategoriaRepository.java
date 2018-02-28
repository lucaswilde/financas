package com.financas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.financas.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	// exemplos
	// http://blog.algaworks.com/spring-data-jpa/
	
	List<Categoria> findByDescricao(String descricao);
}
