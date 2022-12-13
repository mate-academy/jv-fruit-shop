package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerAllOperation;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, HandlerAllOperation> operationHandlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            HandlerAllOperation> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public HandlerAllOperation get(FruitTransaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
