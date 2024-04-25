package service.impl;

import dao.FruitDao;
import java.util.Map;
import model.FruitType;
import service.SaveToStorage;

public class SaveToStorageImpl implements SaveToStorage {
    private static FruitDao fruitDao;

    public SaveToStorageImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void writeToDataBase(Map<FruitType, Integer> listCountedFruit) {
        listCountedFruit.entrySet().stream()
                .forEach(entry -> fruitDao.put(entry.getKey(), entry.getValue()));
    }
}
