package br.com.tiagopedroso.stockquotemanager.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 20:03:30 Last update: -
 */// </editor-fold>
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockNotificationDto {

	private String host;
	private String port;
	
	public StockNotificationDto(String host, String port){
		this.host = host;
		this.port = port;
	}

}
