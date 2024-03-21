package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.ProductTransaction;
import core.basesyntax.exception.PurchaseOperationException;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler extends OperationHandler {
    public PurchaseHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(ProductTransaction productTransaction) {
        String product = productTransaction.product();
        int quantity = productTransaction.quantity();
        Integer currentBalance = productStorage.getStorage().get(product);
        if (currentBalance < quantity) {
            throw new PurchaseOperationException(
                    "Unable to purchase product: " + product
                            + " balance is less than purchase quantity."
                            + System.lineSeparator()
                            + "Current balance: " + currentBalance
                            + System.lineSeparator()
                            + "Purchase quantity: " + quantity
            );
        }
        productStorage.getStorage().put(product, currentBalance - quantity);
    }
}
