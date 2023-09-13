package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void add(Fruit fruit, Integer value) {
        Storage.storage.put(fruit, Storage.storage.getOrDefault(fruit, 0)
                + value);
    }

    @Override
    public void substractAmount(Fruit fruit, Integer amountToDelete) {
        if (Storage.storage.get(fruit) - amountToDelete < 0) {
            throw new RuntimeException(String.format("We have %d quantity of fruits but you "
                    + "want to buy %d", amountToDelete, Storage.storage.get(fruit)));
        }
        Storage.storage.put(fruit, Storage.storage.get(fruit) - amountToDelete);
    }

    @Override
    public Map<Fruit, Integer> get() {
        return Storage.storage;
    }
}
