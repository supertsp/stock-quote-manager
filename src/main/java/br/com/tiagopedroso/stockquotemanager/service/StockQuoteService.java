package br.com.tiagopedroso.stockquotemanager.service;

import br.com.tiagopedroso.stockquotemanager.model.Quote;
import br.com.tiagopedroso.stockquotemanager.model.StockQuote;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockDto;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockQuoteDto;
import br.com.tiagopedroso.stockquotemanager.repository.QuoteRepository;
import br.com.tiagopedroso.stockquotemanager.repository.StockQuoteRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 19:49:49 Last update: -
 */// </editor-fold>
@Service
public class StockQuoteService {

	@Autowired
	private StockQuoteRepository stockQuoteRepository;

	@Autowired
	private QuoteRepository quoteRepository;

	public StockQuote searchByStockQuoteId(String id) {
		StockQuote searchedStockQuote = null;

		try {
			searchedStockQuote = stockQuoteRepository.findById(id).get();
			return searchedStockQuote;
		} catch (Exception e) {
			return searchedStockQuote;
		}
	}

	public List<StockQuoteDto> list() {
		List<StockQuoteDto> listOfStockQuoteDto = new ArrayList<>();

		stockQuoteRepository.findAll().forEach(stockQuoteItem -> {
			listOfStockQuoteDto.add(stockQuoteItem.transformToDto());
		});

		return listOfStockQuoteDto.isEmpty() ? null : listOfStockQuoteDto;
	}

	public StockQuoteDto get(String id) {
		Optional<StockQuote> optional = stockQuoteRepository.findById(id);
		
		if (optional.isPresent()) {
			return optional.get().transformToDto();
		}

		return null;
	}

	public StockQuoteDto create(StockQuoteDto stockQuoteDto) {
		if (stockQuoteDto != null && stockQuoteDto.getId() != null && !stockQuoteDto.getId().isEmpty()) {
			StockQuote tranformedStockQuote = stockQuoteDto.transformToObject();
			StockQuote savedStockQuote = stockQuoteRepository.save(tranformedStockQuote);

			if (savedStockQuote != null) {
				HashMap<LocalDate, String> quotes = stockQuoteDto.getQuotes();

				for (Map.Entry<LocalDate, String> element : quotes.entrySet()) {
					LocalDate date = element.getKey();
					String value = element.getValue();
					quoteRepository.save(
							new Quote(date, value, savedStockQuote)
					);
				}

				return stockQuoteDto;
			}
		}

		return null;
	}

}
