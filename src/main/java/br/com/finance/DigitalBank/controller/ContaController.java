package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.entity.Conta;
import br.com.finance.DigitalBank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/{idConta}/saldo")
    public ResponseEntity<BigDecimal> getSaldo(@PathVariable Long idConta){
        return ResponseEntity.ok(contaService.getSaldo(idConta));
    }

}
