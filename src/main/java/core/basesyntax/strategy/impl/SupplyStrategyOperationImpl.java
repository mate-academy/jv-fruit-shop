package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyStrategyOperationImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getFruit() != null || transaction.getOperation() != null
                || Storage.fruits.get(transaction.getFruit()) != null) {
            String fruitName = transaction.getFruit();
            int resultQuantity = Storage.fruits.get(fruitName) + transaction.getQuantity();
            if (resultQuantity < 0) {
                throw new RuntimeException("Quantity can't be negative: " + transaction.getFruit());
            }
            Storage.fruits.put(fruitName, resultQuantity);
        } else {
            throw new RuntimeException("Fruit can't be null");
        }
    }
}
