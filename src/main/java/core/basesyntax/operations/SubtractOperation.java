package core.basesyntax.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;

public class SubtractOperation implements Operation {
    private static final Integer DEFAULT_QUANTITY = 0;
    private static final String EXCEPTION_MESSAGE = "Client can't buy more than you have";

    @Override
    public void apply(Fruit fruit, Integer quantity) {
        FruitDao fruitDao = new FruitDaoImpl();
        if (fruitDao.get(fruit).orElse(DEFAULT_QUANTITY) < quantity) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}
