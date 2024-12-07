package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void makeOperation(FruitTransaction.Operation operation,
                              FruitTransaction fruitTransaction,
                              Integer quantity) {
        operationHandlers.get(operation).doOperation(fruitTransaction, quantity);
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlers() {
        return operationHandlers;
    }

    public void setOperationHandlers(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }
}
