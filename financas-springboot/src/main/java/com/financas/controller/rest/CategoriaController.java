package com.financas.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financas.model.Categoria;
import com.financas.service.CategoriaService;

@RestController
@RequestMapping("/v1/categorias")
@CrossOrigin(origins="*")// ou poderia ser (angular ui) http://localhost:4200, CrossOrigin = 'Access-Control-Allow-Origin'
public class CategoriaController {

	// boas praticas
	// https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> findAll() {
		System.out.println("CategoriaController.findAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listar());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/findByDescricao/{descricao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> findByDescricao(@PathVariable(value = "descricao") String descricao) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.pesquisar(descricao));
	}

	@GetMapping(path = "/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> findOne(@PathVariable(value = "cod") Long cod) {
		System.out.println("CategoriaController.findOne()");
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.procurar(cod));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.salvar(categoria));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{codCategoria}")
	public ResponseEntity<Void> delete(@PathVariable(value = "codCategoria") Long codCategoria) {
		System.out.println("CategoriaController.delete codCategoria: " + codCategoria);
		categoriaService.excluir(codCategoria);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
