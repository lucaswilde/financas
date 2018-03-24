package com.financas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financas.service.CategoriaService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void run(String... arg0) throws Exception {
//		System.out.println("Testando acesso ao banco com metodo main:");
//		System.out.println("--------> Todas as categorias: " + categoriaService.listar().size());
		
	}
}