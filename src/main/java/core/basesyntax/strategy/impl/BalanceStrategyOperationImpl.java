package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceStrategyOperationImpl implements OperationHandler {
    private static final int ZERO = 0;

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int balanceQuantity = transaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName)
                != null ? Storage.fruits.get(fruitName) : ZERO;
        Storage.fruits.put(fruitName, oldQuantity + balanceQuantity);
    }
}
