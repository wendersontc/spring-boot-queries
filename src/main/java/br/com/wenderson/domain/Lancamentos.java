package br.com.wenderson.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_LANCAMENTOS")
public class Lancamentos {
	
	@Id
	private Long idlancamentos;
    
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "valor")
	private Double valor;
	
	
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
    @JoinColumn(name="idformapagamento")
	private FormaPagamento formapagamento;

	public Long getIdlancamentos() {
		return idlancamentos;
	}

	public void setIdlancamentos(Long idlancamentos) {
		this.idlancamentos = idlancamentos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FormaPagamento getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(FormaPagamento formapagamento) {
		this.formapagamento = formapagamento;
	}
	
	
}
