package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        int currentQuantity = storage.getQuantity(transaction.getFruit());
        int newQuantity = currentQuantity + transaction.getQuantity();

        storage.updateFruit(transaction.getFruit(), newQuantity);
    }
}
