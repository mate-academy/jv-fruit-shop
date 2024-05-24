package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface RemoveTransaction {
    int getFruitFromStorage(FruitModel fruitModel, int amount);
}
