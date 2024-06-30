package util;

import model.FruitTransaction;

public class TransactionValidator {

    private TransactionValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void validate(FruitTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }

        if (transaction.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number, but was: "
                + transaction.getQuantity());
        }
    }
}
