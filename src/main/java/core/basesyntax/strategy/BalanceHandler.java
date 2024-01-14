package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class BalanceHandler implements OperationHandler {
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Balance can't be less than 0");
        }
        fruitStorage.addData(fruit, quantity);
    }
}
