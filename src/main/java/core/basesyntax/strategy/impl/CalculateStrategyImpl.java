package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class CalculateStrategyImpl implements CalculateStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();

    public CalculateStrategyImpl(Map<FruitTransaction.Operation,
                OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        return operationHandlers.get(transaction.getOperation());
    }
}
