package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public interface Strategy {
    TransactionHandler getHandler(StorageTransaction transaction);
}
