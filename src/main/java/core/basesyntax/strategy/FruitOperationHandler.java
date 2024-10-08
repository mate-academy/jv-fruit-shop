package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Inventory;

public interface FruitOperationHandler {
    void executeOperation(FruitTransaction transaction, Inventory inventory);
}
