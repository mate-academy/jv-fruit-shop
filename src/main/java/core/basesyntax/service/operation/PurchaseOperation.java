package core.basesyntax.service.operation;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;
import java.util.Objects;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = Objects.requireNonNull(storage, "storage is null");
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction == null) {
            throw new FruitShopException("Transaction is null");
        }
        String fruit = transaction.getFruit();
        int qty = transaction.getQuantity();
        if (qty < 0) {
            throw new FruitShopException("Quantity is negative in transaction: " + transaction);
        }
        storage.decrease(fruit, qty);
    }
}
