package com.lookup.controller;

import com.lookup.dao.PromoRepository;
import com.lookup.model.Promo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promo")
public class PromoController {
    @Autowired
    PromoRepository promoRepository;


    @PostMapping
    public ResponseEntity<Promo> createPromo(@RequestBody Promo promo) {
        promoRepository.save(promo);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Promo> updatePromo(@RequestBody Promo promo, @PathVariable("uuid") String promoUUid) {
        promo.setUuid(promoUUid);
        promoRepository.save(promo);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePromo(@PathVariable("uuid") String promoUUid) {
        promoRepository.deleteById(promoUUid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Promo>> listPromos() {
        List<Promo> result = promoRepository.findAll();
        if (result.isEmpty()) return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
