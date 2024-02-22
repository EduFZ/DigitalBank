package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.entity.Card;
import br.com.finance.DigitalBank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private CardService cardService;


    @GetMapping("/all")
    public ResponseEntity<List<Card>> findAllCard(){
        return ResponseEntity.ok(cardService.findAllCard());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.findCardById(id));
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Card> alterarSenha (@PathVariable Long id, @RequestBody Card card) {
        return new ResponseEntity<>(cardService.alterarSenha(id, card), HttpStatus.CREATED);
    }


}