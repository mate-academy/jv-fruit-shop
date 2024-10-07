package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperationHandler;

public interface OperationStrategy {
    FruitOperationHandler getHandler(FruitTransaction fruitTransaction, Inventory inventory);
}
