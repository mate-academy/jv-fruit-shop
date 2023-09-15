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
        Integer quantityOfFruit = Storage.storage.get(fruit);
        if (quantityOfFruit - amountToDelete < 0) {
            throw new RuntimeException(String.format("We have %d quantity of %s but you "
                    + "want to buy %d", quantityOfFruit, fruit.getName(),amountToDelete));
        }
        Storage.storage.put(fruit, quantityOfFruit - amountToDelete);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.storage;
    }
}
