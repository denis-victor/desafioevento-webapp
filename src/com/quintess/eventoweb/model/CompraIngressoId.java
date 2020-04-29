package com.quintess.eventoweb.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CompraIngressoId implements Serializable {
	
	private int compraId;
	
	private int ingressoId;
	
	private CompraIngressoId() {}
	
	public CompraIngressoId(int compraId, int ingressoId) {
		this.compraId = compraId;
		this.ingressoId = ingressoId;
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass())
			return false;
		
		CompraIngressoId that = (CompraIngressoId) o;
		return Objects.equals(compraId, that.compraId) &&
			   Objects.equals(ingressoId, that.ingressoId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(compraId, ingressoId);
		
	}

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getIngressoId() {
		return ingressoId;
	}

	public void setIngressoId(int ingressoId) {
		this.ingressoId = ingressoId;
	}
	
}
