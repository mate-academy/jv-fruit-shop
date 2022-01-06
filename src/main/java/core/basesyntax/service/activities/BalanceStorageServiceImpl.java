package core.basesyntax.service.activities;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class BalanceStorageServiceImpl implements StorageService {
    private FruitDao fruitDao;

    public BalanceStorageServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String nameFruit, int quantity) {
        Fruit fruit = new Fruit();
        fruit.setName(nameFruit);
        fruit.setQuantity(quantity);
        fruitDao.add(fruit);

    }
}
