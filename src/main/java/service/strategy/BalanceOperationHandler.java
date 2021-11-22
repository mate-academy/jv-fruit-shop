package service.strategy;

import db.Storage;
import model.Fruit;
import model.Transaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void execute(Transaction transaction) {
        int fruitAmount = transaction.getQuantity();
        Storage.storage.put(new Fruit(transaction.getFruit().getName()), fruitAmount);
    }
}
