package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;
import core.basesyntax.storage.Storage;
import java.util.HashSet;
import java.util.Set;

public class FruitDaoServiceImp implements FruitDaoService {
    private Storage storage;

    public FruitDaoServiceImp(Storage storage) {
        this.storage = storage;
    }

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
