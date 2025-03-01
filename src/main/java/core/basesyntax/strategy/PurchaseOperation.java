package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.ShopInventory;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.deductFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
