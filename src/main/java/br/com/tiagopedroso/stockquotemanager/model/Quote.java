package br.com.tiagopedroso.stockquotemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 18:54:11
 * Last update: -
 */// </editor-fold>
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Quote {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long idQuote;
	
	private LocalDate date;
	
	private String value;
	
	//Relationships
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idStockQuote")
	private StockQuote foreignStockQuote;
	
	public Quote(LocalDate date, String value) {
		this.date = date;
		this.value = value;
	}
	
	public Quote(LocalDate date, String value, StockQuote stockQuote) {
		this.date = date;
		this.value = value;
		this.foreignStockQuote = stockQuote;
	}

}
