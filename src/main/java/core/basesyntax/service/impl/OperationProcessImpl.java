package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final OperationStrategy operationStrategy;

    public OperationProcessImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.processOperation(transaction);
        }
    }
}
