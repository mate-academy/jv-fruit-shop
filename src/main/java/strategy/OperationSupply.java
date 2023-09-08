package strategy;

import db.Storage;
import model.Transaction;

public class OperationSupply implements OperationStrategy {

    private Transaction transaction;

    public OperationSupply(Transaction fruitTransaction) {
        this.transaction = fruitTransaction;
    }

    @Override
    public void handleOperation(Storage storage) {
        storage.addFruitInQuantity(transaction.getItemName(), transaction.getQuantity());
    }
}
