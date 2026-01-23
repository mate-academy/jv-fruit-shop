package core.basesyntax.utility;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionValidatorImpl implements FruitTransactionValidator {
    @Override
    public ValidateData validate(Storage storage, FruitTransaction fruitTransaction) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage can't be null");
        }
        if (fruitTransaction == null) {
            throw new IllegalArgumentException("FruitTransaction can't be null");
        }
        String rawFruit = fruitTransaction.getFruit();
        if (rawFruit == null) {
            throw new IllegalArgumentException("Fruit can't be null");
        }
        String fruit = rawFruit.trim().toLowerCase();
        if (fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit can't be empty");
        }
        int quantity = fruitTransaction.getQuantity();
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be >= 0");
        }
        return new ValidateData(fruit, quantity);
    }
}
