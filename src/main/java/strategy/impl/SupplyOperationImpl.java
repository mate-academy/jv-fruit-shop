package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
        Storage.put(fruitTransaction.getFruit(), amount + fruitTransaction.getQuantity());
    }
}
