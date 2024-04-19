package br.com.finance.DigitalBank.util;

import br.com.finance.DigitalBank.entity.ApoliceSeguro;

public class ApoliceSeguroCreator {

    public static ApoliceSeguro generateApoliceSeguro() {

        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setIdApolice(2L);
        apoliceSeguro.setDataContratacao(SeguroCardCreator.generateSeguroCard().getDataContrat());
        apoliceSeguro.setNumeroApolice(12345L);
        apoliceSeguro.setCreditCard(CardCreator.generateCreditCard());
        apoliceSeguro.setSeguroCard(SeguroCardCreator.generateSeguroCard());

        return apoliceSeguro;
    }

}
