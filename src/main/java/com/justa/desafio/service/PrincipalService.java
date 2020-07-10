/*package com.justa.desafio.service;

import com.justa.desafio.model.Data;
import com.justa.desafio.model.dto.DataDto;
import com.justa.desafio.model.dto.FeriadoDto;
import com.justa.desafio.model.dto.PrincipalDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PrincipalService {

    private WebClient webClient;


    public PrincipalService(WebClient.Builder builder){
        this.webClient = builder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
                .baseUrl("http://localhost:8080/feriados")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    }

    public PrincipalDto buscarFeriadosDoAno(String dia, String mes, String ano, String codigo ) throws IOException {

        Mono<PrincipalDto> monoPricipalDto = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/principal/%s/%s/%s/%s",dia,mes,ano,codigo))
                .retrieve()
                .bodyToMono(PrincipalDto.class);


        return null;
    }

    public PrincipalDto teste(){

        Mono<FeriadoDto[]> monoFeriadoDto = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/br"))
                .retrieve()
                .bodyToMono(FeriadoDto[].class);

        FeriadoDto[] feriadoDtos =  Objects.requireNonNull(monoFeriadoDto.block());

        PrincipalDto principalDto = new PrincipalDto();
        principalDto.setFeriadoDto(feriadoDtos[1]);
        //principalDto.setDataDto(dataDto);

        return principalDto;
    }

}
*/