package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public interface TransactionHandler {
    void handle(StorageTransaction transaction);
}
