package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;

public class FruitAdder implements FruitHandler {
    private final FruitDao fruitDao;

    public FruitAdder() {
        fruitDao = new FruitDaoImpl();
    }

    public void handle(String fruit, int amount) {
        fruitDao.getStorage().merge(fruit, amount, Integer::sum);
    }
}
