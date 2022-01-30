package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Acompanhamento;

public interface AcompanhamentoRepository extends PagingAndSortingRepository<Acompanhamento, Integer> {
	
	public Iterable<Acompanhamento> findByNomeAcompanhamentoContaining(String parteNomeAcompanhamento);

}
