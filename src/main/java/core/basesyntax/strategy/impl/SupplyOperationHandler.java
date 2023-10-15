package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private Storage storage;

    public SupplyOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        Fruit fruit = transaction.getFruit();
        int currentQuantity = storage.getFruitQuantity(fruit);
        int supplyQuantity = transaction.getQuantity();
        int newQuantity = currentQuantity + supplyQuantity;

        if (supplyQuantity < 0) {
            throw new RuntimeException("Transaction \"supply\" can`t have negative value");
        }

        storage.setFruitQuantity(fruit, newQuantity);
    }
}
