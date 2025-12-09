package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;

    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (!operationHandlers.containsKey(operation)) {
            throw new RuntimeException("Unknown operation type: " + operation.getCode());
        }
        return operationHandlers.get(operation);
    }
}
