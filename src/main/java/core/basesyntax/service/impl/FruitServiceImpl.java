package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {

    @Override
    public Fruit createNewFruit(String fruitName) {
        Fruit fruit = new Fruit(fruitName);
        return fruit;
    }
}
