package br.com.wenderson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import br.com.wenderson.domain.Lancamentos;
import br.com.wenderson.domain.Vendas;

public interface VendasService extends GenericService<Vendas, Long>{
	
	Page<Vendas> search(String descricao, int page, int count,
            Sort.Direction direction, String sortProperty);
    
	 Page<Lancamentos> findAllLancamentos(int page, int count,
	            Sort.Direction direction, String sortProperty);
}
