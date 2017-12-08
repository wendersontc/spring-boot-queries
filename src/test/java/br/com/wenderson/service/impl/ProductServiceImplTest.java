package br.com.wenderson.service.impl;

import br.com.wenderson.WsLojavirtualApplication;
import br.com.wenderson.domain.Product;
import br.com.wenderson.repository.ProductRepository;
import br.com.wenderson.service.MessagesService;
import br.com.wenderson.service.impl.ProductServiceImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { WsLojavirtualApplication.class })
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl service;

    @Autowired
    MessagesService messagesService;

    @Autowired
    ProductRepository repository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void contextLoads() {
    }

    @Test
    public void createPedidoSuccess() {
        Product product = new Product();
        product.setId(null);
        product.setCodigo("123");
        product.setNome("Produto");
        product.setEstoque(50L);
        product.setDescricao("Produto");
        product.setValorCompra(10D);
        product.setValorVenda(10D);

        Product result = service.add(product);

        assertEquals(result.getDescricao(), "Produto");
        assertEquals(result.getCodigo(), product.getCodigo());
        assertEquals(result.getValorCompra(), product.getValorCompra());

        service.removeById(product.getId());
    }

    @Test
    public void updateSuccess() {
        Product product = new Product();
        product.setId(null);
        product.setCodigo("123");
        product.setNome("Produto");
        product.setEstoque(50L);
        product.setDescricao("Produto");
        product.setValorCompra(10D);
        product.setValorVenda(10D);

        Product result = service.add(product);

        assertEquals(result.getDescricao(), "Produto");
        assertEquals(result.getCodigo(), product.getCodigo());
        assertEquals(result.getValorCompra(), product.getValorCompra());

        result.setCodigo("12");
        result.setNome("Produto atualizado");
        result.setValorCompra(30D);

        Product result2 = service.update(result);

        assertEquals(result.getId(), result2.getId());
        assertEquals(result2.getNome(), "Produto atualizado");
        assertEquals(result2.getCodigo(), result.getCodigo());
        assertEquals(result2.getValorCompra(), new Double(30));

        service.removeById(result.getId());
    }
}
