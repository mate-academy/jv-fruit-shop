package service;

import db.Storage;
import java.util.List;
import model.FruitTransaction;
import strategy.CalculateStrategy;

public class CalculateBalanceImpl implements CalculateBalance {
    private final Storage storage;

    public CalculateBalanceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void calculateBalance(List<FruitTransaction> fruitTransactionList) {
        CalculateStrategy calculateStrategy = new CalculateStrategy(storage);
        for (FruitTransaction transaction : fruitTransactionList) {
            calculateStrategy.processTransaction(transaction);
        }
    }
}
