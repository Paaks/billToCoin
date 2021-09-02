package com.adp.task.billtocoin.config;

import com.adp.task.billtocoin.model.Bill;
import com.adp.task.billtocoin.model.Coin;
import com.adp.task.billtocoin.repository.BillRepository;
import com.adp.task.billtocoin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InitializeBillToCoin implements ApplicationRunner {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CoinRepository coinRepository;

    @Value("${default.bill.values}")
    private String [] defaultBills;

    @Value("${default.coin.values}")
    private String [] defaultCoins;

    @Value("${default.deno.value}")
    private String defaultDeno;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initBills();
        initCoins();
    }

    private void initBills() {
        billRepository.saveAll(Stream.of(defaultBills)
                                .map(bill -> new Bill(bill))
                                .collect(Collectors.toList()));
    }

    private void initCoins() {
        coinRepository.saveAll(Stream.of(defaultCoins)
                                .map(coin -> new Coin(Double.parseDouble(coin),Integer.parseInt(defaultDeno)))
                                .collect(Collectors.toList()));
    }
}
