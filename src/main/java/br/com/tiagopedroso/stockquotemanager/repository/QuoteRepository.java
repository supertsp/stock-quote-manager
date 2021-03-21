package br.com.tiagopedroso.stockquotemanager.repository;

import br.com.tiagopedroso.stockquotemanager.model.Quote;
import java.time.LocalDate;
import org.springframework.data.repository.CrudRepository;

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author tiago, 20 de mar de 2021, 19:28:37
 * Last update: -
 */// </editor-fold>
public interface QuoteRepository extends CrudRepository<Quote, LocalDate>{
	
	

}
