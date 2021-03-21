package br.com.tiagopedroso.stockquotemanager.controller;

import br.com.tiagopedroso.stockquotemanager.cache.StockCache;
import br.com.tiagopedroso.stockquotemanager.config.StockClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.config.StockNotificationClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockNotificationDto;
import br.com.tiagopedroso.stockquotemanager.request.StockClient;
import br.com.tiagopedroso.stockquotemanager.request.StockNotificationClient;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 17:39:59
 * Last update: -
 */// </editor-fold>
@CrossOrigin(origins = "*")
@RestController
public class AppController {
	
	@Value("${app.message}")
	private String appMessage;
	
	@Value("${spring.application.name}")
	private String apiName;
	
	@Value("${server.port}")
	private String apiPort;
	
	@Value("${spring.profiles.active}")
	private String currentEnvironment;
	
	@Autowired
	private StockNotificationClientConfiguration stockNotificationClientConfiguration;
	
	@Autowired
	private StockClientConfiguration stockClientConfiguration;
	
	@GetMapping("/")
	public String getAppMessage() {
		StockCache.activate();
		StockCache.registerNotification(stockNotificationClientConfiguration, stockClientConfiguration);
		StockCache.clearAndReboot();

		return appMessage + " - isActive: " + StockCache.isActive() + ", isEmpty: " + StockCache.isEmpty() + ", cache: " + StockCache.getCache();
	}
	
	
}
