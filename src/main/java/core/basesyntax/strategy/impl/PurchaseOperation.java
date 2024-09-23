package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(HashMap<String, Integer> storage, FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int oldQuantity = storage.get(fruitName);
        int newQuantity = oldQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException(String.format(
                    "Error purchasing fruits. Available quantity: %d for %s, "
                            + "but trying to purchase %d.",
                    oldQuantity, fruitName, transaction.getQuantity()));
        }
        storage.put(fruitName, newQuantity);
    }
}
