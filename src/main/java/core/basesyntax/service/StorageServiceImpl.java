package core.basesyntax.service;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void add(Fruit fruit, int amount) {
        Map<Fruit, Integer> fromStorage = storageDao.getFromStorage();
        if (fromStorage.keySet().contains(fruit)) {
            fromStorage.replace(new Fruit(fruit.getName()),
                    fromStorage.get(fruit), amount + fromStorage.get(fruit));
        } else {
            storageDao.addToStorage(fruit, amount);
        }
    }

    @Override
    public void get(Fruit fruit, int amount) {
        Map<Fruit, Integer> fromStorage = storageDao.getFromStorage();
        if (!fromStorage.keySet().contains(fruit)) {
            throw new RuntimeException("There is no such fruit in the store");
        }
        if (fromStorage.get(fruit) < amount) {
            throw new RuntimeException("There is no such amount in the store. The remnant is "
                    + fromStorage.get(fruit));
        } else {
            fromStorage.get(fruit);
        }
    }

    @Override
    public void updateStorage(Fruit fruit, int amount) {
        storageDao.addToStorage(fruit, amount);
    }
}
