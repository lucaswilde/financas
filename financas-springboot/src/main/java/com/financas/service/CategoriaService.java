package com.financas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.model.Categoria;
import com.financas.repository.CategoriaDAO;
import com.financas.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	private Logger logger = LogManager.getLogger(CategoriaDAO.class);
	private CategoriaDAO categoriaDAO = null;//new CategoriaDAO();
    
	
    public Categoria  salvar(Categoria c)
    {
    	//return categoriaDAO.salvar(c);
    	return categoriaRepository.save(c);
    }    

    public void excluir(Long cod)
    {
    	//return categoriaDAO.excluir(cod);
    	categoriaRepository.delete(cod);
	}
    
    public Categoria procurar(Long cod)
    {
    	//return categoriaDAO.procurar(cod);
    	return categoriaRepository.findOne(cod);
	}

	public List<Categoria> listar()
	{
        //return categoriaDAO.listar();
		return (List<Categoria>) categoriaRepository.findAll();
    }
	
	public List<Categoria> pesquisar(String palavra)
	{
        //return categoriaDAO.pesquisar(palavra);
		return (List<Categoria>) categoriaRepository.findByDescricao(palavra);
    }

//	public ArrayList<MediaPorCategoria> gastoMensalPorCategoria(Date dataInicio, Date dataFim, String tipo
//			, ArrayList<Integer> listaCategorias)
//	{
//		ArrayList<MediaPorCategoria> listaRetorno = new ArrayList<MediaPorCategoria>();
//		try
//		{
//			//carrega todos os messes que possuem registros
//			LancamentoDAO lancamentoDao = new LancamentoDAO();
//			ArrayList<MesAno> listaMesAno = lancamentoDao.getMesesAnos(dataInicio, dataFim, tipo, listaCategorias);
//			
//			//busca para cada mes/ano os registros correspondentes
//			for(MesAno data : listaMesAno)
//			{
//				DateTime dtInicio = Datas.createDate(data.getAno(), data.getMes(), 1 , 0, 0, 0);
//				int lastDay = dtInicio.dayOfMonth().getMaximumValue();
//				DateTime dtFim = Datas.createDate(data.getAno(), data.getMes(), lastDay , 23, 59, 59);
//
//				ArrayList<MediaPorCategoria> listaMediaCategoiras = pesquisarMediaPorCategoria(dtInicio.toDate(), dtFim.toDate()
//						, tipo, listaCategorias);
//				
//				//popula a lista de retorno
//				for(MediaPorCategoria media : listaMediaCategoiras)
//				{
//					DateTime dt = Datas.createDate(data.getAno(), data.getMes(), 1, 0, 0, 0);
//					
//					media.setMesAno(data);
//					media.setData(dt.toCalendar(null));
//					listaRetorno.add(media);
//				}
//			}
//		}
//		catch (Exception e) 
//		{
//        	logger.error("", e);
//		}
//		
//		return listaRetorno;
//	}
	
	/**
	 *  Carrega uma lista informando os lancamentos e o valor médio gasto
	 *  
	 * @param dataInicio
	 * @param dataFim
	 * @param tipo
	 * @param listaCategorias
	 * @return
	 */
//	public ArrayList<MediaPorCategoria> pesquisarMediaPorCategoria(Date dataInicio, Date dataFim, String tipo, ArrayList<Integer> listaCategorias)
//	{
//        return categoriaDAO.pesquisarMediaPorCategoria(dataInicio, dataFim, tipo, listaCategorias);
//	}
}
