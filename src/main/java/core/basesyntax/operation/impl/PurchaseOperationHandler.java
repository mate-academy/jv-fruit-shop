package core.basesyntax.operation.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final ProductStorage productStorage;

    public PurchaseOperationHandler(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    @Override
    public void execute(Transaction transaction) {
        Product stored = productStorage.getByName(transaction.getProduct().getName());
        stored.setQuantity(stored.getQuantity() - transaction.getProduct().getQuantity());
        if (stored.getQuantity() < 0) {
            throw new RuntimeException("Not enough fruit: " + stored.getName());
        }
        productStorage.put(stored);
    }
}
