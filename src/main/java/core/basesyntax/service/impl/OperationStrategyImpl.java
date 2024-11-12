package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String HANDLER_DOESNT_EXIST = "No handler found for operation: ";
    private final Map<FruitTransaction.Operation, OperationStrategy> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationStrategy> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        OperationStrategy handler = operationHandlers.get(fruitTransaction.getOperation());
        if (handler != null) {
            handler.execute(fruitTransaction);
        } else {
            throw new RuntimeException(HANDLER_DOESNT_EXIST + fruitTransaction.getOperation());
        }
    }
}
