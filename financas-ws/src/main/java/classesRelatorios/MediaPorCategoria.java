package classesRelatorios;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

@Entity
@SqlResultSetMapping(name = "MediaPorCategoria", entities = {
		@EntityResult(entityClass = MediaPorCategoria.class, fields = {
				@FieldResult(name = "dsCategoria", column = "dsCategoria"),
				@FieldResult(name = "valor", column = "valor"), 
				@FieldResult(name = "data", column = "data") }) 
		}
)
public class MediaPorCategoria {

	@Id
	private Integer cod;
	
	private String dsCategoria;
    
    private Double valor = 0.0;
    
    @Transient
    private MesAno mesAno;
    
    private Calendar data;
    
    public MediaPorCategoria(){
    	
    }

	public String getDsCategoria() {
		return dsCategoria;
	}

	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValorTotal(Double valor) {
		this.valor = valor;
	}

	public void setMesAno(MesAno mesAno) {
		this.mesAno = mesAno;
	}

	public MesAno getMesAno() {
		return mesAno;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getData() {
		return data;
	}
    
    
    
}
