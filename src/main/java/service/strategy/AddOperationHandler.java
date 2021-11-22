package service.strategy;

import db.Storage;
import model.Fruit;
import model.Transaction;

public class AddOperationHandler implements OperationHandler {

    @Override
    public void execute(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getFruit().getName());
        int oldAmount = Storage.storage.getOrDefault(fruit, 0);
        int newAmount = oldAmount + transaction.getQuantity();
        Storage.storage.put(fruit, newAmount);
    }
}
