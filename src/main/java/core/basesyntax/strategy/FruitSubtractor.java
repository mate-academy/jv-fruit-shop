package core.basesyntax.strategy;

import core.basesyntax.db.FruitDao;

public class FruitSubtractor implements FruitHandler {
    @Override
    public void handle(String fruit, int amount) {
        FruitDao.getStorage().merge(fruit, amount, (a, b) -> {
            if (a - b < 0) {
                throw new RuntimeException("Do not have enough fruits for purchasing");
            }
            return a - b;
        });
    }
}
