package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public class FruitDaoImplReturn implements FruitDao {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        return new FruitDaoImplSupply().update(fruit, amount);
    }
}
