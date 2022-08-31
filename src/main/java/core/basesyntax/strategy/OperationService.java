package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationService {
    void interact(Transaction transaction);
}
