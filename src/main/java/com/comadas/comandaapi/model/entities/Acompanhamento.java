package com.comadas.comandaapi.model.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Acompanhamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acompanhamento_id;
	
	private String nomeAcompanhamento;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference
	private Categoria categoria;
	
	 @ManyToMany
	    @JoinTable(
	    		name = "prato_acompanhamento",
	    		joinColumns = @JoinColumn(name = "acompanhamento_id", referencedColumnName = "acompanhamento_id"),
	    		inverseJoinColumns = @JoinColumn(name = "prato_id", referencedColumnName = "id"))
	 @JsonIgnore
	 public Set<Prato> pratos;

	public Acompanhamento() {
	}

	public Acompanhamento(int acompanhamento_id, String nomeAcompanhamento, BigDecimal valor, Categoria categoria) {
		this.acompanhamento_id = acompanhamento_id;
		this.nomeAcompanhamento = nomeAcompanhamento;
		this.valor = valor;
		this.categoria = categoria;
	}

	public int getAcompanhamento_id() {
		return acompanhamento_id;
	}

	public void setAcompanhamento_id(int acompanhamento_id) {
		this.acompanhamento_id = acompanhamento_id;
	}

	public String getNomeAcompanhamento() {
		return nomeAcompanhamento;
	}

	public void setNomeAcompanhamento(String nomeAcompanhamento) {
		this.nomeAcompanhamento = nomeAcompanhamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
