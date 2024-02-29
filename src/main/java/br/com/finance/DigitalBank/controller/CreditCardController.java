package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.dto.CreditCardDto;
import br.com.finance.DigitalBank.entity.CreditCard;
import br.com.finance.DigitalBank.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("creditCard")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/findAllCreditCard")
    public ResponseEntity<List<CreditCardDto>> findAllCreditCard() {
        return ResponseEntity.ok(creditCardService.findAllCreditCard());
    }

    @PostMapping("/saveCreditCard")
    public ResponseEntity<CreditCard> saveCreditCard(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<>(creditCardService.saveCreditCard(creditCard), HttpStatus.CREATED);
    }

}
