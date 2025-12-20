package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!storage.findFruit(fruit)) {
            throw new IllegalArgumentException("Fruit " + fruit + " not found");
        }
        int currentQuantity = storage.getFruitQuantity(fruit);
        int purchaseQuantity = transaction.getQuantity();
        if (currentQuantity < purchaseQuantity) {
            throw new IllegalArgumentException(
                    "Purchase quantity less than current quantity in storage: "
                            + currentQuantity + " < " + purchaseQuantity);
        }
        storage.addFruit(fruit, currentQuantity - purchaseQuantity);
    }
}
