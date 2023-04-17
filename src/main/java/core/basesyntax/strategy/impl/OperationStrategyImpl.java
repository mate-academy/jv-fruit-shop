package core.basesyntax.strategy.impl;

import java.util.Map;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> transactionHandlerMap) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
