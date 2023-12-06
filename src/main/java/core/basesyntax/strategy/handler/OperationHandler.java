package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction transaction, Storage fruitInventory);
}
