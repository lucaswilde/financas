package com.financas.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import com.financas.model.Lancamento;
import com.financas.model.LancamentoRequest;

@Component
public class LancamentoSpecifications extends BaseSpecification<Lancamento, LancamentoRequest>{
	public static Specification<Lancamento> hasYear(Integer yearParam){
		return new Specification<Lancamento>() {
			@Override
			public Predicate toPredicate(Root<Lancamento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(yearParam == null) {
					return null;
				}else {
					Expression<Integer> year = cb.function("year", Integer.class, root.get(Lancamento.ATTRIBUTE_DATA));
					return cb.equal(year, yearParam);
				}
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
	
	/*
	@Override
	public Specification<Lancamento> getFilter(LancamentoRequest request) {
		return (root, query, cb)->{
			return Specifications.where(hasMonth(request.getMonth()))
					.and(hasYear(request.getYear()))
					.toPredicate(root, query, cb);
		};
	}
	*/
	
	public Specification<Lancamento> getFilter(LancamentoRequest request) {
		return (root, query, cb)->{
			Specification<Lancamento> specification = null;
			
			if(request.getYear() != null) {
				specification = Specifications.where(hasYear(request.getYear()));
			}
			
			if(request.getMonth() != null) {
				if(specification == null) {
					specification = Specifications.where(hasMonth(request.getMonth()));
				}else {
					specification = Specifications.where(specification).and(hasMonth(request.getMonth()));
				}
			}
			
			return specification.toPredicate(root, query, cb);
		};
	}
	
}
