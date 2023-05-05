package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface FruitService {
    Fruit getFruit(String fruitName);

    void addFruit(String fruit, int quantity);

    void updateFruit(Fruit fruit, int quantity);
}
