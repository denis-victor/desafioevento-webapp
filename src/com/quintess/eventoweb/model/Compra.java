package com.quintess.eventoweb.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private LocalDate dtCompra;
	
	@Column(nullable = false, scale =2)
	private BigDecimal valor = new BigDecimal(0);
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true) 
	private List<CompraIngresso> ingresso = new ArrayList<CompraIngresso>();
	
	public void adicionaIngresso(Ingresso ingresso, int quantidade) {
		CompraIngresso compraIngresso = new CompraIngresso(this, ingresso, quantidade);
		
		ingresso.add(compraIngresso);
		ingresso.getCompras().add(compraIngresso);;
		
		double valorCompra = this.valor.doubleValue();
		double valorIngressoUnit = ingresso.getValorUnitario().doubleValue();
		
		valorCompra += (valorIngressoUnit * quantidade);
		this.valor = new BigDecimal(valorCompra);
	}

	public int getId() {
		
		return 0;
	}
	
}
