package service.impl;

import dao.FruitDao;
import java.util.List;
import java.util.stream.Collectors;
import service.StorageService;

public class StorageServiceImpl implements StorageService {
    private FruitDao fruitDao;

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

    @Override
    public List<String[]> getBalance() {
        return fruitDao.getAll().stream()
                .map(i -> new String[]{i.getKey(), String.valueOf(i.getValue())})
                .collect(Collectors.toList());
    }
}
