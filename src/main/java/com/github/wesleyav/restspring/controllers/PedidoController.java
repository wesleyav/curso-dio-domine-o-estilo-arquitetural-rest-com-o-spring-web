package com.github.wesleyav.restspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.restspring.entities.Pedido;
import com.github.wesleyav.restspring.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping(value = "/save")
	public ResponseEntity<Pedido> salvaProduto(@RequestBody Pedido produto) {
		produto = pedidoService.save(produto);
		return ResponseEntity.ok().body(produto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarProduto(@PathVariable Long id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

	@GetMapping(value = "/busca-todos")
	public ResponseEntity<List<Pedido>> buscaTodosProdutos() {
		List<Pedido> pedidos = pedidoService.findAll();
		return ResponseEntity.ok().body(pedidos);
	}

}
