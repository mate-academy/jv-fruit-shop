package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int MIN_AMOUNT = 0;

    void updateStorage(FruitTransaction transaction);

    default void validAmount(FruitTransaction transaction) {
        if (transaction.getAmount() < MIN_AMOUNT) {
            throw new RuntimeException("OPERATION " + transaction.getOperation()
                    + "! Amount is less then zero!!!");
        }
    }
}
