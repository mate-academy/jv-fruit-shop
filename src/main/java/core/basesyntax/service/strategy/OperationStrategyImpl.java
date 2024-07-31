package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
