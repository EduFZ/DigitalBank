package br.com.finance.DigitalBank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private Integer cpf;
    private String name;
    private LocalDate dataNasc;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private ClientCategory clientCategory;
    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

}
