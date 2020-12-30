package core.basesyntax.operations;

import core.basesyntax.Transaction;

public interface StoreOperation {
    void performOperation(Transaction transaction);
}
