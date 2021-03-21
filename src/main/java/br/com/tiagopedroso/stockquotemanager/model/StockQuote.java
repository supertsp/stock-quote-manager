package br.com.tiagopedroso.stockquotemanager.model;

import br.com.tiagopedroso.stockquotemanager.pattern.ObjectDtoHandler;
import br.com.tiagopedroso.stockquotemanager.model.dto.QuoteDto;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockQuoteDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 * @author tiago, 20 de mar de 2021, 18:42:54
 * Last update: -
 */// </editor-fold>
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StockQuote implements ObjectDtoHandler<StockQuoteDto>{
	
	@Id
	private String id;
	
	//Relationships
	@JsonIgnore
	@OneToMany(mappedBy = "foreignStockQuote", cascade = CascadeType.ALL)
	private List<Quote> listOfQuotes;
	
	public StockQuote(String id, List<Quote> quotes) {
		this.id = id;
		this.listOfQuotes = quotes;
	}
	
	@Override
	public StockQuoteDto transformToDto() {
		HashMap<LocalDate, String> quotes = new HashMap<>();
		
		if (listOfQuotes != null) {
			listOfQuotes.stream()
					.forEach(quote -> {
						quotes.put(quote.getDate(), quote.getValue());
					});			
		}
		
		StockQuoteDto stockQuoteDto = new StockQuoteDto();
		stockQuoteDto.setId(id);
		stockQuoteDto.setQuotes(quotes);
		
		return stockQuoteDto;
	}

}