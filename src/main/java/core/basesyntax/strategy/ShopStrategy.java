package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public interface ShopStrategy {
    void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity);
}
