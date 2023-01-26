package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler get(Transaction.Operation operation) {
        return map.get(operation);
    }
}
