package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_AMOUNT = 0;
    private final Storage storage;

    public PurchaseOperationHandler(Storage storage) {
        this.storage = storage;
    }

    // Gets current amount of fruit or 0 from storage.
    // if not enough in storage or transaction amount is not positive
    // number throws exception
    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = storage.getInventory().getOrDefault(transaction.getFruit(),
                DEFAULT_AMOUNT);
        if (currentAmount < transaction.getQuantity() || transaction.getQuantity() <= 0) {
            throw new RuntimeException("Purchase amount is invalid "
                    + "or not enough products in storage");
        }
        storage.getInventory().put(transaction.getFruit(),
                currentAmount - transaction.getQuantity());
    }
}
