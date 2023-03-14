package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyCalculator;

public class PurchaseHandler implements StrategyCalculator {
    public static final int EMPTY_VALUE = 0;

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        int currentBalance = Storage.STORAGE.getOrDefault(fruitTransaction.getFruit(), EMPTY_VALUE);
        int updatedBalance = currentBalance - fruitTransaction.getQuantity();
        if (updatedBalance < EMPTY_VALUE) {
            throw new RuntimeException("Not enough quantity available in storage");
        }
        Storage.STORAGE.put(fruitTransaction.getFruit(), updatedBalance);
    }
}
