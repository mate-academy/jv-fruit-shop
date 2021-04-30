package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;

public class SubtractOperation implements Operation {

    @Override
    public void apply(Fruit fruit, Integer quantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        if (fruitDao.get(fruit).isEmpty() || fruitDao.get(fruit).get() < quantity) {
            throw new RuntimeException("Client can't buy more than you have");
        }
        fruitDao.update(fruit, fruitDao.get(fruit).get() - quantity);
    }
}
