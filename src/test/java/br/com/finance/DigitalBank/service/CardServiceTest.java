package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.dto.CardDto;
import br.com.finance.DigitalBank.dto.CreditCardDto;
import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.entity.CreditCard;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.repository.CardRepository;
import br.com.finance.DigitalBank.repository.ContaRepository;
import br.com.finance.DigitalBank.repository.CreditCardRepository;
import br.com.finance.DigitalBank.util.CardCreator;
import br.com.finance.DigitalBank.validation.PasswordDigitsValidation;
import br.com.finance.DigitalBank.validation.RepeatPasswordValidation;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {

    @InjectMocks
    private CardService cardService;
    @Mock
    private CardRepository cardRepository;
    @Mock
    private CreditCardRepository creditCardRepository;
    @Mock
    private ContaRepository contaRepository;
    @Mock
    private RepeatPasswordValidation repeatPasswordValidation;
    @Mock
    private PasswordDigitsValidation passwordDigitsValidation;

    @Test
    void shoulReturnListOfCardWhithFindAllCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(CardCreator.generateCard());

        BDDMockito.given(cardRepository.findAllCard()).willReturn(cards);

        List<CardDto> allCard = cardService.findAllCard();

        Assertions.assertNotNull(allCard);
        assertEquals(1L, allCard.get(0).getId_card());

    }

    @Test
    void shouldReturnCardWithFindCardById() {
        Card card = CardCreator.generateCard();
        BDDMockito.given(cardRepository.findCardById(BDDMockito.anyLong())).willReturn(card);

        CardDto cardById = cardService.findCardById(1L);

        assertEquals(1L, card.getId_card());
        BDDMockito.then(cardRepository).should().findCardById(1L);

    }

    @Test
    void shoulReturnListOfCreditCardWhithFindAllCreditCard() {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(CardCreator.generateCreditCard());

        BDDMockito.given(creditCardRepository.findAll()).willReturn(creditCards);

        List<CreditCardDto> allCreditCards = cardService.findAllCreditCard();

        Assertions.assertNotNull(allCreditCards);
        assertEquals(2L, allCreditCards.get(0).getId_card());

    }

    @Test
    void shoulReturnCardDtoWithSaveCard() throws ExceptionMessage {
        Card card = CardCreator.generateCard();

        BDDMockito.given(cardRepository.save(card)).willReturn(card);

        CardDto cardDto = cardService.saveCard(card);

        assertEquals(card.getId_card(), cardDto.getId_card());

    }

    @Test
    void shouldThrowExceptionWhenPasswordDigitsIsInvalid() throws ExceptionMessage {
        Card card = CardCreator.generateCard();
        card.setPassword("1234567");

        BDDMockito.given(passwordDigitsValidation.passwordDigitsValidation(ArgumentMatchers.argThat(s -> s.length() <= 7)))
                .willReturn(true);

        ExceptionMessage exceptionMessage = assertThrows(ExceptionMessage.class, () -> cardService.saveCard(card));
        assertEquals("A senha deve conter 8 dígitos ou mais", exceptionMessage.getMessage());

    }



}