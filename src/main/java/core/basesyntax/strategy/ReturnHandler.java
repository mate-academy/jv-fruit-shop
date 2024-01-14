package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        fruitStorage.addQuantity(fruit, quantity);
    }
}
