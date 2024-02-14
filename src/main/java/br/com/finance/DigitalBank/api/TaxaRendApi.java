package br.com.finance.DigitalBank.api;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TaxaRendApi {

    private static final String API_URL = "https://brasilapi.com.br/api/taxas/v1/cdi";

    public BigDecimal getTaxaCdi() {
        RestTemplate restTemplate = new RestTemplate();
        BigDecimal valor = restTemplate.getForObject(API_URL, BigDecimal.class);
        return valor;
    }

}
