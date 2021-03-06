package br.com.tiagopedroso.stockquotemanager.request;

import br.com.tiagopedroso.stockquotemanager.model.dto.StockDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;
import org.springframework.http.ResponseEntity;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 21 de mar de 2021, 09:51:39
 * Last update: -
 */// </editor-fold>
public interface StockClient {
	
	@RequestLine("GET /stock")
	public List<StockDto> list();
	
	@RequestLine("GET /stock/{id}")
	public StockDto get(@Param("id") String id);
	
	@RequestLine("POST /stock")
	@Headers("Content-Type: application/json")
	public ResponseEntity<StockDto> create(StockDto stockDto);

}
