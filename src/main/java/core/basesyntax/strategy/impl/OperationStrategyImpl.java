package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        if (operationHandlers == null) {
            throw new RuntimeException("Operation handlers map cannot be null");
        }
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler =
                operationHandlers.get(fruitTransaction.getOperation());
        if (operationHandler == null) {
            throw new RuntimeException("No handler found for operation "
                    + fruitTransaction.getOperation());
        }
        operationHandler.handleTransaction(fruitTransaction);
    }
}
