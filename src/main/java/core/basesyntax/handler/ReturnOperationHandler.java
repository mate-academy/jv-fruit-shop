package core.basesyntax.handler;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private FruitShopStorage fruitShopStorage;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int fruitInStorageQuantity = fruitShopStorage.getQuantity(fruitTransaction.getFruit());
        int balance = fruitInStorageQuantity + fruitTransaction.getQuantity();
        fruitShopStorage.put(fruitTransaction.getFruit(), balance);
    }
}
