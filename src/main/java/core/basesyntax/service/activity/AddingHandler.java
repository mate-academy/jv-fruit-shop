package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class AddingHandler implements ActivityHandler {
    private final FruitStorageDao fruitStorageDao;

    public AddingHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void apply(String fruitName, int quantity) {
        for (int i = 0; i < quantity; i++) {
            fruitStorageDao.add(new Fruit(fruitName));
        }
    }
}
