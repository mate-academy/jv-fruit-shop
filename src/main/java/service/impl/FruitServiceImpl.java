package service.impl;

import db.Storage;
import service.FruitService;

public class FruitServiceImpl implements FruitService {
    @Override
    public void put(String name, Integer amount) {
        Storage.put(name, amount);
    }

    @Override
    public Integer get(String name) {
        return Storage.fruits.get(name);
    }

    @Override
    public String getFruitReport() {
        return Storage.stringReport();
    }
}
