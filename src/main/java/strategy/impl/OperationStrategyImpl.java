package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation actionType) {
        return operations.get(actionType);
    }
}
