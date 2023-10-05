package handlers;

import core.basesyntax.FruitInventory;
import core.basesyntax.FruitTransaction;

public interface TransactionHandler {
    void handleTransaction(FruitInventory inventory, FruitTransaction transaction);
}
