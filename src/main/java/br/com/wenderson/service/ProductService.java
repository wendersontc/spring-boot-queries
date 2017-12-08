package br.com.wenderson.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import br.com.wenderson.domain.Product;

import java.util.List;

public interface ProductService extends GenericService<Product, Long>{

    List<Product> searchByNomeIgnoreCase(String nome);
    List<Product> searchByDescricaoIgnoreCase(String descricao);
    List<Product> searchByNomeOrDescricaoIgnoreCase(String nomeOrDescricao);
    Page<Product> searchByNomeOrDescricaoPaginatedIgnoreCase(String nomeOrDescricao, int page, int count,
                                                             Sort.Direction direction, String sortProperty);
}

