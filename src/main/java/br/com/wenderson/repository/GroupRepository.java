package br.com.wenderson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wenderson.domain.Grupos;

public interface GroupRepository extends JpaRepository<Grupos, Long>{

}
