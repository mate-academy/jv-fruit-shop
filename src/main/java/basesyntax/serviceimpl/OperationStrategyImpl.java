package basesyntax.serviceimpl;

import basesyntax.common.FruitTransaction;
import basesyntax.service.OperationStrategy;
import basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        OperationHandler handler = operationHandlers.get(operation);
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for operation: "
                    + operation);
        }
        return handler;
    }
}
