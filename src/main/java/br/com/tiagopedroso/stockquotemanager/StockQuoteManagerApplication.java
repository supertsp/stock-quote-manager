package br.com.tiagopedroso.stockquotemanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockQuoteManagerApplication {

	private static String apiName = "Stock Quote Manager";
	
	private static String apiPort = "8081";
	
	private static String apiEnvironment = "DEV";
	
	public static void main(String[] args) {
		SpringApplication.run(StockQuoteManagerApplication.class, args);
				
		System.out.println("\n\n"				
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "\\    Now, Running a    <" + apiName + ">   on [" + apiEnvironment + "]  http://localhost:" + apiPort + " \n"
				+ " \\   " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n"
				+ "  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "\n\n\n"
		);
		
	}	

}


//			System.out.println("\n"
//					+ "\n savedStockQuote: " + savedStockQuote
//					+ "\n transformToDto: " + savedStockQuote.transformToDto()
//					+"\n\n"
//			);