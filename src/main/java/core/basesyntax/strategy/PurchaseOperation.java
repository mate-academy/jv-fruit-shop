package core.basesyntax.strategy;

import core.basesyntax.common.FruitTransaction;
import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction must not be null");
        }
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new RuntimeException("Fruit name must not be null or empty in transaction: "
                    + fruitTransaction);
        }
        int purchaseQuantity = fruitTransaction.getQuantity();
        if (purchaseQuantity < 0) {
            throw new RuntimeException("Purchase quantity must be non-negative in transaction: "
                    + fruitTransaction);
        }
        int currentStock = Storage.getQuantity(fruit);
        int newStock = currentStock - purchaseQuantity;
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock for fruit '" + fruit
                    + "'. Requested: " + purchaseQuantity + ", available: " + currentStock);
        }
        Storage.setQuantity(fruit, newStock);
    }
}
