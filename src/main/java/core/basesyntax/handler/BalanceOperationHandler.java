package core.basesyntax.handler;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private FruitShopStorage fruitShopStorage;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitShopStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
