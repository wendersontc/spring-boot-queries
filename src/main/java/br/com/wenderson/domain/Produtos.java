package br.com.wenderson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;;

@Entity
@Table(name = "MAN_PRODUTOS")
public class Produtos {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long idprodutos;
	    
	    @Column(name = "ean")
	    private String ean;
	    
	    @Column(name = "descricao")
	    private String descricao;
	    
	    @Column(name = "imagem")
	    private String imagem;
	    
	    @Column(name = "valor_c")
	    private Double valorCompra;
	   
	    @Column(name = "valor_u")
	    private Double valorVenda;

	    @Column(name = "unidade")
	    private String unidade;
	    
	    @Column(name = "detalhes")
	    private String detalhes;
	    
	    @Column(name = "idprovedor")
	    private Long idprovedor;
	    
	    
	    @ManyToOne
	    @JoinColumn(name="idcategorias")
	    private Categorias categorias;
        
	    @Column (name = "idestoque")
	    private Long idestoque;
	    
		public Long getIdprodutos() {
			return idprodutos;
		}

		public void setIdprodutos(Long idprodutos) {
			this.idprodutos = idprodutos;
		}

		public String getEan() {
			return ean;
		}

		public void setEan(String ean) {
			this.ean = ean;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getImagem() {
			return imagem;
		}

		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public Double getValorCompra() {
			return valorCompra;
		}

		public void setValorCompra(Double valorCompra) {
			this.valorCompra = valorCompra;
		}

		public Double getValorVenda() {
			return valorVenda;
		}

		public void setValorVenda(Double valorVenda) {
			this.valorVenda = valorVenda;
		}

		public String getUnidade() {
			return unidade;
		}

		public void setUnidade(String unidade) {
			this.unidade = unidade;
		}

		public String getDetalhes() {
			return detalhes;
		}

		public void setDetalhes(String detalhes) {
			this.detalhes = detalhes;
		}

		public Long getIdprovedor() {
			return idprovedor;
		}

		public void setIdprovedor(Long idprovedor) {
			this.idprovedor = idprovedor;
		}

		public Categorias getCategorias() {
			return categorias;
		}

		public void setCategorias(Categorias categorias) {
			this.categorias = categorias;
		}

		public Long getIdestoque() {
			return idestoque;
		}

		public void setIdestoque(Long idestoque) {
			this.idestoque = idestoque;
		}

	
	    

}
