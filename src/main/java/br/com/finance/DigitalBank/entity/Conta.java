package br.com.finance.DigitalBank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    private Integer agencia;
    private Integer conta;
    private BigDecimal saldo;
    @OneToMany(mappedBy ="conta", cascade = CascadeType.ALL)
    //@JsonManagedReference // Ignora a serialização da conta ao serializar um cartão evitando recursão infinita
    private List<Card> cards;


    public CreditCard generateCreditCard(String password, BigDecimal tax, Boolean active, BigDecimal creditLimit, BigDecimal fatura){
        CreditCard creditCard = new CreditCard();

        creditCard.setPassword(password);
        creditCard.setTax(tax);
        creditCard.setActive(active);
        creditCard.setConta(this);
        creditCard.setCreditLimit(creditLimit);
        creditCard.setFatura(fatura);

        return creditCard;
    }

    public DebitCard generateDebitCard(String password, BigDecimal tax, Boolean active, BigDecimal dailyLimit){
        DebitCard debitCard = new DebitCard();

        debitCard.setPassword(password);
        debitCard.setTax(tax);
        debitCard.setActive(active);
        debitCard.setConta(this);
        debitCard.setDailyLimit(dailyLimit);

        return debitCard;
    }


}
