package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitMovement;
import core.basesyntax.storage.filestorage.FileStorage;

import java.util.List;
import java.util.Map;

public class DaoFromFileStorage implements Dao{
    private final FileStorage storage;

    public DaoFromFileStorage(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Fruit> getAllFruits() {
        return storage.getAllFruits();
    }

    @Override
    public List<FruitMovement> getTransactionsOff(Fruit fruit) {
        return storage.getTransactionOf(fruit);
    }

    @Override
    public void saveResults(Map<Fruit, Integer> results) {
        storage.saveReport(results);
    }
}
