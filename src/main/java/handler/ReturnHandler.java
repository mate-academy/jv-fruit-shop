package handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class ReturnHandler implements TransactionHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(),
                transaction.getQuantity() + Storage.fruits.get(transaction.getFruit()));
    }
}
