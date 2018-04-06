package com.financas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.financas.model.Categoria;
import java.lang.String;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	// exemplos
	// http://blog.algaworks.com/spring-data-jpa/
	
	//List<Categoria> findByDescricao(String descricao);
	
	List<Categoria> findByDescricaoLikeOrderByDescricaoAsc(String descricao);
	
	List<Categoria> findAllByOrderByDescricaoAsc();
	
}
