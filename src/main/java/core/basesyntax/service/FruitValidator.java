package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public class FruitValidator {
    public boolean check(FruitTransaction transaction) {
        if (transaction == null) {
            return false;
        }

        if (transaction.getFruitName() == null || transaction.getFruitName().isBlank()) {
            return false;
        }

        if (transaction.getQuantity() < 0) {
            return false;
        }

        return transaction.getOperation() != null;
    }
}
