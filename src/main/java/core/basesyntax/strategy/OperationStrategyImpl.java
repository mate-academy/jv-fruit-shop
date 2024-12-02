package core.basesyntax.strategy;

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
    public OperationHandler getOperationStrategy(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
