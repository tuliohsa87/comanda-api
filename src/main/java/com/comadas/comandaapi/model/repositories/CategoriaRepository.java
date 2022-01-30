package com.comadas.comandaapi.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.comadas.comandaapi.model.entities.Categoria;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Integer> {

	public Iterable<Categoria> findByDescricaoContaining(String parteDescricao);
}
