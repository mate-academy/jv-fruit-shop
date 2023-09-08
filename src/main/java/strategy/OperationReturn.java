package strategy;

import db.Storage;
import model.Transaction;

public class OperationReturn implements OperationStrategy {

    private Transaction transaction;

    public OperationReturn(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void handleOperation(Storage storage) {
        storage.addFruitInQuantity(transaction.getItemName(), transaction.getQuantity());
    }
}
