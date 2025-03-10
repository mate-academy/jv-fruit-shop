package core.basesyntax.strategy;

import core.basesyntax.db.ShopInventory;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction, ShopInventory inventory);
}
