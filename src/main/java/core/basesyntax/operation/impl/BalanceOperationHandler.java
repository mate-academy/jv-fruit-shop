package core.basesyntax.operation.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final ProductStorage productStorage;

    public BalanceOperationHandler(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    @Override
    public void execute(Transaction transaction) {
        productStorage.put(transaction.getProduct());
    }
}
