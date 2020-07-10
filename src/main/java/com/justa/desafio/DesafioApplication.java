package com.justa.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.WebServiceClient;
import java.util.Collections;

@SpringBootApplication
public class DesafioApplication {

	/*@Bean
	public WebClient webClient(WebClient.Builder builder){
		return builder.exchangeStrategies(ExchangeStrategies.builder()
				.codecs(configurer -> configurer
						.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
				.baseUrl("https://date.nager.at")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}*/

	//public WebClient webClient = WebClient.create();


	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
