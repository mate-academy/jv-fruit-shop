package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        if (operationHandlerMap == null || operationHandlerMap.isEmpty()) {
            throw new RuntimeException("Please provide valid operationHandlerMap");
        }
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (!isOperationPresent(operation)) {
            throw new RuntimeException("Please add this new operation to the operations Map - "
                    + operation);
        }
        return operationHandlerMap.get(operation);
    }

    private boolean isOperationPresent(FruitTransaction.Operation operation) {
        return operationHandlerMap.containsKey(operation);
    }
}
