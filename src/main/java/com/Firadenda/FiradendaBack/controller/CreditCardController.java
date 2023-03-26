package com.Firadenda.FiradendaBack.controller;

import com.Firadenda.FiradendaBack.entity.CreditCard;
import com.Firadenda.FiradendaBack.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/creditcard")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @GetMapping("")
    public Iterable<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        if (optionalCreditCard.isPresent()) {
            CreditCard creditCard = optionalCreditCard.get();
            return ResponseEntity.ok().body(creditCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCard creditCard) {
        try {
            CreditCard savedCreditCard = creditCardRepository.save(creditCard);
            return new ResponseEntity<>(savedCreditCard, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating credit card: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        if (optionalCreditCard.isPresent()) {
            CreditCard existingCreditCard = optionalCreditCard.get();
            existingCreditCard.setNumber(creditCard.getNumber());
            existingCreditCard.setDate_dexpiration(creditCard.getDate_dexpiration());
            existingCreditCard.setOwner(creditCard.getOwner());
            existingCreditCard.setCvc(creditCard.getCvc());
            creditCardRepository.save(existingCreditCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCreditCard(@PathVariable Long id) {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        if (optionalCreditCard.isPresent()) {
            CreditCard creditCard = optionalCreditCard.get();
            creditCardRepository.delete(creditCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
