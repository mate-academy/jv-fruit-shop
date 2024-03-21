package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.exception.PurchaseException;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseHandler extends OperationHandler {
    public PurchaseHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(Transaction transaction) {
        String product = transaction.product();
        int quantity = transaction.quantity();
        Integer currentBalance = productStorage.getStorage().get(product);
        if (currentBalance < quantity) {
            throw new PurchaseException(
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
