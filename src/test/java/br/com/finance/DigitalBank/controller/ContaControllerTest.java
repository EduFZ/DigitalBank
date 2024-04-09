package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.service.ContaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ContaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Indica ao Spring para não usar o próprio ContaService, mas sim simulá-lo
    private ContaService contaService;

    @Test
    void shouldReturn201WithSaveContaCorrente() throws Exception {

        String json = "{}";

        var response = mockMvc.perform(
                post("/conta/saveContaCorrente")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(201, response.getStatus());

    }

    @Test
    void shouldReturn201WithSaveContaPoupanca() throws Exception {

        String json = "{}";

        var response = mockMvc.perform(
                post("/conta/saveContaPoupanca")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        Assertions.assertEquals(201, response.getStatus());

    }

}