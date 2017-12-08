package br.com.wenderson.service.mock;

import br.com.wenderson.domain.Product;
import br.com.wenderson.exception.EntityInvalidException;
import br.com.wenderson.factories.CreateProductTest;
import br.com.wenderson.repository.ProductRepository;
import br.com.wenderson.service.MessagesService;
import br.com.wenderson.service.impl.ProductServiceImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplMockTest {

    @InjectMocks
    ProductServiceImpl service;

    @Mock
    MessagesService messagesService;

    @Mock
    ProductRepository repository;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    final private Product product = CreateProductTest.get(1L, "123", "Produto test", 10.5D);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPedidoSuccess() {
        when(repository.save(product)).thenReturn(product);
        Product result = service.add(product);
        assertEquals(result, product);
        assertEquals(result.getId(), product.getId());
        assertEquals(result.getCodigo(), product.getCodigo());
        assertEquals(result.getValorCompra(), product.getValorCompra());
    }

    @Test(expected = EntityInvalidException.class)
    public void createPedidoExceptionIfCodigoIsNotUnique() {
        List<Product> list = new ArrayList<>();
        list.add(product);
        when(repository.findByCodigoIgnoreCase(product.getCodigo())).thenReturn(list);
        service.add(product);
    }

    @Test(expected = EntityInvalidException.class)
    public void updatePedidoExceptionIfIdIsNull() {
        product.setId(null);
        service.update(product);
    }

    @Test(expected = EntityNotFoundException.class)
    public void updatePedidoExceptionIfEntityOnDataBaseIsNull() {
        when(repository.findOne(product.getId())).thenReturn(null);
        service.update(product);
    }

    @Test(expected = EntityInvalidException.class)
    public void updatePedidoExceptionIfCodigoIsNotUnique() {
        Product oldProduct = CreateProductTest.get(1L, "12345", "Produto", 30D);
        when(repository.findOne(product.getId())).thenReturn(oldProduct);
        List<Product> list = new ArrayList<>();
        list.add(product);
        when(repository.findByCodigoIgnoreCase(product.getCodigo())).thenReturn(list);
        service.update(product);
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteByIdExceptionIfEntityNotFound() {
        when(repository.findOne(product.getId())).thenReturn(null);
        service.removeById(product.getId());
    }
}
