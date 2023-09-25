package strategy;

import db.Storage;
import model.FruitTransaction;

public class OperationPurchase implements OperationStrategy {
    private final Storage storage;

    public OperationPurchase(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        if (storage.getQuantity(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Not enough fruits in Storage for purchase");
        }
        storage.removeFruitInQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
