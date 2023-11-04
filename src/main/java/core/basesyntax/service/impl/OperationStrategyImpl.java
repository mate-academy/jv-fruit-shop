package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.OperationStrategy;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
