package com.comadas.comandaapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comadas.comandaapi.model.entities.Cliente;
import com.comadas.comandaapi.model.repositories.ClienteRepository;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Cliente novoCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@GetMapping
	public Iterable<Cliente> obterClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/telefone/{parteTelefone}")
	public Iterable<Cliente> obterClientesPorTelefone(@PathVariable String parteTelefone){
		return clienteRepository.findByTelefoneContaining(parteTelefone);
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Cliente> obterClientesPorNome(@PathVariable String parteNome){
		return clienteRepository.findByNomeContaining(parteNome);
	}
	
	@GetMapping(path = "/sobrenome/{parteSobrenome}")
	public Iterable<Cliente> obterClientesPorSobrenome(@PathVariable String parteSobrenome){
		return clienteRepository.findBySobrenomeContaining(parteSobrenome);
	}
	
	@GetMapping(path = "/{idCliente}")
	public Optional<Cliente> obterClientePorId(@PathVariable int idCliente) {
		return clienteRepository.findById(idCliente);
	}
	
	@DeleteMapping(path = "/{idCliente}")
	public void apagarCliente(@PathVariable int idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
}
