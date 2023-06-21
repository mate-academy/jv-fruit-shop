package fruit.shop.service.strategy.impl;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;
import fruit.shop.service.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int result = Storage.FRUITS.get(transaction.getFruit()) - transaction.getValue();
        if (result >= 0) {
            Storage.FRUITS.put(transaction.getFruit(), result);
        } else {
            throw new RuntimeException("Not enough fruits!");
        }
    }
}
