package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public class FruitServiceImpl implements FruitService {
    @Override
    public Fruit createNewFruit(String fruitName) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        return fruit;
    }
}
