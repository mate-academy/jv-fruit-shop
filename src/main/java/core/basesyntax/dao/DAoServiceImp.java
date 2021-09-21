package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.FruitRecord;
import core.basesyntax.storage.Storage;

import java.util.HashSet;
import java.util.Set;

public class DAoServiceImp implements DAoService {
    private Storage storage;

    public DAoServiceImp(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void changeAmountOfFruits(FruitRecord fruitRecord) {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        for (Fruit fruitInStorage : fruitsInStorage)
            if (fruitInStorage.getName().equals(fruitRecord.getNameOfFruit())) {
                fruitInStorage.setAmount(fruitInStorage.getAmount() + fruitRecord.getAmount());
                break;
            }
    }

    @Override
    public void addRemains(FruitRecord fruitRecord) {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        fruitsInStorage.add(new Fruit(fruitRecord.getNameOfFruit(), fruitRecord.getAmount()));
    }

    @Override
    public Set<Fruit> getSetOfFruitsInStorage() {
        return storage.getFruitsInStorage();
    }

    @Override
    public Set<Fruit> getWholeStorageCopy() {
        Set<Fruit> fruitsInStorage = storage.getFruitsInStorage();
        Set<Fruit> newFruits = new HashSet<>();
        fruitsInStorage.forEach(e -> newFruits.add(e));
        return newFruits;
    }
}
