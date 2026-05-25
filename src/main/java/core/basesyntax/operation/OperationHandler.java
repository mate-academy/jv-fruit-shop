package core.basesyntax.operation;

import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;

public interface OperationHandler {
    void operate(FruitTransaction transaction, Storage storage);
}
