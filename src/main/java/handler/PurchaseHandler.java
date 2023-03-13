package handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
