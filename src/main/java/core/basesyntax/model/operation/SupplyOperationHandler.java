package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private static final int DEFAULT_AMOUNT = 0;
    private final Storage storage;

    public SupplyOperationHandler(Storage storage) {
        this.storage = storage;
    }

    //Gets amount of fruit from storage or 0
    // adds supply amount to current
    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = storage.getInventory().getOrDefault(transaction.getFruit(),
                DEFAULT_AMOUNT);
        if (transaction.getQuantity() <= 0) {
            throw new RuntimeException("Supply operation requires at least one fruit quantity");
        }
        storage.getInventory().put(transaction.getFruit(),
                transaction.getQuantity() + currentAmount);
    }
}
