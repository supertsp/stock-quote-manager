package br.com.tiagopedroso.stockquotemanager.controller;

import br.com.tiagopedroso.stockquotemanager.cache.StockCache;
import br.com.tiagopedroso.stockquotemanager.config.StockClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.config.StockNotificationClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockQuoteDto;
import br.com.tiagopedroso.stockquotemanager.service.StockQuoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 19:37:26 Last update: -
 */// </editor-fold>
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stockquote")
public class StockQuoteController {

	@Value("${server.port}")
	private String apiPort;
	
	@Autowired
	private StockQuoteService stockQuoteService;
	
	@Autowired
	private StockNotificationClientConfiguration stockNotificationClientConfiguration;
	
	@Autowired
	private StockClientConfiguration stockClientConfiguration;
	
	private boolean isFirstExecution = true;

	@GetMapping
	public ResponseEntity<List<StockQuoteDto>> list() {
		List<StockQuoteDto> listOfStockQuoteDto = stockQuoteService.list();
		
		if (listOfStockQuoteDto == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listOfStockQuoteDto);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StockQuoteDto> get(@PathVariable("id") String id){
		StockQuoteDto stockQuoteDto = stockQuoteService.get(id);
		
		if (stockQuoteDto == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(stockQuoteDto);
		}
	}

	@PostMapping
	public ResponseEntity<StockQuoteDto> create(@RequestBody StockQuoteDto stockQuoteDto) {
		if (isFirstExecution) {
			StockCache.activate();
			StockCache.registerNotification(stockNotificationClientConfiguration, stockClientConfiguration);
			StockCache.clearAndReboot();
			isFirstExecution = false;
		}
		
//		StockClient stockClient = stockClientConfiguration.getClientInstance();		
//		StockQuoteDto createdStockQuote = stockQuoteService.create(stockQuoteDto, stockClient.get(stockQuoteDto.getId()));
		
		if (StockCache.containsById(stockQuoteDto.getId())) {
			StockQuoteDto createdStockQuote = stockQuoteService.create(stockQuoteDto);

			if (createdStockQuote == null) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(StockQuoteDto.instantiateEmpty());
			} else {
				return ResponseEntity.status(HttpStatus.CREATED).body(createdStockQuote);
			}			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(StockQuoteDto.instantiateEmpty());
	}

}
