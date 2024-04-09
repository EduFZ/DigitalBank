package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.api.TaxaRendApi;
import br.com.finance.DigitalBank.entity.Conta;
import br.com.finance.DigitalBank.entity.ContaCorrente;
import br.com.finance.DigitalBank.entity.ContaPoupanca;
import br.com.finance.DigitalBank.service.ContaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Indica ao Spring para não usar o próprio ContaService, mas sim simulá-lo
    private ContaService contaService;

    @Autowired
    private JacksonTester<ContaCorrente> jsonContaCorrente; // Classe que gera o JSON

    @Autowired
    private JacksonTester<ContaPoupanca> jsonContaPoupanca;

    @Test
    void shouldReturn201WithSaveContaCorrente() throws Exception {

        ContaCorrente contaCorrente = new ContaCorrente(new BigDecimal(12), LocalDate.of(2024, 07, 15));

        MockHttpServletResponse response = mockMvc.perform(
                post("/conta/saveContaCorrente")
                        .content(jsonContaCorrente.write(contaCorrente).getJson())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(201, response.getStatus());

    }

    @Test
    void shouldReturn201WithSaveContaPoupanca() throws Exception {

        ContaPoupanca contaPoupanca = new ContaPoupanca(TaxaRendApi.getTaxaCdi(), LocalDate.of(2024, 06, 10));

        MockHttpServletResponse response = mockMvc.perform(
                post("/conta/saveContaPoupanca")
                        .content(jsonContaPoupanca.write(contaPoupanca).getJson())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(201, response.getStatus());

    }

}