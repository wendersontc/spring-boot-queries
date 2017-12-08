package br.com.wenderson.factories;

import br.com.wenderson.domain.Product;

public class CreateProductTest {
    public static Product get(Long id, String codigo, String nome, Double valorCompra){
        return new Product(){{
            setId(id);
            setCodigo(codigo);
            setNome(nome);
            setValorCompra(valorCompra);
            setValorVenda(valorCompra);
        }};
    }
}
