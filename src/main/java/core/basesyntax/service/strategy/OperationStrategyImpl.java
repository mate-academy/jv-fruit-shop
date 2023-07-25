package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy{
    Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
