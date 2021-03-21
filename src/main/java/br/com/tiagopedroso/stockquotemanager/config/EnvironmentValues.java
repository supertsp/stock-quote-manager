package br.com.tiagopedroso.stockquotemanager.config;

import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 18:23:18
 * Last update: -
 */// </editor-fold>
@Getter
@Setter
public class EnvironmentValues {
	
//	@Autowired
//	private Environment environment;
	
	@Value("${spring.application.name}")
	private String apiName;
	
	@Value("${server.port}")
	private String apiPort;
	
	@Value("${spring.profiles.active}")
	private String currentEnvironment;

}
