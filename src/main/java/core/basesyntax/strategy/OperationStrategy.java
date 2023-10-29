package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Transaction.Operation operation);

}
