package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.operations.OperationHandler;

public interface Strategy {
    void getStrategy(Transaction transaction);
}
