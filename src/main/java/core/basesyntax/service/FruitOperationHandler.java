package core.basesyntax.service;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;

public interface FruitOperationHandler {
    void getFruitOperation(FruitTransaction transaction, Inventory inventory);
}
