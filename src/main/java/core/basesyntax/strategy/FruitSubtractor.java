package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;

public class FruitSubtractor implements FruitHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    public void handle(String fruit, int amount) {
        fruitDao.getStorage().merge(fruit, amount, (a, b) -> {
            if (a - b < 0) {
                throw new RuntimeException("Do not have enough fruits for purchasing");
            }
            return a - b;
        });
    }
}
