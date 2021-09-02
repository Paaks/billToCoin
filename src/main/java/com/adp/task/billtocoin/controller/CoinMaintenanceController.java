package com.adp.task.billtocoin.controller;

import com.adp.task.billtocoin.model.Coin;
import com.adp.task.billtocoin.services.CoinMaintenaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class CoinMaintenanceController {
    @Autowired
    private CoinMaintenaceService coinMaintenaceService;

    @GetMapping("/allCoins")
    public List<Coin> getAllCoins(){

        return coinMaintenaceService.findAllCoins();
    }
    @PostMapping("/addCoin")
    public Coin addCoin(@RequestBody Coin coin){

        return coinMaintenaceService.addCoin(coin);
    }
    @PutMapping("/updateCoin")
    public Coin updateCoin(@RequestBody Coin coin){
        return coinMaintenaceService.updateCoin(coin);
    }
    @DeleteMapping ("/coin/{id}")
    public void deleteCoin(@PathVariable final String id){

        coinMaintenaceService.deleteCoin(id);
    }
}
