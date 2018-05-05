package com.financas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financas.model.Lancamento;
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
//		System.out.println("Testando acesso ao banco com metodo main:");
//		System.out.println("--------> Todas as categorias: " + categoriaService.listar().size());
		
		List<Lancamento> list = lancamentoService.listar(2017, 2);
		System.out.println("--------> Lancamentos por ano: " + list.size());
		for(Lancamento lancamento : list) {
			System.out.println(lancamento.getData());
		}
		
	}
}