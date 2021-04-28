package core.basesyntax.store;

import core.basesyntax.model.Fruit;

public interface FruitService {
    void createNewFruit(String name, long quantity);

    Fruit makeFruit(String name, long quantity);
}
