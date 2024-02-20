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
    private List<Card> cards;
}
