package com.comadas.comandaapi.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemComanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double preco;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Prato> pratos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Acompanhamento> acompanhamentos = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Comanda comanda;

	public ItemComanda() {
	}

	public ItemComanda(int id, int quantidade, Double preco, List<Prato> pratos, List<Acompanhamento> acompanhamentos) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
		this.pratos = pratos;
		this.acompanhamentos = acompanhamentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public List<Acompanhamento> getAcompanhamentos() {
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemComanda other = (ItemComanda) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ItemComanda [id=" + id + ", quantidade=" + quantidade + ", preco=" + preco + ", pratos=" + pratos
				+ ", acompanhamentos=" + acompanhamentos + "]";
	}	
	
}
