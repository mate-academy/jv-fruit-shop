package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class StorageServiceSupplyImpl implements StorageService {
    private FruitDao fruitDao;

    public StorageServiceSupplyImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operateSupply(String forFruitName, Double quantity) {
        Fruit forFruit = fruitDao.get(forFruitName);

        Double newQuantityFor = forFruit.getQuantityFruit() + quantity;
        forFruit.setQuantityFruit(newQuantityFor);

        fruitDao.update(forFruit);
    }
}
