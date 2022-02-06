package com.comadas.comandaapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comadas.comandaapi.model.entities.StatusPedido;
import com.comadas.comandaapi.model.repositories.StatusPedidoRepository;

@RestController
@RequestMapping(path = "/status")
public class StatusPedidoController {
	
	@Autowired
	public StatusPedidoRepository statusPedidoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody StatusPedido novoStatus(@RequestBody StatusPedido statusPedido) {
		statusPedidoRepository.save(statusPedido);
		return statusPedido;
	}
	
	@GetMapping
	public Iterable<StatusPedido> obterStatusPedido() {
		return statusPedidoRepository.findAll();
	}
	
	@GetMapping(path = "/status/{parteDescricao}")
	public Iterable<StatusPedido> obterStatusPorDescricao(@PathVariable String parteDescricao) {
		return statusPedidoRepository.findByDescricaoContaining(parteDescricao);
	}
	
	@GetMapping(path = "/{idStatusPedido}")
	public Optional<StatusPedido> obterStatusPedidoPorId(@PathVariable Integer idStatusPedido) {
		return statusPedidoRepository.findById(idStatusPedido);
	}
	
	@DeleteMapping(path = "/{idStatusPedido}")
	public void apagarStatusPedido(@PathVariable int idStatusPedido) {
		statusPedidoRepository.deleteById(idStatusPedido);
	}

}
