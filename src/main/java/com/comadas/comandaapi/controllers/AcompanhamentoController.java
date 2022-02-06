package com.comadas.comandaapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comadas.comandaapi.model.entities.Acompanhamento;
import com.comadas.comandaapi.model.repositories.AcompanhamentoRepository;

@RestController
@RequestMapping(path = "/acompanhamentos")
public class AcompanhamentoController {
	
	@Autowired
	public AcompanhamentoRepository acompanhamentoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Acompanhamento novoAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
		acompanhamentoRepository.save(acompanhamento);
		return acompanhamento;
	}
	
	@GetMapping
	public Iterable<Acompanhamento> obterAcompanhamentos(){
		return acompanhamentoRepository.findAll();
	}
	
	@GetMapping(path = "nome/{parteNomeAcompanhamento}")
	public Iterable<Acompanhamento> obterAcompanhamento(@PathVariable String parteNomeAcompanhamento){
		return acompanhamentoRepository.findByNomeAcompanhamentoContaining(parteNomeAcompanhamento);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/qtdePagina")
	public Iterable<Acompanhamento> obterAcompanhamentoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina){
		if (qtdePagina >=5) qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return acompanhamentoRepository.findAll(page);
	}
	
	@GetMapping(path = "/{idAcompanhamento}")
	public Optional<Acompanhamento> obterAcompanhamentoPorId(@PathVariable int idAcompanhamento){
		return acompanhamentoRepository.findById(idAcompanhamento);
	}
	
	@DeleteMapping(path = "/{idAcompanhamento}")
	public void apagarAcompanhamento(@PathVariable int idAcompanhamento) {
		acompanhamentoRepository.deleteById(idAcompanhamento);
	}

}
