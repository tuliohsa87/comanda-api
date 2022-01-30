package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
	
	public Iterable<Cliente> findByTelefoneContaining(String parteTelefone);
	
	public Iterable<Cliente> findByNomeContaining(String parteNome);
	
	public Iterable<Cliente> findBySobrenomeContaining(String parteSobrenome);

}
