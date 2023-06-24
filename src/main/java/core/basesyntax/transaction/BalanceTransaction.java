package core.basesyntax.transaction;

import core.basesyntax.db.Storage;

public class BalanceTransaction implements OperationHandler {
    @Override
    public void handle(String fruit, int amount) {
        if (amount < 0) {
            throw new RuntimeException(
                    "Impossible set balance less than 0. Amount: "
                    + amount
            );
        }

        Storage.fruits.put(fruit, amount);
    }
}
