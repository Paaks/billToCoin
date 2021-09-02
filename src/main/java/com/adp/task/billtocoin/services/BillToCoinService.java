package com.adp.task.billtocoin.services;

import com.adp.task.billtocoin.exception.InvalidBillException;
import com.adp.task.billtocoin.exception.NotEnoughCoinException;
import com.adp.task.billtocoin.model.Bill;
import com.adp.task.billtocoin.model.Coin;
import com.adp.task.billtocoin.repository.BillRepository;
import com.adp.task.billtocoin.repository.BillToCoinRepository;
import com.adp.task.billtocoin.repository.CoinRepository;
import com.adp.task.billtocoin.utils.CoinUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BillToCoinService {

    @Autowired
    private BillToCoinRepository billCoinRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private CoinRepository coinRepository;
    @Value("${error.invalid.bill}")
    private String billErrorMsg;
    @Value("${error.notenough.coin}")
    private String coinErrorMsg;

    private static Map<Double,Integer> coinMinMap = new HashMap<Double,Integer>();
    private static Map<Double,Integer> coinCountMap = new HashMap<Double,Integer>();

    public Map<Double, Integer> getEquivalentCoins(Bill bill) {
        Map<Double,Integer> result = new HashMap<Double,Integer>();
        List<Coin> coins = new ArrayList<Coin>();
       Bill b = billRepository.findByBillValue(bill.getBillValue());
        System.out.println(b);
       if(null == b || null == b.getBillValue() || b.getBillValue().isEmpty())
           throw new InvalidBillException(billErrorMsg);
       else{
           coinCount(b.getBillValue());
           result = CoinUtils.getMinimumCoins(coinMinMap,coinCountMap,b.getBillValue());
           if(result.isEmpty())
               throw new NotEnoughCoinException(coinErrorMsg);
           else{
               //Update table with Data.
           }
          /* coins = Arrays.asList(new Coin(0.1,10),
                   new Coin(0.25,10)).stream().collect(Collectors.toList());*/

       }
       return result;
    }
    private void coinCount(String billValue){

       List<Coin> coins = coinRepository.findAll();
        coins.forEach(coin -> {
            coinMinMap.put(coin.getDenomination(),CoinUtils.getCount(coin.getDenomination(),billValue));
            coinCountMap.put(coin.getDenomination(),coin.getCount());
        });
    }
}
