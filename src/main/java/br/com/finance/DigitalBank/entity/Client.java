package br.com.finance.DigitalBank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private Integer cpf;
    private String name;
    private LocalDate dataNasc;
    @ManyToOne
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private ClientCategory clientCategory;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Conta> conta;

}
