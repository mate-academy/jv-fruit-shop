package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,OperationHandler>
                                         operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
