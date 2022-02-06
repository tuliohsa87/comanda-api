package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.StatusPedido;

public interface StatusPedidoRepository extends PagingAndSortingRepository<StatusPedido, Integer> {
	
	public Iterable<StatusPedido> findByDescricaoContaining(String parteDescricao);

}
