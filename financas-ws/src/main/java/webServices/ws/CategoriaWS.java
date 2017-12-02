package webServices.ws;

import java.util.ArrayList;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import classes.Categoria;
import servico.CategoriaService;

@WebService
public class CategoriaWS {

	@WebMethod(operationName = "listarCategorias")
	@WebResult(name="categoria")
	public ArrayList<Categoria> listar() throws ServiceExceptionSOAP{
		return new CategoriaService().listar();
	}
	
	@WebMethod(operationName = "pesquisarCategorias")
	@WebResult(name="categoria")
	public ArrayList<Categoria> pesquisar(@WebParam(name = "descricao") String descricao) throws ServiceExceptionSOAP{
		return new CategoriaService().pesquisar(descricao);
	}
	
	@WebMethod(operationName="salvarCategoria")
	@WebResult(name="categoria")
	public Categoria salvar(@WebParam(name="categoria") Categoria categoria) 
			throws ServiceExceptionSOAP{
		
		if(categoria.getDescricao() == null || "".equals(categoria.getDescricao())) {
			throw new ServiceExceptionSOAP("Missing Data", "Campo descricao deve ser informado.");
		}
		new CategoriaService().salvar(categoria);
		return categoria;
	}
}
