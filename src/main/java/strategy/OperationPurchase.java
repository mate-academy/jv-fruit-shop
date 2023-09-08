package strategy;

import db.Storage;
import model.Transaction;

public class OperationPurchase implements OperationStrategy {
    private Transaction transaction;

    public OperationPurchase(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void handleOperation(Storage storage) {
        if (storage.getQuantity(transaction.getItemName()) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in Storage for purchase");
        }
        storage.removeFruitInQuantity(transaction.getItemName(), transaction.getQuantity());
    }
}
