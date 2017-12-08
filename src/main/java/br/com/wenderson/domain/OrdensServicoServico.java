package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_ORDERM_SERVICO_SERVICOS")
public class OrdensServicoServico {
	
	@Id
	private Long idordemservico;
	
	@ManyToOne
    @JoinColumn(name="idservicos")
	private Servicos servicos;
	
	@Column(name = "quantidade")
	private Long quantidade;

	public Long getIdordemservico() {
		return idordemservico;
	}

	public void setIdordemservico(Long idordemservico) {
		this.idordemservico = idordemservico;
	}

	public Servicos getServicos() {
		return servicos;
	}

	public void setServicos(Servicos servicos) {
		this.servicos = servicos;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
