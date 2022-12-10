package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements
        OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> map) {
        this.operationHandlerMap = map;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
