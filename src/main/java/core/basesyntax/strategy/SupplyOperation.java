package core.basesyntax.strategy;

import core.basesyntax.db.ShopInventory;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.addFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
