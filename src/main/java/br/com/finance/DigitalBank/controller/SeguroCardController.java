package br.com.finance.DigitalBank.controller;

import br.com.finance.DigitalBank.entity.SeguroCard;
import br.com.finance.DigitalBank.exception.ExceptionMessage;
import br.com.finance.DigitalBank.service.SeguroCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("seguroCard")
public class SeguroCardController {
    @Autowired
    private SeguroCardService seguroCardService;

    @GetMapping("/{idCard}")
    public ResponseEntity<SeguroCard> findSeguroById(@PathVariable Long idCard) {
        return ResponseEntity.ok(seguroCardService.findSeguroById(idCard));
    }

    @PostMapping("/contratarSeguro")
    public ResponseEntity<SeguroCard> contratarSeguro(Long idCard, SeguroCard seguroCard) throws ExceptionMessage {
        return new ResponseEntity<>(seguroCardService.contratarSeguro(idCard, seguroCard), HttpStatus.CREATED);
    }

}
