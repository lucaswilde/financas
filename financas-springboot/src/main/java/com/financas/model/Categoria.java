package com.financas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "categoria")
@XmlRootElement
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -4016729271019537375L;

	@Id
	@Column(name = "cod_categoria", nullable = false)
	@SequenceGenerator(name = "seq2", sequenceName = "seq_categoria", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	private Long codCategoria;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "desabilitado", nullable = true)
	private Boolean desabilitado;

	public Categoria() {
		super();
	}
	
	public Categoria(Long codCategoria, String descricao) {
		super();
		this.codCategoria = codCategoria;
		this.descricao = descricao;
	}

	/**
	 * @return the codCategoria
	 */
	public Long getCodCategoria() {
		return codCategoria;
	}

	/**
	 * @param codCategoria the codCategoria to set
	 */
	public void setCodCategoria(Long codCategoria) {
		this.codCategoria = codCategoria;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getDesabilitado() {
		return desabilitado;
	}

	public void setDesabilitado(Boolean desabilitado) {
		this.desabilitado = desabilitado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCategoria == null) ? 0 : codCategoria.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codCategoria == null) {
			if (other.codCategoria != null)
				return false;
		} else if (!codCategoria.equals(other.codCategoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	
}
