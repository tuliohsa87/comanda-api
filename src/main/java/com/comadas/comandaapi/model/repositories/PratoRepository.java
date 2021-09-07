package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Prato;

public interface PratoRepository extends PagingAndSortingRepository<Prato, Integer> {
	
	public Iterable<Prato> findByDescricaoContaining(String parteDescricao);

}
