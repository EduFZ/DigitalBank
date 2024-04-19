package br.com.finance.DigitalBank.util;

import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.entity.CreditCard;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardCreator {

    public static Card generateCard() {
        Card card = new Card();
        card.setId_card(1L);
        card.setPassword("abc123");
        card.setTax(new BigDecimal("10"));
        card.setActive(true);
        card.setConta(ContaCreator.createConta());

        return card;
    }

    public static CreditCard generateCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId_card(2L);
        creditCard.setPassword("abc123");
        creditCard.setTax(new BigDecimal("10"));
        creditCard.setActive(true);
        creditCard.setConta(ContaCreator.createConta());
        creditCard.setCreditLimit(new BigDecimal("1000"));
        creditCard.setFatura(new BigDecimal("120.45"));
        creditCard.setVencMes(LocalDate.of(2024, 03, 10));

        return creditCard;
    }

}
