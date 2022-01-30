package com.comadas.comandaapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comadas.comandaapi.model.entities.Comanda;
import com.comadas.comandaapi.model.repositories.ComandaRepository;

@RestController
@RequestMapping(path = "/api/comandas")
public class ComandaController {
	
	@Autowired
	private ComandaRepository comandaRepository;

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Comanda novaComanda(@RequestBody Comanda comanda) {
		comandaRepository.save(comanda);
		return comanda;
	}
	
	@GetMapping
	public Iterable<Comanda> obterComandas() {
		return comandaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Comanda> obterComandaPorId(@PathVariable int id) {
		return comandaRepository.findById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void apagarComanda(@PathVariable int id) {
		comandaRepository.deleteById(id);
	}
	

}
