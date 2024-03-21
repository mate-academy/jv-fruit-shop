package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.exception.BalanceOperationException;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceHandler extends OperationHandler {

    public BalanceHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(ProductTransaction productTransaction) {
        String product = productTransaction.product();
        int quantity = productTransaction.quantity();
        if (productStorage.getStorage().containsKey(product)) {
            throw new BalanceOperationException("Balance can`t be reassigned! "
                    + "You have duplicate balance operation for product: " + product);
        }
        productStorage.getStorage().putIfAbsent(product, quantity);
    }
}
