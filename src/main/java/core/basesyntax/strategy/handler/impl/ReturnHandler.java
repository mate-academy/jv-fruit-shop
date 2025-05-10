package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.exception.ReturnOperationException;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler extends OperationHandler {

    @Override
    public void handle(ProductTransaction productTransaction) {
        String product = productTransaction.product();
        int quantity = productTransaction.quantity();
        Integer currentBalance = ProductStorage.storage.get(product);
        if (!ProductStorage.storage.containsKey(product)) {
            throw new ReturnOperationException("Can`t return absent product" + product);
        }
        if (currentBalance < quantity) {
            throw new ReturnOperationException(
                    "Cannot return more product: " + product
                            + " than were bought!" + System.lineSeparator()
                            + "Quantity to return: " + quantity + System.lineSeparator()
                            + "Currently available balance: " + currentBalance
            );
        }
        ProductStorage.storage.put(product, currentBalance - quantity);
    }
}
