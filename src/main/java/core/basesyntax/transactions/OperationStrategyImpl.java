package core.basesyntax.transactions;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        if (operationHandlerMap.get(operation) != null) {
            return operationHandlerMap.get(operation);
        } else {
            throw new RuntimeException("Operation can`t be null");
        }
    }
}
