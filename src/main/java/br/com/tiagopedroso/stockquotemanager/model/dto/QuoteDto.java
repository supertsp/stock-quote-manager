package br.com.tiagopedroso.stockquotemanager.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 20:04:49
 * Last update: -
 */// </editor-fold>
@Getter
@Setter
@ToString
public class QuoteDto {
	
	private HashMap<LocalDate, String> keyValue;

}
