package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class RemovingHandler implements ActivityHandler {
    private final FruitStorageDao fruitStorageDao;

    public RemovingHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Fruit fruit = fruitStorageDao.get(fruitName);
            if (fruit == null) {
                throw new RuntimeException("Not enough " + fruitName
                        + " to purchase: " + quantity);
            }
            fruitStorageDao.remove(fruit);
        }
    }
}
