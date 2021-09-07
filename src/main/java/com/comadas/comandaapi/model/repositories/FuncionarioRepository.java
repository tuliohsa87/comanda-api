package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Funcionario;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {
	
	public Iterable<Funcionario> findByNomeContaining(String parteNome);

}
