package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_CATEGORIAS")
public class Categorias {
	
	@Id
	public Long idcategorias;
	
	@Column(name = "descricao")
	public String descricao;

	public Long getIdcategorias() {
		return idcategorias;
	}

	public void setIdcategorias(Long idcategorias) {
		this.idcategorias = idcategorias;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
