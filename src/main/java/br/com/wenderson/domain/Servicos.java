package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_SERVICOS")
public class Servicos {
	
	@Id
	private Long idservicos;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private Double preco;

	public Long getIdservicos() {
		return idservicos;
	}

	public void setIdservicos(Long idservicos) {
		this.idservicos = idservicos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
