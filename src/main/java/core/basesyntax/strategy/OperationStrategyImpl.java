package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        if (operationMap == null) {
            throw new RuntimeException("Operation map cannot be null");
        }
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        OperationHandler handler = operationMap.get(operation);

        if (handler == null) {
            throw new RuntimeException("Handler not found the operation " + operation);
        }

        return operationMap.get(operation);
    }
}
