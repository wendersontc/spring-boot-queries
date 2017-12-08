package br.com.wenderson.controller;

import br.com.wenderson.domain.Product;
import br.com.wenderson.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Api(value = "Produto controller", description = "Controller do produto")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Iterable<Product> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "busca todos os aparelhos com paginação")
    public Page<Product> getAllPaginated(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "nome", required = false) String sortProperty) {

        return service.getAllPaginated(page, count, direction, sortProperty);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Encontra um produto pelo ID")
    public Product find(@ApiParam(value = "Id do Produto", required = true) @PathVariable Long id) {
        Product product = service.get(id);
        if (product == null) {
            throw new EntityNotFoundException("Product.nao.existe");
        } else {
            return product;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Cria um produto")
    public Product create(@ApiParam(value = "Produto", required = true) @RequestBody @Valid Product product) {
        return service.add(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza produto")
    public Product update(@ApiParam(value = "Produto", required = true) @RequestBody @Valid Product product) {
        return service.update(product);
    }

    @RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca produtos pelo nome")
    public List<Product> searchByNome(
            @ApiParam(value = "Nome do produto", required = true)
            @PathVariable(name = "nome") @NotNull(message = "Nao pode ser nulo")  String nome) {
        return service.searchByNomeIgnoreCase(nome);
    }


    @RequestMapping(value = "/descricao/{descricao}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca produtos pela descricao")
    public List<Product> searchByDescricao(
            @ApiParam(value = "Descrição do produto", required = true)
            @PathVariable(name = "descricao") @NotNull(message = "Nao pode ser nulo")  String descricao) {
        return service.searchByDescricaoIgnoreCase(descricao);
    }

    @RequestMapping(value = "/nomeOrDescricao/{nomeOrDescricao}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca produtos por nome ou pela descricao")
    public List<Product> searchByNomeOrDescricao(
            @ApiParam(value = "Nome ou descrição do produto", required = true)
            @PathVariable(name = "nomeOrDescricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao) {
        return service.searchByNomeOrDescricaoIgnoreCase(nomeOrDescricao);
    }

    @RequestMapping(value = "/nomeOrDescricaoPaginated/{nomeOrDescricao}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca produtos por nome ou pela descricao paginando a consulta")
    public Page<Product> searchByNomeOrDescricaoPaginated(
            @ApiParam(value = "Nome ou descrição do produto", required = true)
            @PathVariable(name = "nomeOrDescricao") @NotNull(message = "Nao pode ser nulo") String nomeOrDescricao,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "count", defaultValue = "10", required = false) int count,
            @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
            @RequestParam(value = "sort", defaultValue = "nome", required = false) String sortProperty) {

        return service.searchByNomeOrDescricaoPaginatedIgnoreCase(nomeOrDescricao, page, count, direction, sortProperty);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletar um produto pelo ID")
    public HttpEntity<Product> delete(@ApiParam(value = "Id do produto", required = true) @PathVariable Long id) {
        service.removeById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta uma lista de produtos")
    public HttpEntity<Product> deleteAll(@ApiParam(value = "Produtos", required = true) @RequestBody Set<Product> products) {
        service.removeEntities(products);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
