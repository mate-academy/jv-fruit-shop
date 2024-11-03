package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int purchaseQuantity = transaction.getQuantity();

        if (Storage.getFruits().containsKey(fruit)) {
            int currentQuantity = Storage.getFruits().get(fruit);
            if (currentQuantity >= purchaseQuantity) {
                Storage.getFruits().put(fruit, currentQuantity - purchaseQuantity);
            } else {
                throw new IllegalArgumentException("Insufficient inventory to purchase " + fruit);
            }
        } else {
            throw new IllegalArgumentException("Fruit " + fruit + " out of stock");
        }
    }
}
