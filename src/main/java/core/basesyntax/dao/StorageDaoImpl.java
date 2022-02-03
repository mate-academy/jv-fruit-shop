package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    private final Storage storage = new Storage();

    @Override
    public void addFruit(Fruit fruit, int quantity) {
        storage.getStorageOfFruits().put(fruit, quantity);
    }

    @Override
    public Integer getQuantityByFruit(Fruit fruit) {
        return storage.getStorageOfFruits().get(fruit);
    }

    @Override
    public void subtractQuantityByFruit(Fruit fruit, int quantityToSubtract) {
        if (quantityToSubtract <= storage.getStorageOfFruits().get(fruit)) {
            storage.getStorageOfFruits().replace(fruit,
                    storage.getStorageOfFruits().get(fruit) - quantityToSubtract);
        }
    }

    @Override
    public void addQuantityByFruit(Fruit fruit, int quantityToAdd) {
        storage.getStorageOfFruits().replace(fruit,
                storage.getStorageOfFruits().get(fruit) + quantityToAdd);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return storage.getStorageOfFruits();
    }
}
