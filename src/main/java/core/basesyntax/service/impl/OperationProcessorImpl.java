package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerStrategy;
import core.basesyntax.service.OperationProcessor;
import java.util.List;

public class OperationProcessorImpl implements OperationProcessor {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public OperationProcessorImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(
                fruitTransaction -> operationHandlerStrategy
                        .get(fruitTransaction.getOperation())
                        .applyChanges(fruitTransaction));
    }
}
