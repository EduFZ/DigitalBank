package br.com.finance.DigitalBank.repository;

import br.com.finance.DigitalBank.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query("SELECT c.saldo FROM Conta c WHERE c.id_conta = :id_conta")
    BigDecimal findSaldoById(@Param("id_conta")Long id_conta);

    @Query("SELECT c FROM Conta c WHERE c.id_conta = :id_conta")
    Conta findContaById(@Param("id_conta")Long id_conta);




}


