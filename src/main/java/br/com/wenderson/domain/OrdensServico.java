package br.com.wenderson.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_ORDERM_SERVICO")
public class OrdensServico {
	
	@Id
	private Long idordemservico;
	
	@ManyToMany(mappedBy = "servicos")
	private Set<OrdensServicoServico> servico;
    
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "garantia")
	private String garantia;
	
	@Column(name = "idusuarios")
	private Long idusuarios;
	
	@Column(name = "idcliente")
	private Long idcliente;
	
	@Column(name = "idlancamentos")
	private Long idlancamentos;
	
	@Column(name = "status")
	private String status;

	public Set<OrdensServicoServico> getServico() {
		return servico;
	}

	public void setServico(Set<OrdensServicoServico> servico) {
		this.servico = servico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public Long getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Long getIdlancamentos() {
		return idlancamentos;
	}

	public void setIdlancamentos(Long idlancamentos) {
		this.idlancamentos = idlancamentos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
}
