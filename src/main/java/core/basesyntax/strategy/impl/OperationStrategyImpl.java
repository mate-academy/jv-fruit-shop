package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(transaction, storage);
        } else {
            throw new IllegalArgumentException("Unknown operation "
                    + transaction.getOperation());
        }

    }
}
