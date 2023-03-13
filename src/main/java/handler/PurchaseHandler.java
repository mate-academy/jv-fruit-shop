package handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Storage.FRUITS.put(transaction.getFruit(),
                Storage.FRUITS.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
