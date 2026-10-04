package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(
            final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(final FruitTransaction.Operation operation) {
        OperationHandler handler = operationHandlerMap.get(operation);
        if (handler == null) {
            throw new RuntimeException("Unknown operation: " + operation);
        }
        return handler;
    }
}
