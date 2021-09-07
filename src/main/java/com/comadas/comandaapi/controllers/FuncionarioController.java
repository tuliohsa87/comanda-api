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

import com.comadas.comandaapi.model.entities.Funcionario;
import com.comadas.comandaapi.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping(path = "/api/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Funcionario novoFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@GetMapping
	public Iterable<Funcionario> obterFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping(path = "/{idFuncionario}")
	public Optional<Funcionario> obterFuncionario(@PathVariable int idFuncionario) {
		return funcionarioRepository.findById(idFuncionario);
	}
	
	@DeleteMapping(path = "/{idFuncionario}")
	public void apagarFuncionario(@PathVariable int idFuncionario) {
		funcionarioRepository.deleteById(idFuncionario);
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Funcionario> obterFuncionarioPorNome(@PathVariable String parteNome){
		return funcionarioRepository.findByNomeContaining(parteNome);
	}
	

}
