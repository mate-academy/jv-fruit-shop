package strategy;

import db.Storage;
import model.FruitTransaction;

public class OperationReturn implements OperationStrategy {
    private final Storage storage;

    public OperationReturn(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        storage.addFruitInQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
