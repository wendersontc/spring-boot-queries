package br.com.wenderson.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.wenderson.domain.OrdensServico;

public interface OrdensServicoRepository extends JpaRepository<OrdensServico, Long>{
   
	@Query(value = "SELECT o FROM OrdensServico o JOIN o.servico s JOIN s.servicos d WHERE LOWER(d.descricao) LIKE %?1% ")
    Page<OrdensServico> search(String nomeOrDescricao, Pageable page);
}
