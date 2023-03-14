package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if ((transaction.getQuantity() > Storage.fruits
                .get(Storage.fruits.get(transaction.getFruit())))) {
            throw new RuntimeException("Storage hasn't enough products to purchase");
        }
        Storage.fruits.put(transaction.getFruit(),
                Storage.fruits.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
