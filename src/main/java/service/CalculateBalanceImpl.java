package service;

import dao.Storage;
import java.util.List;
import model.FruitTransaction;
import strategy.CalculateStrategy;

public class CalculateBalanceImpl implements CalculateBalance {
    private final Storage storage;
    private final CalculateStrategy calculationStrategy;

    public CalculateBalanceImpl(Storage storage, CalculateStrategy calculationStrategy) {
        this.storage = storage;
        this.calculationStrategy = calculationStrategy;
    }

    @Override
    public void calculateBalance(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            this.calculationStrategy.processTransaction(transaction);
        }
    }
}
