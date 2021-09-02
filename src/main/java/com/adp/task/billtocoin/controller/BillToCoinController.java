package com.adp.task.billtocoin.controller;

import com.adp.task.billtocoin.model.Bill;
import com.adp.task.billtocoin.services.BillToCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/request")
public class BillToCoinController {

    @Autowired
    private BillToCoinService billToCoinService;

    @PostMapping("/coins")
    public ResponseEntity<Object> getCoinsEquivalent(@RequestBody Bill bill){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("BillRequested", bill.getBillValue());
        body.put("Coins", billToCoinService.getEquivalentCoins(bill));
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
