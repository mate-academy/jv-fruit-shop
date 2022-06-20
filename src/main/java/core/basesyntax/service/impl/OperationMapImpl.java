package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationMap;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationMapImpl implements OperationMap {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandler;

    public OperationMapImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
