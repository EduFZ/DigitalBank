package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public BigDecimal getSaldo(Long idConta) {
        return contaRepository.findSaldoById(idConta);
    }
}
