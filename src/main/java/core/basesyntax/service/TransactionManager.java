package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionManager {
    private final OperationStrategy operationStrategy;

    public TransactionManager(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransaction> transactionsList) {
        for (var transaction : transactionsList) {
            operationStrategy.getHandlers(transaction).forEach(oh -> oh.apply(transaction));
        }
    }
}
