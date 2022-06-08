package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;

public class FruitAdder implements FruitHandler {
    @Override
    public void handle(String fruit, int amount) {
        FruitDao.getStorage().merge(fruit, amount, Integer::sum);
    }
}
