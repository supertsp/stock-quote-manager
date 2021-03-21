package br.com.tiagopedroso.stockquotemanager.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Value;
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
@RestController
public class AppController {
	
	@Value("${app.message}")
	private String appMessage;
	
	@GetMapping("/")
	public String getAppMessage() {
		return appMessage;
	}
	
	
}
