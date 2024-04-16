package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.entity.*;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.repository.*;
import br.com.finance.DigitalBank.util.ApoliceSeguroCreator;
import br.com.finance.DigitalBank.util.CardCreator;
import br.com.finance.DigitalBank.util.SeguroCardCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

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
    @Mock
    private CardRepository cardRepository;


    @Test
    void shouldReturnEqualsDateValuesWhenCallingTheMethodContratarSeguro() throws ExceptionMessage {
        CreditCard card = CardCreator.generateCreditCard();
        SeguroCard seguroCard = SeguroCardCreator.generateSeguroCard();
        ApoliceSeguro apoliceSeguro = ApoliceSeguroCreator.generateApoliceSeguro();
        Conta conta = seguroCard.getCredit_card().getConta();
        BigDecimal saldoConta = conta.getSaldo();


        BDDMockito.given(cardRepository.findCardById(BDDMockito.anyLong())).willReturn(seguroCard.getCredit_card());
        BDDMockito.given(seguroCardService.contratarSeguro(BDDMockito.anyLong(), seguroCard)).willReturn(seguroCard);

        SeguroCard seguroCardNew = seguroCardService.contratarSeguro(1L, seguroCard);

        Card creditCard2 = seguroCardNew.getCredit_card();

        conta.setSaldo(creditCard2.getConta().getSaldo());

        BigDecimal saldoContaNew = conta.getSaldo();

        System.out.println(saldoConta);
        System.out.println(saldoContaNew);

        assertEquals(card.getId_card(), creditCard2.getId_card());
        assertEquals(apoliceSeguro.getCreditCard().getId_card(), seguroCardNew.getCredit_card().getId_card());
        assertNotEquals(saldoConta, saldoContaNew);

    }


}