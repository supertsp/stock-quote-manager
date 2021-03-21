package br.com.tiagopedroso.stockquotemanager.cache;

import br.com.tiagopedroso.stockquotemanager.config.StockClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.config.StockNotificationClientConfiguration;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockDto;
import br.com.tiagopedroso.stockquotemanager.model.dto.StockNotificationDto;
import br.com.tiagopedroso.stockquotemanager.request.StockClient;
import br.com.tiagopedroso.stockquotemanager.request.StockNotificationClient;
import java.util.List;
import java.util.ArrayList;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 21 de mar de 2021, 12:44:34
 * Last update: -
 */// </editor-fold>
public class StockCache {
	
	private static final List<StockDto> list = new ArrayList<>();
	private static boolean isActive = false;
	private static boolean isRegistered = false;
	
	
	private static StockNotificationClientConfiguration stockNotificationClientConfiguration;	
	private static StockClientConfiguration stockClientConfiguration;	
	
	public static boolean isEmpty() {
		return list.isEmpty();
	}
	
	public static void clearAndReboot() {
		if (isActive) {
			list.clear();

			StockClient stockClient = stockClientConfiguration.getClientInstance();		
			list.addAll(stockClient.list());
		}
	}
	
	public static boolean containsById(String idStock) {
		if (isActive) {			
			for (StockDto item : list) {
				if (item.getId().equals(idStock)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static List<StockDto> getCache() {
		return list;
	}
	
	public static boolean isActive() {
		return isActive;
	}
	
	public static void activate() {
		isActive = true;
	}
	
	public static void deactivate() {
		isActive = false;
	}
	
	public static boolean isRegistered(){
		return isRegistered;
	}
	
	public static void registerNotification(
			StockNotificationClientConfiguration notificationClientConfig, 
			StockClientConfiguration stockClientConfig) {
		
		if (isActive && !isRegistered) {
			stockNotificationClientConfiguration = notificationClientConfig;
			stockClientConfiguration = stockClientConfig;

			StockNotificationClient stockNotificationClient = stockNotificationClientConfiguration.getClientInstance();		
			StockNotificationDto[] stockNotificationDtoArray = stockNotificationClient.register(new StockNotificationDto("127.0.0.1", "8081"));

			if (stockNotificationDtoArray != null && stockNotificationDtoArray.length > 0) {
				if (isEmpty()) {
					isRegistered = true;
				}
			}			
		}
	}

}
