package br.com.tiagopedroso.stockquotemanager.config;

import feign.Contract;
import feign.Feign;
import java.util.List;
import java.util.ArrayList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class StockClientConfiguration {
	
	@Bean
	public Contract getfeignContract() {
		return new Contract.Default();
	}

}
