package core.basesyntax.service.activities;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnStorageServiceImpl implements StorageService {
    private FruitDao fruitDao;

    public ReturnStorageServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String nameFruit, int quantity) {
        Fruit fruit = fruitDao.get(nameFruit);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
        fruitDao.update(fruit);
    }
}
