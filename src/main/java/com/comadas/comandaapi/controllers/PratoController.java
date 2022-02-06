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

import com.comadas.comandaapi.model.entities.Prato;
import com.comadas.comandaapi.model.repositories.PratoRepository;

@RestController
@RequestMapping(path = "/pratos")
public class PratoController {
	
	@Autowired
	private PratoRepository pratoRepository;
	
//	@PostMapping
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Prato novoPrato(@RequestBody Prato prato) {
		pratoRepository.save(prato);
		return prato;
	}
	
//	@PutMapping
//	public Prato atualizarPrato(@Valid Prato prato) {
//		pratoRepository.save(prato);
//		return prato;
//	}
	
	@GetMapping
	public Iterable<Prato> obterPratos() {
		return pratoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteDescricao}")
	public Iterable<Prato> obterPratosPorNome(@PathVariable String parteDescricao) {
		return pratoRepository.findByDescricaoContaining(parteDescricao);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Prato> obterPratoPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina){
		if (qtdePagina >= 5) qtdePagina = 5;

		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return pratoRepository.findAll(page);
	}
	
	@GetMapping(path = "/{idPrato}")
	public Optional<Prato> obterPratoPorId(@PathVariable int idPrato) {
		return pratoRepository.findById(idPrato);
	}
	
	@DeleteMapping(path = "/{idPrato}")
	public void apagarPrato(@PathVariable int idPrato) {
		pratoRepository.deleteById(idPrato);
	}
	
}
