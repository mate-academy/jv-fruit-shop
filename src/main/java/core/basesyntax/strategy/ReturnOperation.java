package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.ShopInventory;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.addFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
