package br.com.tiagopedroso.stockquotemanager.model.dto;

import br.com.tiagopedroso.stockquotemanager.pattern.DtoObjectHandler;
import br.com.tiagopedroso.stockquotemanager.model.Quote;
import br.com.tiagopedroso.stockquotemanager.model.StockQuote;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
 * @author tiago, 20 de mar de 2021, 20:03:30 Last update: -
 */// </editor-fold>
@Getter
@Setter
@ToString
public class StockDto {

	private String id;
	private String description;	

}
