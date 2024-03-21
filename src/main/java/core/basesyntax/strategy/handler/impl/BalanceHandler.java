package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.exception.BalanceReassigningException;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceHandler extends OperationHandler {

    public BalanceHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(Transaction transaction) {
        String product = transaction.product();
        int quantity = transaction.quantity();
        if (productStorage.getStorage().containsKey(product)) {
            throw new BalanceReassigningException("Balance can`t be reassigned! "
                    + "You have duplicate balance operation for product: " + product);
        }
        productStorage.getStorage().putIfAbsent(product, quantity);
    }
}
