package core.basesyntax.strategy;

import core.basesyntax.db.ShopInventory;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.deductFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
