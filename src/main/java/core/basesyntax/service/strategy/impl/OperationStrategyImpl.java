package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(
            Map<Operation, OperationHandler> operationHandlerMapHandlerMap) {
        this.operationHandlerMap = operationHandlerMapHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
