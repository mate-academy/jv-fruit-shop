package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlersMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
