package core.basesyntax.utils.transaction.handlers;

import core.basesyntax.storage.impl.StorageImpl;
import core.basesyntax.utils.transaction.FruitTransaction;

public interface OperationHandler {
    void perform(FruitTransaction transaction, StorageImpl storage);
}
