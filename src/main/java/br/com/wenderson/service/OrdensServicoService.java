package br.com.wenderson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import br.com.wenderson.domain.OrdensServico;

public interface OrdensServicoService extends GenericService<OrdensServico, Long>{
	
	Page<OrdensServico> search(String descricao, int page, int count,
            Sort.Direction direction, String sortProperty);

}
