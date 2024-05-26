package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface StorageDao {
    String addFruit(FruitModel fruitModel, int amount);

    Integer updateFruitAmount(FruitModel fruitModel, int amount);
}
