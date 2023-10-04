package core.basesyntax.handler;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private FruitShopStorage fruitShopStorage;

    public SupplyOperationHandler(FruitShopStorage fruitShopStorage) {
        this.fruitShopStorage = fruitShopStorage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int fruitInStorageQuantity = fruitShopStorage.getQuantity(fruitTransaction.getFruit());
        int balance = fruitInStorageQuantity + fruitTransaction.getQuantity();
        fruitShopStorage.put(fruitTransaction.getFruit(), balance);
    }
}
