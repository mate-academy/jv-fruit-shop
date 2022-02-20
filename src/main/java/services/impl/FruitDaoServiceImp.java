package services.impl;

import db.Storage;
import model.Fruit;
import model.FruitRecord;
import services.FruitDaoService;

import java.util.HashSet;
import java.util.Set;

public class FruitDaoServiceImp implements FruitDaoService {
    Storage storage = new Storage();

    @Override
    public void put(FruitRecord fruitRecord) {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        for (Fruit fruitInStorage : fruitsInStorage) {
            if (fruitInStorage.getName().equals(fruitRecord.getNameOfFruit())) {
                fruitInStorage.setAmount(fruitInStorage.getAmount() + fruitRecord.getAmount());
                break;
            }
        }
    }

    @Override
    public void save(FruitRecord fruitRecord) {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        fruitsInStorage.add(new Fruit(fruitRecord.getNameOfFruit(), fruitRecord.getAmount()));
    }

    @Override
    public Set<Fruit> get() {
        return storage.getFruitsInStorage();
    }

    @Override
    public Set<Fruit> getAll() {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        Set<Fruit> newFruits = new HashSet<>();
        newFruits.addAll(fruitsInStorage);
        return newFruits;
    }
}
