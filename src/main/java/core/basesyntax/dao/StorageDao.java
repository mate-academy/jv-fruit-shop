package core.basesyntax.dao;

import core.basesyntax.model.FruitModel;

public interface StorageDao {
    String addFruit(FruitModel fruitModel, Integer amount);

    Integer getFruit(FruitModel fruitModel, int amount);
}
