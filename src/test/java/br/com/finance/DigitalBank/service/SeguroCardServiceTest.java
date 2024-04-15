package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.entity.*;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.repository.ApoliceSeguroRepository;
import br.com.finance.DigitalBank.repository.ContaRepository;
import br.com.finance.DigitalBank.repository.CreditCardRepository;
import br.com.finance.DigitalBank.repository.SeguroCardRepository;
import br.com.finance.DigitalBank.util.ApoliceSeguroCreator;
import br.com.finance.DigitalBank.util.CardCreator;
import br.com.finance.DigitalBank.util.ContaCreator;
import br.com.finance.DigitalBank.util.SeguroCardCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SeguroCardServiceTest {

    @InjectMocks
    private SeguroCardService seguroCardService;
    @Mock
    private SeguroCardRepository seguroCardRepository;
    @Mock
    private ApoliceSeguroRepository apoliceSeguroRepository;
    @Mock
    private ContaRepository contaRepository;
    @Mock
    private CreditCardRepository creditCardRepository;


    @Test
    void shouldReturnEqualsDateValuesWhenCallingTheMethodContratarSeguro() throws ExceptionMessage {
        Card card = CardCreator.generateCreditCard();
        SeguroCard seguroCard = SeguroCardCreator.generateSeguroCard();
        ApoliceSeguro apoliceSeguro = ApoliceSeguroCreator.generateApoliceSeguro();

        BDDMockito.given(creditCardRepository.findById(BDDMockito.anyLong())).willReturn(Optional.of(CardCreator.generateCreditCard()));
        BDDMockito.given(seguroCardService.contratarSeguro(BDDMockito.anyLong(), seguroCard)).willReturn(seguroCard);

        SeguroCard seguroCardNew = seguroCardService.contratarSeguro(1L, seguroCard);
        Card creditCard2 = seguroCardNew.getCredit_card();

        assertEquals(card.getId_card(), creditCard2.getId_card());
        assertEquals(apoliceSeguro.getCreditCard().getId_card(), seguroCardNew.getCredit_card().getId_card());


    }


}