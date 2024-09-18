package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public interface OperationHandler {
    void handle(FruitTransaction transaction, StorageService storageService);
}
