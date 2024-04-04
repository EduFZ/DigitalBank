package br.com.finance.DigitalBank.util;

import br.com.finance.DigitalBank.dto.ContaDto;
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

    public static Conta createContaAdd() {
        Conta conta3 = new Conta();
        conta3.setId_conta(3L);
        conta3.setAgencia(5678);
        conta3.setConta(8765);
        conta3.setSaldo(new BigDecimal(50));

        return conta3;
    }



}
