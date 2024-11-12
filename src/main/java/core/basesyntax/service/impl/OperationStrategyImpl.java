package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationStrategy> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationStrategy> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction) {
        OperationStrategy handler = operationHandlers.get(fruitTransaction.getOperation());
        handler.execute(fruitTransaction);
    }
}
