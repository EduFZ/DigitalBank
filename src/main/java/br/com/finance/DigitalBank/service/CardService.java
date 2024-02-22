package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAllCard() {
        return cardRepository.findAllCard();
    }

    public Card findCardById(Long id) {
        return cardRepository.findCardById(id);
    }

    public Card alterarSenha (Long id, Card card) {
        Card newSenha = cardRepository.findCardById(id);
        newSenha.setPassword((card.getPassword()));
        return newSenha;
    }

}
