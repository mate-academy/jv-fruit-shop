package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(Storage storage, FruitTransaction transaction) throws RuntimeException {
            String fruitName = transaction.getFruit();
            int oldQuantity = storage.get(fruitName);
            int newQuantity = oldQuantity - transaction.getQuantity();
            if (newQuantity < 0) {
                throw new RuntimeException(String.format(
                        "Error purchasing fruits. Available quantity: %d for %s, " +
                                "but trying to purchase %d.", oldQuantity, fruitName, transaction.getQuantity()));
            }
            storage.change(fruitName, newQuantity);
    }
}
