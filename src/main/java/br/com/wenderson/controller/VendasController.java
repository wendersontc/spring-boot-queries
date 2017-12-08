package br.com.wenderson.controller;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wenderson.domain.Lancamentos;
import br.com.wenderson.domain.Vendas;
import br.com.wenderson.service.VendasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Vendas controller", description = "Controller de Vendas")
@RestController
@RequestMapping(value = "/vendas")
public class VendasController {

	private final VendasService service;

	public VendasController(VendasService service) {
		this.service = service;
	}

	@RequestMapping(value = "/formaPagamento/{descricao}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca forma de pagamento pela descricao")
	public Page<Vendas> search(
			@ApiParam(value = "descricao categoria", required = true) @PathVariable(name = "descricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "idvendas", required = false) String sortProperty) {

		return service.search(nomeOrDescricao, page, count, direction, sortProperty);
	}
	
	@RequestMapping(value = "/findAllLancamentos", method = RequestMethod.GET)
	@ApiOperation(value = "Todos os Lancamentos")
	public Page<Lancamentos> findAllLancamentos(
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "status", required = false) String sortProperty) {

		return service.findAllLancamentos(page, count, direction, sortProperty);
	}

}
