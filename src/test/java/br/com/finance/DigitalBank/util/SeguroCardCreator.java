package br.com.finance.DigitalBank.util;

import br.com.finance.DigitalBank.entity.SeguroCard;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SeguroCardCreator {

    public static SeguroCard generateSeguroCard() {
        SeguroCard seguroCard = new SeguroCard();
        seguroCard.setId(2L);
        seguroCard.setValor(new BigDecimal("8"));
        seguroCard.setDescricao("Seguro do Cartão");
        seguroCard.setActive(true);
        seguroCard.setCredit_card(CardCreator.generateCreditCard());
        seguroCard.setDataContrat(LocalDate.of(2024, 02, LocalDate.now().getDayOfMonth()));

        return seguroCard;
    }

}
