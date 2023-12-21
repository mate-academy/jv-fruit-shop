package service;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import strategy.CalculateStrategy;

public class CalculateBalanceImpl implements CalculateBalance {
    private static Storage storage;

    public CalculateBalanceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Map<String, Integer> calculateBalance(List<FruitTransaction> fruitTransactionList) {
        Map<String, Integer> fruitQuantities = new HashMap<>();
        CalculateStrategy calculateStrategy = new CalculateStrategy(storage, fruitQuantities);
        for (FruitTransaction transaction : fruitTransactionList) {
            calculateStrategy.setOperation(transaction);
        }
        return fruitQuantities;
    }
}
