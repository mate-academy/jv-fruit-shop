package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitTransactionHandler implements FruitTransactionHandler {
    private static final int ZERO = 0;
    private final Storage storage;

    public PurchaseFruitTransactionHandler(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("Storage must not be null");
        }
        this.storage = storage;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction cannot be null");
        }
        String fruit = fruitTransaction.getFruit();
        if (fruit == null || fruit.isBlank()) {
            throw new RuntimeException("Fruit name cannot be null or blank");
        }
        int quantity = fruitTransaction.getQuantity();
        if (quantity < ZERO) {
            throw new RuntimeException("Quantity cannot be negative");
        }
        storage.delete(fruit, quantity);
    }
}
