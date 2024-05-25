package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface AdditionOperationHandler {
    String addToStorage(FruitModel fruitModel, int amount);
}
