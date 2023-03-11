package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public interface Transaction {
    void doTransaction(StorageTransaction transaction);
}
