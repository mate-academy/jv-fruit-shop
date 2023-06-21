package fruit.shop.service.strategy.impl;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;
import fruit.shop.service.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.FRUITS.put(transaction.getFruit(), transaction.getValue());
    }
}
