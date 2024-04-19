package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.entity.ApoliceSeguro;
import br.com.finance.DigitalBank.entity.Conta;
import br.com.finance.DigitalBank.entity.CreditCard;
import br.com.finance.DigitalBank.entity.SeguroCard;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SeguroCardService {

    @Autowired
    private SeguroCardRepository seguroCardRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private CardRepository cardRepository;


    public SeguroCard findSeguroById(Long idSeguro) {
        SeguroCard seguroCard = seguroCardRepository.findById(idSeguro).orElseThrow(() -> new RuntimeException("Seguro do Cartão não encontrado"));
        verifyTaxa(seguroCard);
        return seguroCard;
    }

    public SeguroCard contratarSeguro(Long idCard, SeguroCard seguroCard) throws ExceptionMessage {
        CreditCard creditCard = (CreditCard) cardRepository.findCardById(idCard);
        Conta conta = creditCard.getConta();

        verifyTaxa(seguroCard);

        seguroCard.setCredit_card(creditCard);

        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setDataContratacao(seguroCard.getDataContrat());
        apoliceSeguro.setCreditCard(creditCard);
        apoliceSeguro.setNumeroApolice((long) Math.pow(10, 10));

        seguroCard.setApoliceSeguro(apoliceSeguro);

        contaRepository.save(conta);
        apoliceSeguroRepository.save(apoliceSeguro);
        seguroCardRepository.save(seguroCard);


        return seguroCard;
    }

    public void verifyTaxa(SeguroCard seguroCard) {
        LocalDate dataSeguro = seguroCard.getDataContrat();
        Conta conta = seguroCard.getCredit_card().getConta();

        if (seguroCard.getDataContrat().equals(0) || dataSeguro.getMonth() != LocalDate.now().getMonth()
                && dataSeguro.getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
            conta.setSaldo(conta.getSaldo().subtract(seguroCard.getValor()));
            contaRepository.save(conta);
        }

    }


}
