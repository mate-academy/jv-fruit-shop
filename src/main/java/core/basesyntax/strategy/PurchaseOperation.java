package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null) {
            throw new IllegalArgumentException("Transaction or fruit cannot be null");
        }

        int quantity = transaction.getQuantity();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Purchase quantity must be positive");
        }

        String fruit = transaction.getFruit();
        int currentQuantity = Storage.getFruitQuantity(fruit);
        int newQuantity = currentQuantity - quantity;

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock to complete purchase. "
                    + "Current balance: " + currentQuantity + ", requested: " + quantity);
        }

        Storage.setFruitQuantity(fruit, newQuantity);
    }
}

