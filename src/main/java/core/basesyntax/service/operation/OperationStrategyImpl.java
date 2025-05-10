package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationsHandler;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationsHandler) {
        this.operationsHandler = operationsHandler;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        OperationHandler handler = operationsHandler.get(operation);

        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + operation);
        } else {
            return handler;
        }
    }
}
