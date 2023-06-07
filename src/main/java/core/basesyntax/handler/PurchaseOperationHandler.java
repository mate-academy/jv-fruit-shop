package core.basesyntax.handler;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitShopStorage fruitShopStorage;

    @Override
    public void transferToStorage(FruitTransaction fruitTransaction) {
        int fruitInStorageQuantity = fruitShopStorage.getQuantity(fruitTransaction.getFruit());
        int balance = fruitInStorageQuantity - fruitTransaction.getQuantity();
        if (balance >= 0) {
            fruitShopStorage.put(fruitTransaction.getFruit(), balance);
        } else {
            throw new RuntimeException("Not enough fruits in storage: you have "
                    + fruitInStorageQuantity
                    + " but trying purchase "
                    + fruitTransaction.getQuantity());
        }
    }
}
