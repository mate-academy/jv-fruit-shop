package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface AddTransaction {
    String addToStorage(FruitModel fruitType, int amount);
}
