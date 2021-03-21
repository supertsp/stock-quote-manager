package br.com.tiagopedroso.stockquotemanager.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 17:26:28
 * Last update: -
 */// </editor-fold>
@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DbConfiguration {
	
	private String url;
	private String username;
	private String password;

}
