package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class FruitTransactionCheckerImpl implements FruitTransactionChecker {
    @Override
    public void checkValue(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity of " + fruitTransaction.getFruitName()
                    + "must be > 0, but it's: " + fruitTransaction.getQuantity());
        }
    }
}
