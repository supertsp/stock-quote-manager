package br.com.tiagopedroso.stockquotemanager.config;

import br.com.tiagopedroso.stockquotemanager.request.StockClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 21 de mar de 2021, 09:51:39 Last update: -
 */// </editor-fold>
@Configuration
public class StockClientConfiguration {

	private StockClient client;

	public StockClient getClientInstance() {
		if (client == null) {
			client = Feign.builder()
					.encoder(new JacksonEncoder())
					.decoder(new JacksonDecoder())
					.target(StockClient.class, "http://localhost:8080");
		}

		return client;
	}

}
