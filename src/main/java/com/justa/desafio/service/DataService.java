package com.justa.desafio.service;

import com.justa.desafio.model.dto.DataDto;
import com.justa.desafio.model.dto.FeriadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DataService {


    private WebClient webClient;


    public DataService(WebClient.Builder builder){
        this.webClient = builder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
                .baseUrl("http://numbersapi.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public DataDto dataFatoHistorico(String mes, String dia){

      Mono<String> monoNumero = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/%s/%s/date",mes,dia))
                .retrieve()
                .bodyToMono(String.class);

        DataDto dataDto = new DataDto();
        dataDto.setTextoHistorico(monoNumero.block());

        return dataDto;

    }

    public DataDto numeroCurisidade(String numero){
        Mono<String> monoNumero = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/%s",numero))
                .retrieve()
                .bodyToMono(String.class);

        DataDto dataDto = new DataDto();
        dataDto.setTextoHistorico(monoNumero.block());

        return dataDto;
    }

    public DataDto numeroMatematico(String numero){
        Mono<String> monoNumero = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/%s",numero))
                .retrieve()
                .bodyToMono(String.class);

        DataDto dataDto = new DataDto();
        dataDto.setTextoHistorico(monoNumero.block());

        return dataDto;
    }

    public DataDto[] numeroCurisidadeNumero(String numero){

        DataDto[] dataDto = new DataDto[2];
        dataDto[0] = numeroCurisidade(numero);
        dataDto[1] = numeroMatematico(numero);
        return dataDto;
    }


}
