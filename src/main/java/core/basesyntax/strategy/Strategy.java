package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;

public interface Strategy {
    Transaction getTransaction(StorageTransaction transaction);
}
