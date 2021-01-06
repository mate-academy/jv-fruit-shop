package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
    @Override
    public void addFruit(Fruit fruit, int amount) {
        Storage.getStorage().put(fruit, amount);
    }
}
