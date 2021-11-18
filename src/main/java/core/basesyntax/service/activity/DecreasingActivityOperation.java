package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class DecreasingActivityOperation implements ActivityOperation {
    private final FruitDao fruitBoxDao;

    public DecreasingActivityOperation(FruitDao fruitBoxDao) {
        this.fruitBoxDao = fruitBoxDao;
    }

    @Override
    public void apply(String fruitName, int value) {
        for (int i = 0; i < value; i++) {
            Fruit fruit = fruitBoxDao.get(fruitName);
            if (fruit == null) {
                throw new RuntimeException("Not enough fruit to purchase: " + value);
            }
            fruitBoxDao.remove(fruit);
        }
    }
}
