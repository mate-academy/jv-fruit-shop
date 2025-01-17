package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final Storage storage;
    private static final int DEFAULT_AMOUNT = 0;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = storage.getInventory().getOrDefault(transaction.getFruit(),
                DEFAULT_AMOUNT);
        storage.getInventory().put(transaction.getFruit(),
                currentAmount - transaction.getQuantity());
    }
}
