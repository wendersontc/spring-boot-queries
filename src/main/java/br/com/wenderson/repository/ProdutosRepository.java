package br.com.wenderson.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.wenderson.domain.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	
	@Query(value = "SELECT p FROM Produtos p WHERE LOWER(descricao) LIKE %?1% ")
    Page<Produtos> searchByDescricaoPaginatedIgnoreCase(String nomeOrDescricao, Pageable page);
	
	@Query(value = "SELECT p FROM Produtos p JOIN p.categorias c WHERE LOWER(c.descricao) LIKE %?1% ")
    Page<Produtos> search(String nomeOrDescricao, Pageable page);

}
