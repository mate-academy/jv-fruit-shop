package core.basesyntax.servise.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.FruitStockUpdater;
import core.basesyntax.strategy.TransactionHandlerStrategy;
import java.util.List;

public class FruitStockUpdaterImp implements FruitStockUpdater {
    private final TransactionHandlerStrategy operationStrategy;

    public FruitStockUpdaterImp(TransactionHandlerStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> list) {
        for (FruitTransaction fruitTransaction : list) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .applyTransaction(fruitTransaction);
        }
    }
}
