package service;

import java.util.Map;

public interface FruitBalanceCheckService {
    Map<String, Integer> checkNegativeBalance(Map<String, Integer> fruitTransactions);
}
