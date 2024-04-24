package service.impl;

import dao.FruitDao;
import java.util.Map;
import model.FruitType;
import service.WriteToStorage;

public class WriteToStorageImpl implements WriteToStorage {
    private static FruitDao fruitDao;

    public WriteToStorageImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void writeToDataBase(Map<FruitType, Integer> listCountedFruit) {
        listCountedFruit.entrySet().stream()
                .forEach(entry -> fruitDao.put(entry.getKey(), entry.getValue()));
    }
}
