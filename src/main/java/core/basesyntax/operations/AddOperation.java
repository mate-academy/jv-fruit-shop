package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;

public class AddOperation implements Operation {
    private static final Integer DEFAULT_QUANTITY = 0;
    private static final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(Fruit fruit, Integer quantity) {
        fruitDao.update(fruit, fruitDao.get(fruit).orElse(DEFAULT_QUANTITY) + quantity);
    }
}
