package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImp(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
    ) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
