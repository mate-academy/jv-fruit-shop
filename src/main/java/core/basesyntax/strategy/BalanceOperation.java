package core.basesyntax.strategy;

import core.basesyntax.db.ShopInventory;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.setFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
