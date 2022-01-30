package com.comadas.comandaapi.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoria_id;
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	//@JsonManagedReference
	@JsonBackReference
	List<Acompanhamento> acompanhamento;
	
	public Categoria() {
	}

	public Categoria(Integer categoria_id, String descricao, List<Acompanhamento> acompanhamento) {
		this.categoria_id = categoria_id;
		this.descricao = descricao;
		this.acompanhamento = acompanhamento;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Acompanhamento> getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(List<Acompanhamento> acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

}
