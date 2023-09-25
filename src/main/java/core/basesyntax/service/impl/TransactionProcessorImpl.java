package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.CalculateStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private CalculateStrategy calculateStrategy = null;

    public TransactionProcessorImpl(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    @Override
    public void calculateBalance(List<FruitTransaction> fruitTransactionList) {

        for (int i = 0; i < fruitTransactionList.size(); i++) {
            FruitTransaction fruitTransaction = fruitTransactionList.get(i);
            calculateStrategy.calculate(fruitTransaction, fruitTransaction.getOperation());
        }
    }
}
