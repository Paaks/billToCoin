package com.adp.task.billtocoin.utils;

import com.adp.task.billtocoin.model.Coin;

import java.util.*;
import java.util.stream.Collectors;

public class CoinUtils {

    private static Map<Long,String> billMap = new HashMap<Long,String>();
    private static Map<Double,String> coinMap = new HashMap<Double,String>();

    public CoinUtils() {
    }
    // Map of Coins

    // Map of Bills
    public static Map<Long, String> getBillMap(){
        return billMap;
    }

    public static Map<Long, String> getCoinMap(){
        return billMap;
    }

    public static Map<Double, Integer> getMinimumCoins(Map<Double, Integer> coinMinMap, Map<Double, Integer> coinCountMap, String billValue) {

        List<Coin> coins = new ArrayList<Coin>();
        Map<Double,Integer> result = new HashMap<Double,Integer>();
        int billValueInt = Integer.valueOf(billValue);
        Map<Double, Integer> sortedCoinMinMap = coinMinMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<Double,Integer> sorted :sortedCoinMinMap.entrySet()) {
            if(coinCountMap.get(sorted.getKey()) > sorted.getValue()){
                result.put(sorted.getKey(),sorted.getValue());
                break;
            }
            else{
                /*result.put(sorted.getKey(),sorted.getValue());
                billValueInt = */
            }
        }
        return result;
    }

    public static Integer getCount(double denomination, String billValue) {
        int bValue = Integer.valueOf(billValue);
        double number = bValue/denomination;
        return (int) number;
    }
}
