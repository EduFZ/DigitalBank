package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.dto.CardDto;
import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.entity.CreditCard;
import br.com.finance.DigitalBank.entity.DebitCard;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private CardService cardService;


    @GetMapping("/all")
    public ResponseEntity<List<CardDto>> findAllCard(){
        return ResponseEntity.ok(cardService.findAllCard());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> findCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.findCardById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<CardDto> save(@RequestBody Card card) throws ExceptionMessage {
        return new ResponseEntity<>(cardService.saveCard(card), HttpStatus.CREATED);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<CardDto> alterarSenha (@PathVariable Long id, @RequestBody Card card) throws ExceptionMessage {
        return new ResponseEntity<>(cardService.alterarSenha(id, card), HttpStatus.CREATED);
    }

    @PutMapping("/desativarCard")
    public ResponseEntity<CardDto> desativarCard(@PathVariable Long id) throws ExceptionMessage {
        return new ResponseEntity<>(cardService.desativarCard(id), HttpStatus.CREATED);
    }

    @PutMapping("/ativarCard")
    public ResponseEntity<CardDto> ativarCard(@PathVariable Long id) throws ExceptionMessage {
        return new ResponseEntity<>(cardService.ativarCard(id), HttpStatus.CREATED);
    }

    @PutMapping("/payCreditCard/{id}")
    public ResponseEntity<CreditCard> payCreditCard(@PathVariable Long id, @RequestParam BigDecimal value) throws ExceptionMessage {
        return ResponseEntity.ok(cardService.payCreditCard(id, value));
    }

    @PutMapping("/payDebitCard/{id}")
    public ResponseEntity<DebitCard> payDebitCard(@PathVariable Long id, @RequestParam BigDecimal value) throws ExceptionMessage {
        return ResponseEntity.ok(cardService.payDebitCard(id, value));
    }


}
