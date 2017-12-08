package br.com.wenderson.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_VENDAS")
public class Vendas {
	
    @Id
	private Long idvendas;
    
    @Column(name = "data")
    private Date data;
    
    @Column(name = "total")
    private Double total;
    
    @Column(name = "desconto")
    private Double desconto;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "idusuarios")
    private Long idusuarios;
    
    @Column(name = "idcliente")
    private Long idcliente;
    
    @ManyToOne
    @JoinColumn(name="idlancamentos")
    private Lancamentos lancamentos;

	public Long getIdvendas() {
		return idvendas;
	}

	public void setIdvendas(Long idvendas) {
		this.idvendas = idvendas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Lancamentos getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
    
    
}
