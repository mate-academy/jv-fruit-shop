package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    @Override
    public void addFruit(Storage storage, Fruit fruit, int amount) {
        storage.getStorage().put(fruit, amount);
    }
}
