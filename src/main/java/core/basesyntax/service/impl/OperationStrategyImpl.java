package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler != null) {
            handler.apply(transaction);
        } else {
            throw new RuntimeException("Operation handler not found for operation: "
                    + transaction.getOperation());
        }
    }
}
