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

import com.comadas.comandaapi.model.entities.Categoria;
import com.comadas.comandaapi.model.repositories.CategoriaRepository;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Categoria novaCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.save(categoria);
		return categoria;
	}
	
	@GetMapping
	public Iterable<Categoria> obterCategorias() {
		return categoriaRepository.findAll();
	}
	
	@GetMapping(path = "/descricao/{parteDescricao}")
	public Iterable<Categoria> obterCategoriaPorDescricao(@PathVariable String parteDescricao) {
		return categoriaRepository.findByDescricaoContaining(parteDescricao);
	}
	
	@GetMapping(path = "/{idCategoria}")
	public Optional<Categoria> obterCategoriaPorId(@PathVariable Integer idCategoria) {
		return categoriaRepository.findById(idCategoria);
	}
	
	@DeleteMapping(path = "/{idCategoria}")
	public void apagarCategoria(@PathVariable int idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}

}
