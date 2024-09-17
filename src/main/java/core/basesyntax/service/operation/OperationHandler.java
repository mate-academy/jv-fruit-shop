package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Storage storage);
}
