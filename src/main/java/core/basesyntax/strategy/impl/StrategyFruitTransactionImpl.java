package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StrategyFruitTransaction;
import core.basesyntax.transaction.OperationHandler;
import java.util.Map;

public class StrategyFruitTransactionImpl implements StrategyFruitTransaction {
    private final Map<Operation, OperationHandler> operations;

    public StrategyFruitTransactionImpl(Map<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler execute(Operation operation) {
        return operations.get(operation);
    }
}
