package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.ShopInventory;

public interface OperationHandler {
    void handle(FruitTransaction transaction, ShopInventory inventory);
}
