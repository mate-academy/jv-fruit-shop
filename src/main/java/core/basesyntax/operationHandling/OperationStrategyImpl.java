package core.basesyntax.operationHandling;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationHandling.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlerMap = operationHandlers;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
