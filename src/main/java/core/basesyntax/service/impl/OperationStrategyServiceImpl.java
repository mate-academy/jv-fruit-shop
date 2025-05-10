package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationServiceStrategy;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyServiceImpl implements OperationServiceStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
