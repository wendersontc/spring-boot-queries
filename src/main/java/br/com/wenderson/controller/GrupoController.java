package br.com.wenderson.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wenderson.domain.Grupos;
import br.com.wenderson.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Grupo controller", description = "Controller do grupos")
@RestController
@RequestMapping(value = "/group")
public class GrupoController {
	    
	    private final GroupService service;
	    
	    public GrupoController(GroupService service) {
			this.service = service;
		}
	    
	    @RequestMapping(method = RequestMethod.GET)
	    @ApiOperation(value = "busca todos")
	    public Page<Grupos> getAllPaginated(
	            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
	            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
	            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
	            @RequestParam(value = "sort", defaultValue = "nome", required = false) String sortProperty) {

	        return service.getAllPaginated(page, count, direction, sortProperty);
	    }

}
