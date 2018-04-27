package com.financas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.model.Lancamento;
import com.financas.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

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
	
}
