package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private Map<Transaction.Operation, OperationHandler> map;

    public OperationStrategy(Map<Transaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    public OperationHandler getByOperation(Transaction.Operation operation) {
        return map.get(operation);
    }
}
