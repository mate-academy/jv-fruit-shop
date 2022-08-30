package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import java.util.Map;

public class OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> map;

    public OperationStrategy(Map<Transaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    public OperationHandler getByOperation(Transaction.Operation operation) {
        return map.get(operation);
    }
}
