package core.basesyntax.operationshandlers;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int MIN_AMOUNT = 0;

    void updateValueInStorage(FruitTransaction transaction);

    default void validAmount(FruitTransaction transaction) {
        if (transaction.getQuantity() < MIN_AMOUNT) {
            throw new RuntimeException("Operation " + transaction.getOperation()
                    + "is less than zero");
        }
    }
}
