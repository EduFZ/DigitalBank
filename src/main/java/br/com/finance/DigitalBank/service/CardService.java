package br.com.finance.DigitalBank.service;

import br.com.finance.DigitalBank.dto.CardDto;
import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<CardDto> findAllCard() {

        List<Card> card = cardRepository.findAllCard();

        return card.stream().map(CardDto::convertCardToDto)
                .collect(Collectors.toList());

    }

    public CardDto findCardById(Long id) {
        Card card = cardRepository.findCardById(id);

        CardDto cardDto = CardDto.convertCardToDto(card);

        return cardDto;

    }

    public CardDto alterarSenha (Long id, Card card) {
        Card card1 = cardRepository.findCardById(id);
        card1.setPassword(card.getPassword());
        cardRepository.save(card1);

        return CardDto.convertCardToDto(card1);
    }

}
