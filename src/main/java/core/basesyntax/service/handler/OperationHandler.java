package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public interface OperationHandler {
    void transaction(FruitTransaction fruitTransaction, Storage storage);
}
