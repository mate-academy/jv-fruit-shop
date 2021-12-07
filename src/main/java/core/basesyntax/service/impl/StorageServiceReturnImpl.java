package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class StorageServiceReturnImpl implements StorageService {
    private FruitDao fruitDao;

    public StorageServiceReturnImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operateSupply(String forFruitName, Integer quantity) {
        Fruit forFruit = fruitDao.get(forFruitName);

        Integer newQuantityFor = forFruit.getQuantityFruit() + quantity;
        forFruit.setQuantityFruit(newQuantityFor);

        fruitDao.update(forFruit);
    }
}
