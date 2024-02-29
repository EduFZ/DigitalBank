package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.dto.CreditCardDto;
import br.com.finance.DigitalBank.entity.CreditCard;
import br.com.finance.DigitalBank.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;


    public List<CreditCardDto> findAllCreditCard(){
        List<CreditCard> creditCard = creditCardRepository.findAll();

        return creditCard.stream().map(CreditCardDto::convertCardToDto).collect(Collectors.toList());
    }

    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }


}
