package core.basesyntex.service;

import core.basesyntex.model.FruitTransaction;
import core.basesyntex.service.impl.Storage;

public interface OperationHandler {
    void handle(FruitTransaction transaction, Storage storage);
}
