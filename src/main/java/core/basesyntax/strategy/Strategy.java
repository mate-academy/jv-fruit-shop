package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operation.Operation;

public interface Strategy {
    Operation getByOperation(Transaction.Operation operation);
}
