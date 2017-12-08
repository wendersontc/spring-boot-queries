package br.com.wenderson.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.wenderson.domain.Lancamentos;
import br.com.wenderson.domain.Vendas;

public interface VendasRepository extends JpaRepository<Vendas, Long>{
	
	@Query(value = "SELECT v FROM Vendas v JOIN v.lancamentos l JOIN l.formapagamento f WHERE LOWER(f.pagamento) LIKE %?1% ")
    Page<Vendas> search(String nomeOrDescricao, Pageable page);
	
	@Query(value = "SELECT l FROM Lancamentos l")
    Page<Lancamentos> findAllLancamentos(Pageable page);

}
