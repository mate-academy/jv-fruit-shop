package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public interface OperationHandler {
    void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity);
}
