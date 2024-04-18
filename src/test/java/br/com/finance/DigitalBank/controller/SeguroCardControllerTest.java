package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.entity.SeguroCard;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.service.SeguroCardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeguroCardControllerTest {

    @Mock
    private SeguroCardService seguroCardService;

    @InjectMocks
    private SeguroCardController seguroCardController;

    @Test
    public void testContratarSeguroReturnsCreatedStatus() throws ExceptionMessage {

        Long idCard = 1L;
        SeguroCard seguroCard = new SeguroCard();

        when(seguroCardService.contratarSeguro(anyLong(), any(SeguroCard.class))).thenReturn(seguroCard);
        ResponseEntity<SeguroCard> response = seguroCardController.contratarSeguro(idCard, seguroCard);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(seguroCardService).contratarSeguro(idCard, seguroCard);
    }
    }


