package br.com.finance.DigitalBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContaCorrente extends Conta{
    private BigDecimal taxaMensal;
    private LocalDate dateCobranca;


    public void cobrarTaxaMensal() {
        LocalDate today = LocalDate.now();

        if (dateCobranca == null || today.getMonthValue() != dateCobranca.getMonthValue()) {
            setSaldo(getSaldo().subtract(taxaMensal));
            setDateCobranca(today);
        }
    }

}
