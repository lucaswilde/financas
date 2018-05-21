package com.financas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financas.model.Lancamento;
import com.financas.model.LancamentoQueryRequest;
import com.financas.model.LancamentoQueryRequest.LancamentoQueryRequestBuilder;
import com.financas.service.CategoriaService;
import com.financas.service.LancamentoService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Autowired
//	private CategoriaService categoriaService;
	
	@Autowired
	private LancamentoService lancamentoService;
	@Override
	public void run(String... arg0) throws Exception {
		/*
//		System.out.println("Testando acesso ao banco com metodo main:");
//		System.out.println("--------> Todas as categorias: " + categoriaService.listar().size());
		
		// LancamentoRequest lancamentoRequest = new LancamentoRequest.LancamentoRequestBuilder().setMonth(1).setYear(2018).build();
		LancamentoRequest lancamentoRequest = new LancamentoRequest.LancamentoRequestBuilder().setMonth(1).build();
		
		List<Lancamento> list = lancamentoService.listar(lancamentoRequest);
		System.out.println("--------> Lancamentos por mes: " + list.size());
		for(Lancamento lancamento : list) {
			System.out.println(lancamento.getData());
		}
		
		System.out.println();
		lancamentoRequest = new LancamentoRequest.LancamentoRequestBuilder().setMonth(1).setYear(2018).build();
		
		list = lancamentoService.listar(lancamentoRequest);
		System.out.println("--------> Lancamentos por Ano: " + list.size());
		for(Lancamento lancamento : list) {
			System.out.println(lancamento.getData());
		}
 */
	}
}