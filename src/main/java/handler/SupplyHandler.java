package handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class SupplyHandler implements TransactionHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Storage.FRUITS.put(transaction.getFruit(),
                transaction.getQuantity() + Storage.FRUITS.get(transaction.getFruit()));
    }
}
