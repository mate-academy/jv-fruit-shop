package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    private final Storage storage;

    public FruitDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void addNewFruit(Fruit fruit, int quantity) {
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
