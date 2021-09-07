package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.ItemComanda;

public interface ItemComandaRepository extends PagingAndSortingRepository<ItemComanda, Integer> {

}
