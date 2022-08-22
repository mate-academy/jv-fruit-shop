package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.filestorage.FileStorage;

import java.util.List;
import java.util.Map;

public class DaoFromFileStorage implements Dao{
    private FileStorage storage;

    public DaoFromFileStorage(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Fruit> getAllFruits() {
        return null;
    }

    @Override
    public List<FruitMovement> getTransactionsOff(Fruit fruit) {
        return null;
    }

    @Override
    public void saveResults(Map<Fruit, Integer> results) {

    }
}
