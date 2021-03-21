package br.com.tiagopedroso.stockquotemanager.request;

import br.com.tiagopedroso.stockquotemanager.model.dto.StockDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@FeignClient(name = "stockmanager", url = "")
public interface StockClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/stock	")
	public List<StockDto> list();
	
	@RequestMapping(method = RequestMethod.GET, value = "/stock/{id}")
	public StockDto get(@PathVariable("id") String id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/stock", consumes = "application/json")
	public ResponseEntity<StockDto> create(@RequestBody StockDto stockDto);

}
