package service.impl;

import java.util.Map;

public class FruitBalanceCheckService {

    public Map<String, Integer> checkNegativeBalance(Map<String, Integer> fruitTransactions) {
        for (Map.Entry<String, Integer> entry : fruitTransactions.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("The balance of "
                        + entry.getKey()
                        + " is negative: "
                        + entry.getValue());
            }
        }
        return fruitTransactions;
    }
}
