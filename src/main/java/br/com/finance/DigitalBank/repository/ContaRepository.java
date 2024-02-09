package br.com.finance.DigitalBank.repository;

import br.com.finance.DigitalBank.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    @Query("SELECT c.saldo FROM Conta c WHERE c.idConta = :idConta")
    BigDecimal findSaldoById(@Param("idConta")Long idConta);
}
