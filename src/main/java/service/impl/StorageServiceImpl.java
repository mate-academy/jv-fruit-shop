package service.impl;

import dao.FruitDao;
import service.StorageService;

public class StorageServiceImpl implements StorageService {
    private final FruitDao fruitDao;

    public StorageServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void add(String fruit, Integer quantity) {
        Integer availableQuantity = fruitDao.get(fruit);
        Integer newAmount = availableQuantity != null
                ? availableQuantity + quantity : quantity;
        fruitDao.add(fruit, newAmount);
    }

    @Override
    public void subtract(String fruit, Integer quantity) {
        Integer availableQuantity = fruitDao.get(fruit);
        Integer newAmount = availableQuantity != null
                ? availableQuantity - quantity : quantity;
        fruitDao.add(fruit, newAmount);
    }

    @Override
    public void set(String fruit, Integer quantity) {
        fruitDao.add(fruit, quantity);
    }
}
