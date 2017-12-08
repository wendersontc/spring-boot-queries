package br.com.wenderson.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wenderson.domain.Grupos;
import br.com.wenderson.repository.GroupRepository;
import br.com.wenderson.service.GroupService;

@Service("groupService")
@Transactional
public class GroupServiceImpl extends GenericServiceImpl<Grupos, Long> implements GroupService{
    
	@Autowired
	private GroupRepository repository;
	
}
