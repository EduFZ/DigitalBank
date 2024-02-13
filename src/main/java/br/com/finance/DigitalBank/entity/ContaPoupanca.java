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
public class ContaPoupanca extends Conta{
    private BigDecimal rendimento;
    private LocalDate dataRendimento;

    public void taxaRendimento() {
        LocalDate today = LocalDate.now();

        if (dataRendimento == null || today.getMonthValue() != dataRendimento.getMonthValue()) {
            setSaldo(getSaldo().add(rendimento));
            setDataRendimento(dataRendimento);
        }
    }

}
