package com.adp.task.billtocoin.services;

import com.adp.task.billtocoin.model.Coin;
import com.adp.task.billtocoin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinMaintenaceService {

    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> findAllCoins() {
       return coinRepository.findAll();
    }

    public Coin addCoin(Coin coin) {
        coinRepository.save(coin);
        return coin;
    }

    public Coin updateCoin(Coin coin) {
        Coin currentCoin = coinRepository.findByDenomination(coin.getDenomination());
        if(null != currentCoin){
            currentCoin.setCount(coin.getCount());
            coinRepository.save(currentCoin);
        }
        return currentCoin;
    }

    public void deleteCoin(String id) {
        coinRepository.delete(coinRepository.getById(Long.valueOf(id)));
    }

    public void initCoins(){

    }
}
