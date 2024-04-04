package br.com.finance.DigitalBank.util;

import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.entity.Client;
import br.com.finance.DigitalBank.entity.Conta;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaCreator {

    public static Conta createConta() {
        Conta contas = new Conta();
        contas.setId_conta(1L);
        contas.setAgencia(1234);
        contas.setConta(4321);
        contas.setSaldo(new BigDecimal(100));

        return contas;
    }

}
