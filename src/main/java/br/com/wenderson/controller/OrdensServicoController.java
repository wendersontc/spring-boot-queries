package br.com.wenderson.controller;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wenderson.domain.OrdensServico;
import br.com.wenderson.service.OrdensServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Ordens Servico controller", description = "Controller de ordens de servico")
@RestController
@RequestMapping(value = "/ordensServico")
public class OrdensServicoController {

	private final OrdensServicoService service;

	public OrdensServicoController(OrdensServicoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/descricaoCategoria/{descricao}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca produtos pela descricao da categoria")
	public Page<OrdensServico> search(
			@ApiParam(value = "descricao categoria", required = true) @PathVariable(name = "descricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "idordemservico", required = false) String sortProperty) {

		return service.search(nomeOrDescricao, page, count, direction, sortProperty);
	}

}
