package br.com.tiagopedroso.stockquotemanager.request;

import br.com.tiagopedroso.stockquotemanager.model.dto.StockNotificationDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;
import org.springframework.http.ResponseEntity;

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
public interface StockNotificationClient {

	@RequestLine("POST /notification")
	@Headers("Content-Type: application/json")
	public StockNotificationDto[] register(StockNotificationDto stockNotificationDto);

}
