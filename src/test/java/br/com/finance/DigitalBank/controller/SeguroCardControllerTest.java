package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.service.SeguroCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class SeguroCardControllerTest {

    @MockBean
    private SeguroCardService seguroCardService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testContratarSeguroReturnsCreatedStatus() throws Exception {

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/seguroCard/{id}", 1L))
                .andReturn().getResponse();

        assertEquals(200, response.getStatus());

    }

}


