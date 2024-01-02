package com.btb.transactionservice.client;

import com.btb.transactionservice.dto.BuyOrderDTO;
import com.btb.transactionservice.dto.SellOrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class BinanceServiceClient {

    private final String API_KEY = "?";

    private final String SECRET_KEY = "?";

    private final String URL = "https://testnet.binance.vision/api/v3/order";

    public void createOrder(BuyOrderDTO buyOrderDTO) {
        String requestBody = convertObjectToJson(buyOrderDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("API-KEY", API_KEY);
        headers.set("SECRET-KEY", SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(entity, String.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);

        try {
            restTemplate.execute(new URI(URL), HttpMethod.POST, requestCallback, responseExtractor);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void sellOrder(SellOrderDTO sellOrderDTO) {
        String requestBody = convertObjectToJson(sellOrderDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("API-KEY", API_KEY);
        headers.set("SECRET-KEY", SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(entity, String.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);

        try {
            restTemplate.execute(new URI(URL), HttpMethod.POST, requestCallback, responseExtractor);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertObjectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir el objeto a JSON", e);
        }
    }

}
