package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.exception.ReturnException;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnHandler extends OperationHandler {
    public ReturnHandler(ProductStorage productStorage) {
        super(productStorage);
    }

    @Override
    public void handle(Transaction transaction) {
        String product = transaction.product();
        int quantity = transaction.quantity();
        Integer currentBalance = productStorage.getStorage().get(product);
        if (!productStorage.getStorage().containsKey(product)) {
            throw new ReturnException("Can`t return absent product" + product);
        }
        if (currentBalance < quantity) {
            throw new ReturnException(
                    "Cannot return more product: " + product
                            + " than were bought!" + System.lineSeparator()
                            + "Quantity to return: " + quantity + System.lineSeparator()
                            + "Currently available balance: " + currentBalance
            );
        }
        productStorage.getStorage().put(product, currentBalance - quantity);
    }
}
