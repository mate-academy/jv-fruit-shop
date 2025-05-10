package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
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

    public static FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation value : FruitTransaction.Operation.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(code + " operation doesn't exist.");
    }
}
