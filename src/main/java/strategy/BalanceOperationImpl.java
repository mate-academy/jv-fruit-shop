package strategy;

import model.Fruit;
import model.Transaction;
import storage.Storage;

public class BalanceOperationImpl implements OperationHandler {
    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Storage.storage.put(fruit, transaction.getQuantity());
    }
}