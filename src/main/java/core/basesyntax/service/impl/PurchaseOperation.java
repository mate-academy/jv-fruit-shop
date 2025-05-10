package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperation implements OperationHandler {
    private final FruitStorage storage;

    public PurchaseOperation(FruitStorage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int purchaseQuantity = transaction.getQuantity();

        int currentQuantity = storage.getFruitQuantity(fruit);
        if (currentQuantity >= purchaseQuantity) {
            storage.updateFruitQuantity(fruit, currentQuantity - purchaseQuantity);
        } else {
            throw new IllegalArgumentException("Insufficient inventory to purchase " + fruit);
        }
    }
}
