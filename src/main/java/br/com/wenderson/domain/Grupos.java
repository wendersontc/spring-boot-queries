package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MAN_GRUPO")
public class Grupos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idgrupo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;

	public Long getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(Long idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
