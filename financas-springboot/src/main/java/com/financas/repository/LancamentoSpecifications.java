package com.financas.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.financas.model.Lancamento;

public class LancamentoSpecifications {
	public static Specification<Lancamento> hasYear(Integer yearParam){
		return new Specification<Lancamento>() {
			@Override
			public Predicate toPredicate(Root<Lancamento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<Integer> year = cb.function("year", Integer.class, root.get(Lancamento.ATTRIBUTE_DATA));
				return cb.equal(year, yearParam);
			}
		};
	}
	
	public static Specification<Lancamento> hasMonth(Integer monthParam){
		return new Specification<Lancamento>() {
			@Override
			public Predicate toPredicate(Root<Lancamento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<Integer> month = cb.function("month", Integer.class, root.get(Lancamento.ATTRIBUTE_DATA));
				return cb.equal(month, monthParam);
			}
		};
	}
	
	public static Specification<Lancamento> hasYearMonth(Integer yearParam, Integer monthParam){
		return new Specification<Lancamento>() {
			@Override
			public Predicate toPredicate(Root<Lancamento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Expression<Integer> month = cb.function("month", Integer.class, root.get(Lancamento.ATTRIBUTE_DATA));
				return cb.equal(month, monthParam);
			}
		};
	}
}
