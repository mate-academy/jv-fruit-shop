package fruit.shop.service.strategy.impl;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;
import fruit.shop.service.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = Storage.FRUITS.get(transaction.getFruit());
        Storage.FRUITS.put(transaction.getFruit(), currentValue + transaction.getValue());
    }
}
