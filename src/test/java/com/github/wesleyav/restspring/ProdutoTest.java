package com.github.wesleyav.restspring;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.wesleyav.restspring.entities.Produto;
import com.github.wesleyav.restspring.exceptions.ProductPriceException;
import com.github.wesleyav.restspring.services.ProdutoService;

@SpringBootTest
public class ProdutoTest {

	@Autowired
	ProdutoService produtoService;

	@Test
	public void verificaValorNegativoNoProduto() throws Exception {
		Produto produto = new Produto();

		produto.setNome("teste");
		produto.setPreco(-10.0);

		assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
	}

}
