package br.com.wenderson.controller;

import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.wenderson.domain.Produtos;
import br.com.wenderson.service.ProdutosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Produtos controller", description = "Controller do produtos")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

	private final ProdutosService service;

	public ProdutosController(ProdutosService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "busca todos")
	public Page<Produtos> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "descricao", required = false) String sortProperty) {

		return service.getAllPaginated(page, count, direction, sortProperty);
	}

	@RequestMapping(value = "/nomeOrDescricaoPaginated/{nomeOrDescricao}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca produtos por nome ou pela descricao paginando a consulta")
	public Page<Produtos> searchByNomeOrDescricaoPaginated(
			@ApiParam(value = "Nome ou descrição do produto", required = true) @PathVariable(name = "nomeOrDescricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "descricao", required = false) String sortProperty) {

		return service.searchByNomeOrDescricaoPaginatedIgnoreCase(nomeOrDescricao, page, count, direction,
				sortProperty);
	}
	
	@RequestMapping(value = "/descricaoCategoria/{descricao}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca produtos pela descricao da categoria")
	public Page<Produtos> search(
			@ApiParam(value = "descricao categoria", required = true) @PathVariable(name = "descricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "count", defaultValue = "10", required = false) int count,
			@RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
			@RequestParam(value = "sort", defaultValue = "descricao", required = false) String sortProperty) {

		return service.search(nomeOrDescricao, page, count, direction,
				sortProperty);
	}

}
