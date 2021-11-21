package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.handler.WorkWithFruits;

public class FruitServiceImpl implements FruitService {
    WorkWithFruits workWithFruit;

    public FruitServiceImpl(WorkWithFruits workWithFruit) {
        this.workWithFruit = workWithFruit;
    }

    @Override
    public Fruit createFruit(String fruitName, int number) {
        return new Fruit(fruitName, number);
    }

}
