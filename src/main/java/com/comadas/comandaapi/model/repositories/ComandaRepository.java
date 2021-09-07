package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Comanda;

public interface ComandaRepository extends PagingAndSortingRepository<Comanda, Integer> {

}
