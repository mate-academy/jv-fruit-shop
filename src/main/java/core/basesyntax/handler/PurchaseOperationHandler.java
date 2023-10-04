package core.basesyntax.handler;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitShopStorage fruitShopStorage;

    public PurchaseOperationHandler(FruitShopStorage fruitShopStorage) {
        this.fruitShopStorage = fruitShopStorage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int fruitInStorageQuantity = fruitShopStorage.getQuantity(fruitTransaction.getFruit());
        int balance = fruitInStorageQuantity - fruitTransaction.getQuantity();
        if (balance < 0) {
            throw new RuntimeException("Not enough fruits in storage: you have "
                    + fruitInStorageQuantity
                    + " but trying purchase "
                    + fruitTransaction.getQuantity());
        }
        fruitShopStorage.put(fruitTransaction.getFruit(), balance);
    }
}
