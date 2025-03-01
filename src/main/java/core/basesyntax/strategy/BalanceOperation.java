package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.ShopInventory;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, ShopInventory inventory) {
        inventory.setFruitQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
