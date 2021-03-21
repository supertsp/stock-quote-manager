package br.com.tiagopedroso.stockquotemanager.pattern;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 20:34:54
 * Last update: -
 */// </editor-fold>
public interface ObjectDtoHandler<DTO extends Object> {
	
	public <DTO> DTO transformToDto();
	
}
