package com.comadas.comandaapi.model.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Prato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String descricao;
	
    private double precoUnitario;
    
    @ManyToMany
    @JoinTable(
    		name = "prato_acompanhamento",
    		joinColumns = @JoinColumn(name = "prato_id", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(name = "acompanhamento_id", referencedColumnName = "acompanhamento_id"))
    public Set<Acompanhamento> acompanhamentos;

	public Prato() {
	}

	public Prato(int id, String descricao, double precoUnitario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
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
		Prato other = (Prato) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Prato [id=" + id + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario + "]";
	}

}
