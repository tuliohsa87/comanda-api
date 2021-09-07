package com.comadas.comandaapi.model.entities;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acompanhamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nomeAcompanhamento;
	
	private BigDecimal valor;

	public Acompanhamento() {
	}

	public Acompanhamento(int id, String nomeAcompanhamento, BigDecimal valor) {
		super();
		this.id = id;
		this.nomeAcompanhamento = nomeAcompanhamento;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Acompanhamento other = (Acompanhamento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Acompanhamento [id=" + id + ", nomeAcompanhamento=" + nomeAcompanhamento + ", valor=" + valor + "]";
	}
	
}
