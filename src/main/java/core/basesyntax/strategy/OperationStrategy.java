package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationStrategy {
    void apply(Transaction transaction);
}
