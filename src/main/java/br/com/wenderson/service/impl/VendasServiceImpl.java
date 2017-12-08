package br.com.wenderson.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.wenderson.domain.Lancamentos;
import br.com.wenderson.domain.Vendas;
import br.com.wenderson.repository.VendasRepository;
import br.com.wenderson.service.VendasService;

@Service("vendasService")
@Transactional
public class VendasServiceImpl extends GenericServiceImpl<Vendas, Long> implements VendasService{
    
	@Autowired
	private VendasRepository repository;
	
	@Override
	public Page<Vendas> search(String descricao, int page, int count, Direction direction, String sortProperty) {
		return repository.search(descricao.toLowerCase(),
				new PageRequest(page, count, new Sort(direction, sortProperty)));
	}

	@Override
	public Page<Lancamentos> findAllLancamentos(int page, int count, Direction direction, String sortProperty) {
		return repository.findAllLancamentos(
				new PageRequest(page, count, new Sort(direction, sortProperty)));
	}

}
