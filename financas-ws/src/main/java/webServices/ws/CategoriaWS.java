package webServices.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import classes.Categoria;
import servico.CategoriaService;

@WebService
public class CategoriaWS {

	@WebMethod(operationName = "listarCategorias")
	public ArrayList<Categoria> listar() {
		return new CategoriaService().listar();
	}
	
	@WebMethod(operationName = "pesquisarCategorias")
	public ArrayList<Categoria> pesquisar(@WebParam String palavra) {
		return new CategoriaService().pesquisar(palavra);
	}
}
