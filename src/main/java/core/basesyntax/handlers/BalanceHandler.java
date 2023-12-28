package core.basesyntax.handlers;

import core.basesyntax.db.FruitStorage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void calculateResult(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Initial quantity of " + fruit
                    + " is " + quantity + ". It can't be negative");
        }
        FruitStorage.storageData.put(fruit,quantity);
    }
}
