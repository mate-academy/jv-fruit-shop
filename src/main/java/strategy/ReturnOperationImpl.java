package strategy;

import model.Fruit;
import model.Transaction;
import storage.Storage;

public class ReturnOperationImpl implements OperationHandler {

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit, currentQuantity + transaction.getQuantity());
    }
}
