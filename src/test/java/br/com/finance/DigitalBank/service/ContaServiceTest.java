package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.entity.Conta;
import br.com.finance.DigitalBank.repository.ContaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContaServiceTest {
    @InjectMocks
    private ContaService contaService;
    @Mock
    private ContaRepository contaRepository;


    @Test
    void realizarTransferenciaPixEntreContas() {

        Conta conta1 = new Conta();
        conta1.setId_conta(1L);
        conta1.setSaldo(new BigDecimal(100));

        Conta conta2 = new Conta();
        conta2.setId_conta(2L);
        conta2.setSaldo(new BigDecimal(50));

        BDDMockito.given(contaRepository.findContaById(1L)).willReturn(conta1);
        BDDMockito.given(contaRepository.findContaById(2L)).willReturn(conta2);


        BigDecimal saldo1Bef = conta1.getSaldo();

        BigDecimal saldo2Bef = conta2.getSaldo();

        contaService.transferenciaPix(1L, 2L, new BigDecimal(20));

        BigDecimal saldo1Aft = conta1.getSaldo();
        BigDecimal saldo2Aft = conta2.getSaldo();

        Assertions.assertNotEquals(saldo1Bef, saldo1Aft);
        Assertions.assertNotEquals(saldo2Bef, saldo2Aft);


    }


}