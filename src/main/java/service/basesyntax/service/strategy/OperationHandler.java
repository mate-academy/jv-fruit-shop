package service.basesyntax.service.strategy;

import service.basesyntax.db.Storage;
import service.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void apply(Storage storage, FruitTransaction transaction);
}
