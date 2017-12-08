package br.com.wenderson.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.com.wenderson.domain.Produtos;
import br.com.wenderson.repository.ProdutosRepository;
import br.com.wenderson.service.ProdutosService;

@Service("produtosService")
@Transactional
public class ProdutosServiceImpl extends GenericServiceImpl<Produtos, Long> implements ProdutosService {

	@Autowired
	private ProdutosRepository repository;

	@Override
	public Page<Produtos> searchByNomeOrDescricaoPaginatedIgnoreCase(String nomeOrDescricao, int page, int count,
			Sort.Direction direction, String sortProperty) {
		return repository.searchByDescricaoPaginatedIgnoreCase(nomeOrDescricao.toLowerCase(),
				new PageRequest(page, count, new Sort(direction, sortProperty)));
	}

	@Override
	public Page<Produtos> search(String descricao, int page, int count, Direction direction, String sortProperty) {
		return repository.search(descricao.toLowerCase(),
				new PageRequest(page, count, new Sort(direction, sortProperty)));
	}
}
