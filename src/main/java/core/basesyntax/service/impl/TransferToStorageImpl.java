package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransferToStorage;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;

public class TransferToStorageImpl implements TransferToStorage {
    private OperationStrategy strategy;

    public TransferToStorageImpl(OperationStrategy operationStrategy) {
        this.strategy = operationStrategy;
    }

    public OperationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void transfer(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = strategy.getHandler(transaction.getOperation());
            operationHandler.handler(transaction);
        }
    }
}
