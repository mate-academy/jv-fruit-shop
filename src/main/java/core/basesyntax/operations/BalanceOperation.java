package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative.");
        }

        int currentQuantity = storage.getQuantity(transaction.getFruit());
    }
}
