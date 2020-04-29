package com.quintess.eventoweb.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Compra_Ingresso")
public class CompraIngresso {
	
	@EmbeddedId
	private CompraIngressoId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("compraId")
	private Compra compra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("ingressoId")
	private Ingresso ingresso;
	
	@Column(nullable = false)
	private int quantidade;
	
	private CompraIngresso(){}
	
	public CompraIngresso(Compra compra, Ingresso ingresso, int quantidade) {
		this.compra = compra;
		this.ingresso = ingresso;
		this.quantidade = quantidade;
		this.id = new CompraIngressoId(compra.getId(), ingresso.getId());
	}

	public CompraIngressoId getId() {
		return id;
	}

	public void setId(CompraIngressoId id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

}
