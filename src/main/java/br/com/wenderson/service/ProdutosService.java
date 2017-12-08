package br.com.wenderson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import br.com.wenderson.domain.Produtos;

public interface ProdutosService extends GenericService<Produtos, Long>{
	
	Page<Produtos> searchByNomeOrDescricaoPaginatedIgnoreCase(String descricao, int page, int count,
            Sort.Direction direction, String sortProperty);
	
	Page<Produtos> search(String descricao, int page, int count,
            Sort.Direction direction, String sortProperty);

}
