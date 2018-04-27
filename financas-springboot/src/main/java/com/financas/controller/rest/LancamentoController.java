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

import com.financas.model.Lancamento;
import com.financas.service.LancamentoService;

@RestController
@RequestMapping("/v1/lancamentos")
@CrossOrigin(origins="*")// ou poderia ser (angular ui) http://localhost:4200, CrossOrigin = 'Access-Control-Allow-Origin'
public class LancamentoController {

	// boas praticas
	// https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/

	@Autowired
	private LancamentoService lancamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lancamento>> findAll() {
		System.out.println("LancamentoController.findAll()");
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.listar());
	}

	@GetMapping(path = "/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lancamento> findOne(@PathVariable(value = "cod") Long cod) {
		System.out.println("LancamentoController.findOne()");
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.procurar(cod));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lancamento> save(@RequestBody Lancamento lancamento) {

		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.salvar(lancamento));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{codLancamento}")
	public ResponseEntity<Void> delete(@PathVariable(value = "codLancamento") Long codLancamento) {
		System.out.println("LancamentoController.delete codLancamento: " + codLancamento);
		lancamentoService.excluir(codLancamento);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
