package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public interface FruitService {
    void addFruit(Storage storage, Fruit fruit, int amount);
}
