package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_FORMA_PAGAMENTO")
public class FormaPagamento {
    
	@Id
	private Long idformapagamento;
	
	@Column(name = "pagamento")
	private String pagamento;

	public Long getIdformapagamento() {
		return idformapagamento;
	}

	public void setIdformapagamento(Long idformapagamento) {
		this.idformapagamento = idformapagamento;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	
}
