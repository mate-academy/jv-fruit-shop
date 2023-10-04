package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;

public interface OperationStrategy {
    void performOperation(Transaction transaction);
}
