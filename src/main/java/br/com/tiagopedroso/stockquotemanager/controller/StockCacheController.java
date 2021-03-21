package br.com.tiagopedroso.stockquotemanager.controller;

import br.com.tiagopedroso.stockquotemanager.cache.StockCache;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 21 de mar de 2021, 19:01:36
 * Last update: -
 */// </editor-fold>
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stockcache")
public class StockCacheController {
	
	@DeleteMapping
	public ResponseEntity<String> receiveNotification() {
		
		System.out.println("\n\n Cleaning Cache... \n\n");
		
		if (StockCache.isActive() && StockCache.isRegistered()) {
			StockCache.clearAndReboot();
			return ResponseEntity.ok("Cache cleared");
		}
		
		return ResponseEntity.ok("Cache not clear...");
	}

}
