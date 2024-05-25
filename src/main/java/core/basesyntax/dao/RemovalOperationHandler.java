package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface RemovalOperationHandler {
    int getFruitFromStorage(FruitModel fruitModel, int amount);
}
