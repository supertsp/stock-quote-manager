package br.com.tiagopedroso.stockquotemanager.config;

import br.com.tiagopedroso.stockquotemanager.request.StockClient;
import br.com.tiagopedroso.stockquotemanager.request.StockNotificationClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
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
public class StockNotificationClientConfiguration {

	private StockNotificationClient client;

	public StockNotificationClient getClientInstance() {
		if (client == null) {
			client = Feign.builder()
					.encoder(new JacksonEncoder())
					.decoder(new JacksonDecoder())
					.target(StockNotificationClient.class, "http://localhost:8080");
		}

		return client;
	}

}
