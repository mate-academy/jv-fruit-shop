package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class FruitTransactionValidatorImpl implements FruitTransactionValidator {
    @Override
    public void validate(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity of " + fruitTransaction.getFruitName()
                    + "must be > 0, but it's: " + fruitTransaction.getQuantity());
        }
    }
}
