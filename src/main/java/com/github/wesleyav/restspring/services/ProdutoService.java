package com.github.wesleyav.restspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wesleyav.restspring.entities.Produto;
import com.github.wesleyav.restspring.exceptions.ProductNullException;
import com.github.wesleyav.restspring.exceptions.ProductPriceException;
import com.github.wesleyav.restspring.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto save(Produto produto) throws Exception {
		if (produto.getNome() == null || produto.getPreco() == null) {
			throw new ProductNullException();
		}
		if (produto.getPreco() < 0) {
			throw new ProductPriceException();
		}
		return produtoRepository.save(produto);
	}

	public Produto findById(Long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

}
