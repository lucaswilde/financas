package com.financas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.financas.model.Categoria;
import com.financas.model.Lancamento;

public interface LancamentoRepository extends CrudRepository<Lancamento, Long> {

	// exemplos
	// http://blog.algaworks.com/spring-data-jpa/
	
	//List<Categoria> findByDescricao(String descricao);
	
	List<Lancamento> findAllByOrderByDataDesc();
	
}
