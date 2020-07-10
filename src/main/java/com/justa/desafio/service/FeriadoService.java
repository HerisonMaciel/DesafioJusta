package com.justa.desafio.service;

import com.justa.desafio.model.Feriado;
import com.justa.desafio.model.dto.FeriadoDto;
import com.zaxxer.hikari.util.FastList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class FeriadoService {



    private WebClient webClient;


    public FeriadoService(WebClient.Builder builder){
        this.webClient = builder.exchangeStrategies(ExchangeStrategies.builder()
                .codecs(configurer -> configurer
                        .defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
                .baseUrl("https://date.nager.at")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private Feriado feriado;

    public List<FeriadoDto> feriadosDoPaisAno(String year, String countryCode){

        Mono<FeriadoDto[]> monoFeriado = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/api/v2/publicholidays/%s/%s",year,countryCode))
               .retrieve()
                .bodyToMono(FeriadoDto[].class);

        FeriadoDto[] feriadoDtos =  Objects.requireNonNull(monoFeriado.block());
        List<FeriadoDto> feriadoDtoList = new ArrayList<>();

        for(FeriadoDto feriadoDto1 : feriadoDtos){
            feriadoDtoList.add(feriadoDto1);
        }

        return feriadoDtoList;
    }

    public List<FeriadoDto> proximosFeriadosAno(String countryCode){

        Mono<FeriadoDto[]> monoFeriado = this.webClient
                .method(HttpMethod.GET)
                .uri(String.format("/Api/v2/NextPublicHolidays/%s",countryCode))
                .retrieve()
                .bodyToMono(FeriadoDto[].class);

        FeriadoDto[] feriadoDtos =  Objects.requireNonNull(monoFeriado.block());
        List<FeriadoDto> feriadoDtoList = new ArrayList<>();

        for(FeriadoDto feriadoDto1 : feriadoDtos){
            feriadoDtoList.add(feriadoDto1);
        }

        return feriadoDtoList;
    }

    public FeriadoDto buscarFeriado(String dia, String mes, String ano, String codigo){

        List<FeriadoDto> feriadoDtoList = feriadosDoPaisAno(ano,codigo);
        for (FeriadoDto feriadoDto: feriadoDtoList) {
            if(feriadoDto.getDate().equals(ano + "-"+ mes + "-" + dia)){
                return feriadoDto;
            }
        }

        return null;
    }


}
