package core.basesyntax.service.impl;

import core.basesyntax.entity.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.quantity.handlers.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {


    Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler operate(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
