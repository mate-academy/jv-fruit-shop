package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class RemovingHandler implements ActivityHandler {
    private final FruitDao fruitDao;

    public RemovingHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String fruitName, int value) {
        for (int i = 0; i < value; i++) {
            Fruit fruit = fruitDao.get(fruitName);
            if (fruit == null) {
                throw new RuntimeException("Not enough " + fruitName
                        + " to purchase: " + value);
            }
            fruitDao.remove(fruit);
        }
    }
}
