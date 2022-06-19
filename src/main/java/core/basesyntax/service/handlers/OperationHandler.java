package core.basesyntax.service.handlers;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void processOperation(Transaction.Operation operation, Fruit fruit, Integer quantity);
}
