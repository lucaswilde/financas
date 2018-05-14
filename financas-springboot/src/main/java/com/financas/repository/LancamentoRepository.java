package com.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.financas.model.Lancamento;

public interface LancamentoRepository extends CrudRepository<Lancamento, Long>, JpaSpecificationExecutor<Lancamento> {

	// exemplos
	// http://blog.algaworks.com/spring-data-jpa/
	// https://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/
	// http://leaks.wanari.com/2018/01/23/awesome-spring-specification/
	// http://www.baeldung.com/rest-api-search-language-spring-data-specifications
	
	//List<Categoria> findByDescricao(String descricao);
	
	List<Lancamento> findAllByOrderByDataDesc();
	
}
