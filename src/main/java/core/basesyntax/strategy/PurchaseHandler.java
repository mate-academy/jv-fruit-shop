package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        fruitStorage.reduceQuantity(fruit, quantity);
    }
}
