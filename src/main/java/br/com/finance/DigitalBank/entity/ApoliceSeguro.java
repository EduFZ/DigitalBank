package br.com.finance.DigitalBank.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApoliceSeguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApolice;
    private LocalDate dataContratacao;
    private CreditCard creditCard;
    private SeguroCard seguroCard;
}
