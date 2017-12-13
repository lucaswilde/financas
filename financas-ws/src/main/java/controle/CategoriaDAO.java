/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.joda.time.DateTime;

import classes.Categoria;
import classesRelatorios.MediaPorCategoria;
import uteis.Utilidades;

public class CategoriaDAO 
{
	private Logger logger = LogManager.getLogger(CategoriaDAO.class);
	
    GenericDao<Categoria> dao = new GenericDao<Categoria>(Categoria.class);
    String hql = "";
    
    public Categoria salvar(Categoria c) throws PersistenceException
    {
    	if(c.getCodCategoria() == 0)
    	{ 
        	c.setCodCategoria(null);
        	return dao.inserir(c);
    	}
    	else
    	{
    		return dao.atualizar(c);
    	}
    }    

    public boolean excluir(int cod)
    {
		return dao.excluir(dao.getObjeto(cod));
	}
    
    public Categoria procurar(int cod)
    {
		return dao.getObjeto(cod);
	}

	public ArrayList<Categoria> listar()
	{
        ArrayList<Categoria> lista = new ArrayList<Categoria>();
        try
        {
        	hql = "from Categoria order by descricao";
        	lista = (ArrayList<Categoria>) dao.getEm().createQuery(hql).getResultList()		;
        }
        catch (Exception e) 
        {
        	logger.error("", e);
		}
        return lista;
    }
	
	public ArrayList<Categoria> pesquisar(String palavra)
	{
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try
		{
			hql = "from Categoria where upper(descricao) like upper('%"+palavra+"%') order by descricao";

			Query qry = dao.getEm().createQuery(hql);
			
	        lista = (ArrayList<Categoria>)qry.getResultList(); 
        }
		catch (Exception e) 
        {
        	logger.error("", e);
		}
        return lista;
    }

	
	/**
	 *  Carrega uma lista informando os lancamentos e o valor médio gasto
	 *  
	 * @param dataInicio
	 * @param dataFim
	 * @param tipo
	 * @param listaCategorias
	 * @return
	 */
	// NAO FUNCIONA POR CAUSA DO FILTRO DE DATA
	public ArrayList<MediaPorCategoria> pesquisarMediaPorCategoria(Date dataInicio, Date dataFim, String tipo, List<Integer> listaCategorias)
	{
		ArrayList<MediaPorCategoria> retorno = new ArrayList<MediaPorCategoria>();
        try
        {
            StringBuffer sql = new StringBuffer();
            
            String cod = Utilidades.concatCodigoToSql(listaCategorias); 
            
            sql.append(" select distinct td.descricao as dsCategoria " );
            sql.append("		, sum(d.valor/( select count(DISTINCT EXTRACT (month from lancamento.data)) ");
            sql.append("							from lancamento ");
            sql.append(" 								where data between '" + dataInicio + "' and '" + dataFim + "' ");
            if (!cod.equals("")) {
            	sql.append("								and cod_categoria in ("+cod+")");
            }
            sql.append("    					)) as valor ");
            sql.append(" from lancamento d ");
            sql.append(" 	,categoria td ");
            sql.append(" where d.cod_categoria = td.cod_categoria ");
    		sql.append("	and d.data between '" + dataInicio + "' and '" + dataFim + "' ");
            sql.append("    and tipo = '" + tipo + "' ");
            if (!cod.equals("")) {
				sql.append("and d.cod_categoria in ("+cod+")");
			}
            sql.append(" group by td.descricao ");
            sql.append(" order by valor desc ");
            

            Session session = (Session) dao.getEm().getDelegate();
            Query qry = session.createNativeQuery(sql.toString(), "MediaPorCategoria");
            
            //qry.addScalar("dsCategoria", Hibernate.STRING);
            //qry.addScalar("valor", Hibernate.DOUBLE);
            
            //qry.setResultTransformer(Transformers.aliasToBean(MediaPorCategoria.class));
            retorno = (ArrayList<MediaPorCategoria>) qry.getResultList();
            
        }
        catch (Exception e) 
        {
        	logger.error("", e);
		}
        return retorno;
	}
	
	public static void main(String[] args) {
		List<Integer> listaCategorias = new ArrayList<Integer>();
		listaCategorias.add(35);
		listaCategorias.add(11);
		
		/*
		DateTime dataInicio = new DateTime(2015, 1, 1, 0, 0, 0, 0);
		DateTime dataFim = new DateTime(2017, 1, 1, 0, 0, 0, 0);

		ArrayList<MediaPorCategoria> mediaPorCategoriaList = new CategoriaDAO().pesquisarMediaPorCategoria(dataInicio.toDate(), dataFim.toDate(), "S", listaCategorias);
		*/
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(2015, 1, 1);
		
		Calendar dataFim = Calendar.getInstance();
		dataInicio.set(2017, 1, 1);

		ArrayList<MediaPorCategoria> mediaPorCategoriaList = new CategoriaDAO().pesquisarMediaPorCategoria(dataInicio.getTime(), dataFim.getTime(), "S", listaCategorias);
		
		for(MediaPorCategoria mediaPorCategoria : mediaPorCategoriaList) {
			System.out.println(mediaPorCategoria.getDsCategoria() + " : " + mediaPorCategoria.getValor());
		}
		
	}
	
}
