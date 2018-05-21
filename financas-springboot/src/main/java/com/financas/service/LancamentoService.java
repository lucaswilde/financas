package com.financas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.model.Lancamento;
import com.financas.model.LancamentoQueryRequest;
import com.financas.repository.LancamentoRepository;
import com.financas.repository.LancamentoSpecifications;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	@Autowired
	private LancamentoSpecifications lancamentoSpecifications;

    public Lancamento  salvar(Lancamento c)
    {
    	return lancamentoRepository.save(c);
    }    

    public void excluir(Long cod)
    {
    	lancamentoRepository.delete(cod);
	}
    
    public Lancamento procurar(Long cod)
    {
    	return lancamentoRepository.findOne(cod);
	}

	public List<Lancamento> listar()
	{
		return (List<Lancamento>) lancamentoRepository.findAllByOrderByDataDesc();
    }
	
	public List<Lancamento> listar(LancamentoQueryRequest request)
	{
		return (List<Lancamento>) lancamentoRepository.findAll(lancamentoSpecifications.getFilter(request));
		
//		return (List<Lancamento>) lancamentoRepository.findAll(Specifications.where(LancamentoSpecifications.hasYear(year)).where(LancamentoSpecifications.hasMonth(month)));
		
//		return (List<Lancamento>) lancamentoRepository.findAll(LancamentoSpecifications.hasYear(year));
    }
	
}
