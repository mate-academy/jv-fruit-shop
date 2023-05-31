package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceHandler implements FruitTransactionHandler {
    private static final int MINIMUM_BALANCE_AMOUNT = 1;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < MINIMUM_BALANCE_AMOUNT) {
            throw new RuntimeException(
                    "Balance-transaction quantity cannot be less than "
                            + MINIMUM_BALANCE_AMOUNT);
        }
        Storage.storageMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
