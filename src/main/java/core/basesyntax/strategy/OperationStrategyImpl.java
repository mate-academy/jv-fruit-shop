package core.basesyntax.strategy;

import core.basesyntax.exceptions.OperationException;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        OperationHandler operationHandler = operationHandlerMap.get(operation);
        nullCheckInOperationHandler(operationHandler);
        return operationHandler;
    }

    private void nullCheckInOperationHandler(OperationHandler operationHandler) {
        if (operationHandler == null) {
            throw new OperationException("Operation is not found in the map!");
        }
    }
}
