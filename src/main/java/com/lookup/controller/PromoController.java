package com.lookup.controller;

import com.lookup.model.Promo;
import com.lookup.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promo")
public class PromoController {

    @Autowired
    LookupService<Promo> promoService;



    @PostMapping
    public ResponseEntity<Promo> createPromo(@RequestBody Promo promo) {
        promoService.create(promo);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Promo> updatePromo(@RequestBody Promo promo, @PathVariable("uuid") String promoUUid) {
        promo.setUuid(promoUUid);
        promoService.update(promo);
        return new ResponseEntity<>(promo, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePromo(@PathVariable("uuid") String promoUUid) {
        promoService.deleteById(promoUUid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Promo>> listPromos() {
        List<Promo> result = promoService.findAll();
        if (result.isEmpty()) return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
