package com.comadas.comandaapi.model.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private Date data = new Date();
	
	private String observacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemComanda> itensComanda;
	

	public Comanda() {
	}

	public Comanda(int id, Date data, Funcionario funcionario, List<ItemComanda> itemComanda) {
		super();
		this.id = id;
		this.data = data;
		this.funcionario = funcionario;
		this.itensComanda = itemComanda;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getId() {
		return id;
	}

	public int getIdComanda() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemComanda> getItemComanda() {
		return itensComanda;
	}

	public void setItemComanda(List<ItemComanda> itemComanda) {
		this.itensComanda = itemComanda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemComanda> getItensComanda() {
		return itensComanda;
	}

	public void setItensComanda(List<ItemComanda> itensComanda) {
		this.itensComanda = itensComanda;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", data=" + data + ", observacao=" + observacao + ", funcionario=" + funcionario
				+ ", cliente=" + cliente + ", itensComanda=" + itensComanda + "]";
	}

}
