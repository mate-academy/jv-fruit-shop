package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface FruitService {
    void addNewFruit(Fruit.TYPE type, Integer value, Fruit.ACTIVITY activity);
}
