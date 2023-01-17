package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceStrategyOperationImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getFruit() == null || transaction.getOperation() == null) {
            throw new RuntimeException("Fruit can't be null");
        }
        String fruitName = transaction.getFruit();
        int balanceQuantity = transaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName)
                != null ? Storage.fruits.get(fruitName) : 0;
        int resultQuantity = oldQuantity + balanceQuantity;
        if (resultQuantity < 0) {
            throw new RuntimeException("Quantity can't be negative: " + transaction.getFruit());
        }
        Storage.fruits.put(fruitName, resultQuantity);

    }
}
