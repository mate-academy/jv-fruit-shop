package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationStrategy {
    void executeOperation(Transaction transaction);
}
