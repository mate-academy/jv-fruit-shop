package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
