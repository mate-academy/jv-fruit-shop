package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.StrategyFruitTransaction;
import core.basesyntax.transaction.HandlerOperation;
import java.util.Map;

public class StrategyFruitTransactionImpl implements StrategyFruitTransaction {
    private final Map<Operation, HandlerOperation> operations;

    public StrategyFruitTransactionImpl(Map<Operation, HandlerOperation> operations) {
        this.operations = operations;
    }

    @Override
    public HandlerOperation execute(Operation operation) {
        return operations.get(operation);
    }
}

