package com.financas.controller.rest;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financas.model.Lancamento;
import com.financas.model.LancamentoQueryRequest;
import com.financas.service.LancamentoService;

@RestController
@RequestMapping("/v1/lancamentos")
@CrossOrigin(origins = "*") // ou poderia ser (angular ui) http://localhost:4200, CrossOrigin='Access-Control-Allow-Origin'
public class LancamentoController {

	// boas praticas
	// https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/
	
	// conversao de data e json em bean para metodo get
	// https://lankydanblog.com/2017/03/11/passing-data-transfer-objects-with-get-in-spring-boot/

	@Autowired
	private LancamentoService lancamentoService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lancamento>> findAll() {
		System.out.println("LancamentoController.findAll()");
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.listar());
	}

	@GetMapping(path = "/findAllBy", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Lancamento>> findAll(@RequestParam String lancamentoRequest) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("LancamentoController.findAllBy()");
		LancamentoQueryRequest lancamentoQueryRequest = new ObjectMapper().readValue(lancamentoRequest, LancamentoQueryRequest.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.listar(lancamentoQueryRequest));
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
