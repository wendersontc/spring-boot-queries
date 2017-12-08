package br.com.wenderson.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.wenderson.domain.OrdensServico;
import br.com.wenderson.repository.OrdensServicoRepository;
import br.com.wenderson.service.OrdensServicoService;

@Service("ordensServicoService")
@Transactional
public class OrdensServicoImpl extends GenericServiceImpl<OrdensServico, Long> implements OrdensServicoService {
    
	@Autowired
	private OrdensServicoRepository repository;
	
	@Override
	public Page<OrdensServico> search(String descricao, int page, int count, Direction direction, String sortProperty) {
		return repository.search(descricao, new PageRequest(page, count, new Sort(direction, sortProperty)));
	}

}
